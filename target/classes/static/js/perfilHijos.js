$(document).ready(function() {
    cargarPerfiles();
});

// Función para limpiar el token de localStorage
function logout() {
    var confirmLogout = confirm("¿Estás seguro de que deseas cerrar sesión?");
    
    localStorage.removeItem('token');
    window.location.href = "/vistas/index.html"
}

function agregarInteres() {
    const interesSelect = document.getElementById('interesesSelect');
    const interes = interesSelect.value;
    const interesesList = document.getElementById('interesesList');

    // Verifica que el interés no se haya agregado previamente
    if (!Array.from(interesesList.children).some(item => item.textContent.includes(interes))) {
        // Crear un nuevo elemento de lista para el interés seleccionado
        const interesItem = document.createElement('div');
        interesItem.classList.add('interes-item', 'd-flex', 'align-items-center');
        interesItem.textContent = interes;

        // Opcional: agregar un botón para eliminar el interés de la lista
        const deleteBtn = document.createElement('button');
        deleteBtn.textContent = 'Eliminar';
        deleteBtn.classList.add('btn', 'btn-danger', 'btn-sm', 'ms-2');
        deleteBtn.onclick = function() {
            interesesList.removeChild(interesItem);
        };
        interesItem.appendChild(deleteBtn);

        // Añadir el nuevo elemento a la lista de intereses
        interesesList.appendChild(interesItem);
    }
}

function seleccionarPerfil(idNino) {
    localStorage.setItem('idNinoActual', idNino);
    window.location.href = 'BibliotecaVirtual.html'; // Rediriges al niño a la biblioteca virtual
}

function eliminarPerfil() {
    var idNino = $('#perfilSelect').val(); // Obtiene el ID del perfil seleccionado
    $.ajax({
        url: '/ninos/' + idNino, // URL del endpoint para eliminar
        type: 'DELETE',
        success: function(response) {
            // Código para manejar la respuesta, como recargar la lista de perfiles
            alert('Perfil eliminado con éxito');
            $('#deleteProfileModal').modal('hide'); // Cierra el modal
            cargarPerfiles(); // Recarga los perfiles
        },
        error: function(error) {
            console.error('Error al eliminar el perfil:', error);
        }
    });
}

function cargarPerfiles() {
    var token = localStorage.getItem('miToken');
    $.ajax({
        url: '/ninos/getNinos',
        type: 'GET',
        beforeSend: function(xhr) {
            if (token) {
                xhr.setRequestHeader('Authorization', 'Bearer ' + token);
            }
        },
        success: function(data) {
            $('#perfiles .row').empty();
            $('#perfilSelect').empty();
            data.forEach(function(nino) {
                var perfilHTML = '<div class="col-md-4 clickable-profile" onclick="seleccionarPerfil(' + nino.id_nino + ')">' +
                    '<div class="profile-container">' +
                    '<div class="profile-circle">' +
                    '<img src=" ../' + nino.avatarUrl + '" alt="Profile" class="profile-image">' +
                    '</div>' +
                    '<div class="profile-info">' +
                    '<h5 class="profile-name">' + nino.nombre + '</h5>' +
                    '</div>' +
                    '</div>' +
                    '</div>';

                var optionHTML = '<option value="' + nino.id_nino + '">' + nino.nombre + '</option>';

                $('#perfiles .row').append(perfilHTML);
                $('#perfilSelect').append(optionHTML);
            });
        },
        error: function(error) {
            console.error('Error al cargar perfiles:', error);
        }
    });
}


function guardarPerfil() {
    const nombre = $('#nombre').val();
    const fechaNacimiento = $('#fechaNacimiento').val();
    const avatarSeleccionado = $('input[name="avatar"]:checked').val();
    const intereses = Array.from(document.querySelectorAll('#interesesList .interes-item')).map(function(item) {
        return item.textContent.replace('Eliminar', '').trim();
    });

    const nino = {
        nombre: nombre,
        fechaNacimiento: fechaNacimiento,
        avatarUrl: avatarSeleccionado,
        intereses: intereses
    };

    $.ajax({
        url: '/ninos/saveNino',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(nino),
        success: function(data) {
            var perfilHTML = '<div class="col-md-4 clickable-profile" onclick="seleccionarPerfil(' + nino.id_nino + ')">' +
                '<div class="profile-container">' +
                '<div class="profile-circle">' +
                '<img src="' + nino.avatarUrl + '" alt="Profile" class="profile-image">' +
                '</div>' +
                '<div class="profile-info">' +
                '<h5 class="profile-name">' + nino.nombre + '</h5>' +
                '</div>' +
                '</div>' +
                '</div>';
            $('#perfiles .row').append(perfilHTML);

            $('#addProfileModal').modal('hide');
        },
        error: function(error) {
            console.error('Error:', error);
        }
    });
}
