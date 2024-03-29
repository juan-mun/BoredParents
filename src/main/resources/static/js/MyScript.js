$(document).ready(function() {
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
            $('#CalendarioWeb').fullCalendar('removeEvents', eventoActual._id);
            $('#modalEvento').modal('hide');
            eventoActual = null;    
        }
    });

    $('#botonGuardar').click(function() {
        if (eventoActual) {
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
            $('#CalendarioWeb').fullCalendar('updateEvent', eventoActual);
            $('#modalEvento').modal('hide');
        }
    });

    $('form').on('submit', function(e) {
        e.preventDefault(); 

        var nombreActividad = $('#nombreActividad').val();
        var descripcionActividad = $('#descripcionActividad').val();
        var fechaActividad = $('#fechaActividad').val();
        var horaActividad = $('#horaActividad').val() + ":00"; // Asume que #horaActividad tiene un valor como '14:30'


        var fechaYHoraInicio = moment(fechaActividad + ' ' + horaActividad);

        var nuevoEvento = {
            nombre: nombreActividad,
            descripcion: descripcionActividad,
            fechaActividad: fechaActividad,
            horaActividad: horaActividad,
        };
        
        console.log(nuevoEvento.fechaActividad);
        console.log(nuevoEvento.horaActividad);

        $.ajax({
            url: '/events/addEvents',
            type: 'POST',
            dataType:'JSON',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(nuevoEvento),
            success: function(eventoGuardado) {
                // Agrega el evento al calendario si se guarda exitosamente
                $('#CalendarioWeb').fullCalendar('renderEvent', {
                    id: eventoGuardado.id,
                    title: eventoGuardado.nombre,
                    start: moment(eventoGuardado.fechaActividad + 'T' + eventoGuardado.horaActividad),
                    description: eventoGuardado.descripcion,
                }, true);
                this.reset();
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
