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

    $(document).ready(function() {
        // Función que se ejecuta al hacer clic en el botón de borrar
        $('#botonBorrar').click(function() {
            // Verificar si hay un evento seleccionado actualmente
            if (eventoActual) {
    
                // Hacer una petición AJAX al servidor para borrar el evento
                $.ajax({
                    url: '/events/'+eventoActual.id, 
                    type: 'DELETE', 
                    success: function() {
                        $('#CalendarioWeb').fullCalendar('removeEvents', eventoActual.id);
                        $('#modalEvento').modal('hide'); 
                        eventoActual = null; 
                    },
                    error: function(error) {
                        // En caso de un error, mostrarlo en la consola
                        console.log(error);
                    } 
                });
                console.log(eventoActual.id + " Evento a borrar");
            }
        });
    });    

    $('#botonGuardar').click(function() {
        if (eventoActual) {
            console.log(eventoActual.id+"EventoActual")
            var nombre = $('#editNombreActividad').val();
            var descripcion = $('#editDescripcionActividad').val();
            var fechaActividad = $('#editFechaActividad').val();
            var horaActividad = $('#editHoraActividad').val()+":00";

            var start = moment(fechaActividad + 'T' + horaActividad);

            var updateEvento = {
                id_evento: eventoActual.id,
                nombre: nombre,
                descripcion: descripcion,
                fechaActividad: fechaActividad,
                horaActividad: horaActividad,
            };

            $.ajax({
                url:'/events/updateEvents',
                type: 'PUT',
                dataType: 'JSON',
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify(updateEvento),
                success: function(){

                    eventoActual.title = nombre;
                    eventoActual.start = start;
                    eventoActual.description = descripcion;

                    // Informa a FullCalendar sobre la actualización del evento
                    $('#CalendarioWeb').fullCalendar('updateEvent', eventoActual);

                    // Cierra el modal después de la actualización
                    $('#modalEvento').modal('hide'); 
                },
                error: function(error){
                    console.log(error);
                }
            });
        }
    });

    $('form').on('submit', function(e) {
        e.preventDefault(); 
    
        var nombreActividad = $('#nombreActividad').val();
        var descripcionActividad = $('#descripcionActividad').val();
        var fechaActividad = $('#fechaActividad').val();
        var horaActividad = $('#horaActividad').val()+":00";

        var nuevoEvento = {
            nombre: nombreActividad,
            descripcion: descripcionActividad,
            fechaActividad: fechaActividad,
            horaActividad: horaActividad,
        };

        $.ajax({
            url: '/events/addEvents',
            type: 'POST',
            dataType:'JSON',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(nuevoEvento),
            success: function(eventoGuardado) {
                $('#CalendarioWeb').fullCalendar('renderEvent', {
                    id: eventoGuardado.id_evento,
                    title: eventoGuardado.nombre,
                    start: moment(eventoGuardado.fechaActividad + 'T' + eventoGuardado.horaActividad),
                    description: eventoGuardado.descripcion,
                }, true);

                $('#nombreActividad').val('');
                $('#descripcionActividad').val('');
                $('#fechaActividad').val('');
                $('#horaActividad').val('');
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
                console.log(evento.id_evento+" evento");
                var eventoCalendario = {
                    id: evento.id_evento,
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

function configureSaveButton() {
    $('#botonGuardar').click(function() {
        var nombre = $('#editNombreActividad').val();
        var descripcion = $('#editDescripcionActividad').val();
        var fechaActividad = $('#editFechaActividad').val();
        var horaActividad = $('#editHoraActividad').val()+":00";

        var nuevoEvento = {
            nombre: nombre,
            descripcion: descripcion,
            fechaActividad: fechaActividad,
            horaActividad: horaActividad,

        };

        $.ajax({
            url: '/events/addEvents',
            type: 'POST',
            dataType:'JSON',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(nuevoEvento),
            success: function(eventoGuardado) {
                $('#CalendarioWeb').fullCalendar('renderEvent', {
                    id: eventoGuardado.id_evento,
                    title: eventoGuardado.nombre,
                    start: moment(eventoGuardado.fechaActividad + 'T' + eventoGuardado.horaActividad),
                    description: eventoGuardado.descripcion,
                }, true);
                $('#modalEvento').modal('hide'); 
            },
            error: function(error) {
                console.log(error)
            } 
        });
    });
}

function loadActivities() {
    $.ajax({
        url: '/activities/getActivities',
        type: 'GET',
        success: function(activities) {
            var list = $('#listaActividades');
            list.empty(); 
            activities.forEach(function(activity) {
                console.log(activity.id_actividad + " Actividad");
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

                    configureSaveButton();
                });
                list.append(listItem);
            });
        },
        error: function() {
            alert('Error al cargar las actividades');
        }
    });

}

