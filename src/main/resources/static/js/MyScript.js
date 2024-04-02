$(document).ready(function() {
    loadActivities();
    var eventoActual;
    var calendario = $('#CalendarioWeb').fullCalendar({
        header: {
            left: 'today,prev,next',
            center: 'title',
            right: 'month,basicWeek,basicDay,agendaWeek,agendaDay'
        },
        eventClick: function(evento, jsEvent, view) {
            eventoActual = evento;
            
            // Actualiza los campos del formulario con los datos del evento seleccionado
            $('#editNombreActividad').val(evento.title);
            $('#editDescripcionActividad').val(evento.description);
            $('#editFechaActividad').val(moment(evento.start).format('YYYY-MM-DD'));
            $('#editHoraActividad').val(moment(evento.start).format('HH:mm'));
            if(evento.end) {
                $('#editHoraTerminado').val(moment(evento.end).format('HH:mm'));
            } else {
                $('#editHoraTerminado').val('');
            }
            $('#modalEvento').modal('show');
        },
        eventMouseover: function(evento, jsEvent, view) {
            $(jsEvent.currentTarget).tooltip({
                title: evento.description, // Utiliza la descripción del evento para el contenido del tooltip
                placement: 'top'
            });
            $(jsEvent.currentTarget).tooltip('show');
        },
        eventMouseout: function(evento, jsEvent, view) {
            $(jsEvent.currentTarget).tooltip('hide');
        },
    });

    $('#botonBorrar').click(function() {
        if (eventoActual) {
            var nombreActividad = $('#editNombreActividad').val();
            var descripcionActividad = $('#editDescripcionActividad').val();
            var fechaActividad = $('#editFechaActividad').val();
            var horaActividad = $('#editHoraActividad').val()+":00";

            var borrarEvento = {
                nombre: nombreActividad,
                descripcion: descripcionActividad,
                fechaActividad: fechaActividad,
                horaActividad: horaActividad,
            };
            $.ajax({
                url: '/events/deleteEvent',
                type: 'DELETE',
                dataType:'JSON',
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify(borrarEvento),
                success: function() {
                    $('#CalendarioWeb').fullCalendar('removeEvents', eventoActual._id);
                    $('#modalEvento').modal('hide');
                    eventoActual = null;    
                },
                error: function(error) {
                    console.log(error)
                } 
            });
        }
    });

    $('#botonGuardar').click(function() {
        if (eventoActual) {
            console.log(eventoActual.id+"EventoActual")
            eventoActual.title = $('#editNombreActividad').val();
            eventoActual.description = $('#editDescripcionActividad').val();
            eventoActual.start = moment($('#editFechaActividad').val() + ' ' + $('#editHoraActividad').val()).format();
            var horaTerminado = $('#editHoraTerminado').val();
            if(horaTerminado) {
                var fechaTerminado = moment($('#editFechaActividad').val() + ' ' + horaTerminado);
                eventoActual.end = fechaTerminado.toDate();
            } else {
                delete eventoActual.end; // Elimina la hora de terminación si no se especificó
            }
        }
    });

    $('form').on('submit', function(e) {
        e.preventDefault(); 


        var activityId = $('#selectorActividad').val();
    
        var nombreActividad = $('#nombreActividad').val();
        var descripcionActividad = $('#descripcionActividad').val();
        var fechaActividad = $('#fechaActividad').val();
        var horaActividad = $('#horaActividad').val()+":00";

        var fechaYHoraInicio = moment(fechaActividad + ' ' + horaActividad);

        var nuevoEvento = {
            nombre: nombreActividad,
            descripcion: descripcionActividad,
            fechaActividad: fechaActividad,
            horaActividad: horaActividad,
            activity_id: activityId,
        };

        $.ajax({
            url: '/events/addEvents',
            type: 'POST',
            dataType:'JSON',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(nuevoEvento),
            success: function(eventoGuardado) {
                $('#CalendarioWeb').fullCalendar('renderEvent', {
                    id: eventoGuardado.id,
                    title: eventoGuardado.nombre,
                    start: moment(eventoGuardado.fechaActividad + 'T' + eventoGuardado.horaActividad),
                    description: eventoGuardado.descripcion,
                }, true);
            },
            error: function(error) {
                console.log(error)
            } 
        });
    });

    $.ajax({
        url: '/events/getEvents',
        type: 'GET',
        success: function(data) {
            data.forEach(function(evento) {
                console.log(evento.id+" evento");
                var eventoCalendario = {
                    id: evento.id,
                    title: evento.nombre,
                    start: moment(evento.fechaActividad + 'T' + evento.horaActividad),
                    description: evento.descripcion
                };
                $('#CalendarioWeb').fullCalendar('renderEvent', eventoCalendario, true);
            });
        },
        error: function() {
            alert('No se pudieron cargar los eventos');
        }
    });
});

function loadActivities() {
    $.ajax({
        url: '/activities/getActivities',
        type: 'GET',
        success: function(activities) {
            var list = $('#listaActividades');
            list.empty(); 
            activities.forEach(function(activity) {
                console.log(activity.id + " Actividad");
                var listItem = $('<li class="list-group-item">' + activity.nombre + '</li>');
                listItem.dblclick(function() {
                    console.log(activity.id);
                    // Configura el modal con la información de la actividad
                    $('#nombreActividad').val(activity.nombre);
                    $('#descripcionActividad').val(activity.descripcion);
                    // Abre el modal
                    $('#modalEvento').modal('show');
                    // Configura el modal para una nueva entrada
                    $('#modalEventoLabel').text('Crear Nuevo Evento');
                    $('#editNombreActividad').val(activity.nombre);
                    $('#editDescripcionActividad').val(activity.descripcion);
                    $('#editFechaActividad').val('');
                    $('#editHoraActividad').val('');
                    $('#editHoraTerminado').val('');
                    // Asegúrate de configurar el ID de la actividad seleccionada
                    $('#actividadSeleccionada').val(activity.nombre);
                });
                list.append(listItem);
            });
        },
        error: function() {
            alert('Error al cargar las actividades');
        }
    });
}

