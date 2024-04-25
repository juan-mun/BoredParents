$(document).ready(function() {
    getActividades();
});

$(document).on('click', 'table tbody tr', function() {
    var row = $(this);
    $('#actividadId').val(row.find('td:eq(0)').text()); // ID
    $('#nombre').val(row.find('td:eq(1)').text()); // Nombre
    $('#descripcion').val(row.find('td:eq(2)').text()); // Descripción
    $('#categoria').val(row.find('td:eq(3)').text()); // Categoría
    $('#duracion').val(row.find('td:eq(4)').text()); // Duración
    $('#createActivityModalLabel').text('Editar Actividad');
    $('#saveActivity').text('Guardar Cambios').attr("onclick", "updateActividad()");
    $('#createActivityModal').modal('show');
});

function addActividad(){
    var nombre = $('#nombre').val();
    var descripcion = $('#descripcion').val();
    var categoria = $('#categoria').val();
    var duracion = $('#duracion').val();

    var nuevoDato = {
        nombre: nombre,
        descripcion: descripcion,
        categoria: categoria,
        duracion: duracion
    }

    $.ajax({
        url: '/actividades/addActivity',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(nuevoDato),
        success: function(data) {
            // Cierra el modal
            $('#createActivityModal').modal('hide');

            // Limpia el formulario
            $('#createActivityForm')[0].reset();

            // Actualiza la tabla de actividades
            getActividades();
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.log(textStatus, errorThrown);
        }
    });

}

function getActividades() {
    $.ajax({
        url: '/actividades/getActivity', // Asegúrate de que esta URL sea correcta
        type: 'GET',
        dataType: 'json',
        success: function(data) {
            var tableBody = $('table tbody');
            tableBody.empty(); // Limpia la tabla antes de añadir los nuevos resultados

            // Itera sobre cada actividad y la añade a la tabla
            $.each(data, function(index, actividad) {
                tableBody.append(
                    '<tr>' +
                    '<td>' + actividad.id_actividad + '</td>' +
                    '<td>' + actividad.nombre + '</td>' +
                    '<td>' + actividad.descripcion + '</td>' +
                    '<td>' + actividad.categoria + '</td>' +
                    '<td>' + actividad.duracion + '</td>' +
                    '</tr>'
                );
            });
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.log(textStatus, errorThrown);
        }
    });
}

function deleteActividad(){
    var id = $('#actividadId').val();
    var actividadData = {
        id_actividad: id,
        nombre: $('#nombre').val(),
        descripcion: $('#descripcion').val(),
        categoria: $('#categoria').val(),
        duracion: $('#duracion').val()
    };
    $.ajax({
        url: '/actividades/' + id,
        type: 'DELETE',
        contentType: 'application/json',
        data: JSON.stringify(actividadData),
        success: function(data){
            $('#createActivityModal').modal('hide');
            $('#createActivityForm')[0].reset();
            getActividades();
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.log(textStatus, errorThrown, jqXHR);
        }
    });
}

function updateActividad() {
    var id = $('#actividadId').val();
    var actividadData = {
        id_actividad: id,
        nombre: $('#nombre').val(),
        descripcion: $('#descripcion').val(),
        categoria: $('#categoria').val(),
        duracion: $('#duracion').val()
    };

    $.ajax({
        url: '/actividades/updateActivity/' + id,
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(actividadData),
        success: function(data) {
            $('#createActivityModal').modal('hide');
            $('#createActivityForm')[0].reset();
            getActividades();
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.log(textStatus, errorThrown);
        }
    });
}