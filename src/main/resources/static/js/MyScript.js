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
        var horaActividad = $('#horaActividad').val();

        var fechaYHoraInicio = moment(fechaActividad + ' ' + horaActividad);

        var evento = {
            title: nombreActividad,
            start: fechaYHoraInicio.format(),
            description: descripcionActividad,
        };

        $('#CalendarioWeb').fullCalendar('renderEvent', evento, true); 

        this.reset();
    });
});
