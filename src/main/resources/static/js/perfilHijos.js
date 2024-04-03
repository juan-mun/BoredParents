$(document).ready(function() {
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
                var perfilHTML = '<div class="col-md-4">' +
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
    
    $.ajax({
        url:'Infantes/getInfantes',
        type:'GET',
        success: function(data){
            // Vaciar el contenedor antes de agregar nuevos perfiles
            $('#perfiles .row').empty();
    
            // Iterar sobre cada infante recibido
            $.each(data, function(i, infante) {
                var perfilHTML = '<div class="col-md-4">' +
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
    
});
    


