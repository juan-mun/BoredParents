$(document).ready(function() {
    cargarPerfiles();
});

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
    $.ajax({
        url: '/ninos/getNinos', // Asegúrate de que esta URL coincida con tu endpoint en el backend
        type: 'GET',
        success: function(data) {
            // Vaciar la lista actual de perfiles y el select del modal eliminar
            $('#perfiles .row').empty();
            $('#perfilSelect').empty(); // Asegúrate de vaciar el select antes de llenarlo

            // Iterar sobre cada perfil recibido del backend y añadirlo a la página y al select del modal
            data.forEach(function(nino) {
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

                var optionHTML = '<option value="' + nino.id_nino + '">' + nino.nombre + '</option>';

                $('#perfiles .row').append(perfilHTML);
                $('#perfilSelect').append(optionHTML); // Agrega esta línea aquí
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
    const avatarSeleccionado = $('input[name="avatar"]:checked').val(); // Obtiene el avatar seleccionado
    const intereses = Array.from(document.querySelectorAll('#interesesList .interes-item')).map(function(item) {
        return item.textContent.replace('Eliminar', '').trim(); // Elimina la palabra 'Eliminar' de los intereses
    });

    const nino = {
        nombre: nombre,
        fechaNacimiento: fechaNacimiento,
        avatarUrl: avatarSeleccionado, // Utiliza la URL del avatar seleccionado
        intereses: intereses // Utiliza el array de intereses seleccionados
    };

    $.ajax({
        url: '/ninos/saveNino',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(nino),
        success: function(data) {
            // Agregar el nuevo perfil a la vista
            var perfilHTML = '<div class="col-md-4 clickable-profile" data-href="rutina.html">' +
                '<div class="profile-container">' +
                '<div class="profile-circle">' +
                '<img src="' + data.avatarUrl + '" alt="Profile" class="profile-image">' +
                '</div>' +
                '<div class="profile-info">' +
                '<h5 class="profile-name">' + data.nombre + '</h5>' +
                '</div>' +
                '</div>' +
                '</div>';
            $('#perfiles .row').append(perfilHTML);

            // Opcional: cerrar el modal después de guardar
            $('#addProfileModal').modal('hide');
        },
        error: function(error) {
            console.error('Error:', error);
        }
    });
}
