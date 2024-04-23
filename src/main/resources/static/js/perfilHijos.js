$(document).ready(function() {

    $('#deleteProfileModal').on('show.bs.modal', function (e) {
        var select = $('#perfilSelect');
        select.empty(); // Limpiar las opciones anteriores
        
        // Hacer la llamada AJAX para obtener los perfiles
        $.ajax({
            url: 'Infantes/getInfantes',
            type: 'GET',
            success: function(data) {
                // Llenar el select con los infantes recibidos
                $.each(data, function(i, infante) {
                    select.append($('<option>', {
                        value: infante.id_infante,
                        text: infante.nombre + ' ' + infante.apellido
                    }));
                });
            },
            error: function(error) {
                console.error('Error al cargar los perfiles', error);
                // Manejar el error
            }
        });
    });

    // Evento del click del botón Guardar
    $('#guardarBtn').click(function(e) {
        e.preventDefault();
        
        // Recolectar los datos del formulario
        var datosInfante = {
            nombre: $('#nombre').val(),
            apellido: $('#apellido').val(),
            fecha_nacimiento: $('#fechaNacimiento').val(),
        };
        
        $.ajax({
            url: 'Infantes/saveInfantes', 
            type: 'POST',
            dataType: 'JSON',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(datosInfante),
            success: function(response) {
                console.log('Perfil guardado con éxito', datosInfante);
                var perfilHTML = '<div class="col-md-4 clickable-profile " data-href="rutina.html">' +
                '<div class="profile-container">' +
                    '<div class="profile-circle">' +
                        '<img src="css/images/usuarioIcon.png" alt="Profile" class="profile-image">' +
                    '</div>' +
                    '<div class="profile-info">' +
                        '<h5 class="profile-name">' + datosInfante.nombre + '</h5>' + // Cambiado a datosInfante.nombre
                    '</div>' +
                '</div>' +
                '</div>'; 
                
                // Añadir el perfil al contenedor
                $('#perfiles .row').append(perfilHTML); // Asegúrate de que este contenedor exista en tu HTML
                
                // Cerrar el modal después de añadir el perfil
                $('#addProfileModal').modal('hide');
            },
            error: function(error) {
                console.error('Error al guardar el perfil', error);
                // Manejar el error, por ejemplo, mostrando un mensaje al usuario
            }
        });
    });

    $('#eliminarBtn').click(function() {
        var selectedId = $('#perfilSelect').val();
        console.log(selectedId);
        if (selectedId) {
            $.ajax({
                url: 'Infantes/' + selectedId,
                type: 'DELETE',
                success: function(result) {
                    console.log('Perfil eliminado con éxito');
                    // Cerrar el modal y actualizar la lista de perfiles
                    $('#deleteProfileModal').modal('hide');
                    // Podrías llamar aquí a la función que carga los perfiles si existe o simplemente recargar la página
                    location.reload(); // Esta es la forma más simple de actualizar la lista
                },
                error: function(error) {
                    console.error('Error al eliminar el perfil', error);
                    // Manejar el error, por ejemplo, mostrando un mensaje al usuario
                }
            });
        }
    });
    
    $.ajax({
        url:'Infantes/getInfantes',
        type:'GET',
        success: function(data){
            // Vaciar el contenedor antes de agregar nuevos perfiles
            $('#perfiles .row').empty();
    
            // Iterar sobre cada infante recibido
            $.each(data, function(i, infante) {
                var perfilHTML = '<div class="col-md-4 clickable-profile " data-href="rutina.html">' +
                '<div class="profile-container">' +
                    '<div class="profile-circle">' +
                        '<img src="css/images/usuarioIcon.png" alt="Profile" class="profile-image">' +
                    '</div>' +
                    '<div class="profile-info">' +
                    '<h5 class="profile-name">' + infante.nombre + '</h5>';
                    '</div>' +
                '</div>' +
                '</div>'; 
                // Añadir el perfil al contenedor
                $('#perfiles .row').append(perfilHTML);
            });
        },
        error: function(xhr, status, error) {
            // Manejar el error
            console.error('Error al obtener los infantes', error);
        }
            
    });
    
    $(document).on('click', '.clickable-profile', function() {
        window.location.href = $(this).data('href');
    });

});


    


