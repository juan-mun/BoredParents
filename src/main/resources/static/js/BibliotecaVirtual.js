var formattedTimeStart;
var asignacionesPorActividad = {}
var idActividadSeleccionada;
const limiteLibrosPorEstante = 5;
$(document).ready(function() {
    const idNino = localStorage.getItem('idNinoActual');
    cargarActividades();
    cargarLibrosEnEstantes(idNino);
});

$('#deleteAssignmentModal').on('show.bs.modal', function (e) {
  cargarAsignacionesDelNino(); 
});


function anadirAsignacion(idActividad, nombreActividad) {
  const idNino2 = localStorage.getItem('idNinoActual');
  console.log(idNino2)
  const postData = {
    nino: {id_nino: idNino2},
    actividad: {id_actividad: idActividad}
  };

  $.ajax({
    url: '/asignaciones/addAsignacion',
    type: 'POST',
    contentType: 'application/json',
    data: JSON.stringify(postData),
    success: function(response) {

      $(`#actividad-${idActividad}`).hide();
      
      // Encuentra la última estantería con espacio o crea una nueva si es necesario
      let estante = encontrarOCrearEstante();
      const libro = $(`
        <div class="book" id="book-${idActividad}" style="background-color: ${obtenerColorAleatorio()}">
          <div class="book-text">${nombreActividad}</div>
        </div>
      `);
      estante.append(libro);

      // Actualiza la clase 'only-book' para el nuevo estado del estante.
      actualizarEstiloDelLibro(estante);

      asignacionesPorActividad[idActividad] = Number(response.id_asignacion);
      localStorage.setItem("asignacionesPorActividad", JSON.stringify(asignacionesPorActividad));
    },
    error: function(xhr, status, error) {
      console.error('Error creando asignacion: ', error, xhr, status);
    }
  });
}

function cargarLibrosEnEstantes(idNino) {
  $.ajax({
    url: '/asignaciones/actividadesPorNino/' + idNino,
    type: 'GET',
    dataType: 'json',
    success: function(actividades) {  // Cambio de 'asignaciones' a 'actividades'
      actividades.forEach(function(actividad,index) {  // Iterar sobre el arreglo de actividades
        mostrarLibro(actividad.id_actividad, actividad.nombre, actividad.url);  // Mostrar cada libro basado en la actividad
      });
      // El uso de idActividad en $(`#actividad-${idActividad}`).hide(); no es necesario aquí
    },
    error: function(xhr, status, error) {
      console.error('Error al recuperar actividades:', error);
    }
  });
}

function mostrarLibro(idActividad, nombreActividad, urlActividad) {
  let estante = encontrarOCrearEstante();
  const libro = $(`
    <div class="book" id="book-${idActividad}" style="background-color: ${obtenerColorAleatorio()}">
      <div class="book-text">${nombreActividad}</div>
    </div>
  `);
  libro.click(function() {
      var idDelLibro = $(this).attr('id'); // Esto te dará el ID completo, por ejemplo 'book-123'
      idActividadSeleccionada = idDelLibro.split('-')[1]; // Esto separa 'book' de '123' y toma '123'
      idAsignacion = asignacionesPorActividad[idActividad];
      
      console.log('ID de Actividad seleccionada:', idActividad); 
      $('#startGameButton').off('click').on('click', function() {
          iniciarJuego(idActividad, urlActividad);
      }).show();
      $('#estadisticasButton').show();
      $('#actividadModal').modal('show');
  });
  estante.append(libro);
  actualizarEstiloDelLibro(estante);
}

function iniciarJuego(idActividad, urlActividad) {
  var startTime = new Date();
  formattedTimeStart =  startTime.getHours().toString().padStart(2, '0') + ':' + 
                            startTime.getMinutes().toString().padStart(2, '0') + ':' + 
                            startTime.getSeconds().toString().padStart(2, '0');
  console.log("Juego iniciado a las: " + formattedTimeStart);
  // Prepara y muestra el iframe
  $('#contenidoActividad').html(urlActividad).show();
  $('#startGameButton').hide();  // Oculta el botón de iniciar juego
  $('#estadisticasButton').hide(); //Oculta el botón de Estadisticas
  $('#guardarTiempoButton').remove(); // Remueve el botón si ya existe
  const guardarTiempoButton = $('<button id="guardarTiempoButton" class="btn btn-success" onclick=cerrarJuego()>Guardar Tiempo y Cerrar</button>');
  $('.modal-body').append(guardarTiempoButton); // Añade el botón al modal
}

function seleccionarEstadisticas() {
  localStorage.setItem('idAsignacionActual', asignacionesPorActividad[idActividadSeleccionada]);
  window.location.href = 'RegistroActividad.html'; 
}

function cerrarJuego(){
  endTime = new Date();
  var formattedTimeEnd = endTime.getHours().toString().padStart(2, '0') + ':' + 
                          endTime.getMinutes().toString().padStart(2, '0') + ':' + 
                          endTime.getSeconds().toString().padStart(2, '0');

  console.log("Juego cerrado a las: " + formattedTimeEnd);

  const asignacionesGuardadas = localStorage.getItem('asignacionesPorActividad');
  if (asignacionesGuardadas) {
      // Convertir la cadena JSON a un objeto JavaScript
      asignacionesPorActividad = JSON.parse(asignacionesGuardadas);
  }
  console.log("DEBUG 1 " + asignacionesPorActividad[1]);

  const registroActividadData = {
    tiempo_inicio: formattedTimeStart,
    tiempo_final: formattedTimeEnd,
    actividad: {
        id_actividad: idActividadSeleccionada
    },
    asignacion: {
      id_asignacion: asignacionesPorActividad[idActividadSeleccionada]
    }
  };

  // Realiza la petición POST para guardar los datos de registro de actividad
  $.ajax({
      url: '/RegistroActividadController/save',
      type: 'POST',
      contentType: 'application/json',
      data: JSON.stringify(registroActividadData),
      success: function(response) {
        console.log('Registro de actividad guardado con éxito', response);
        // Vuelve a mostrar los botones de iniciar juego y estadísticas
        $('#startGameButton').show();
        $('#estadisticasButton').show();

        // Oculta el contenido de la actividad y el botón de cerrar juego
        $('#contenidoActividad').empty().hide();
        $('#guardarTiempoButton').remove();
      },
      error: function(xhr, status, error) {
          console.error('Error al guardar el registro de actividad: ', error);
      }
  });
}

function obtenerColorAleatorio() {
  // Array de colores para las portadas
  const colores = ['#FBE7C6', '#BFD8BD', '#A2C3A4', '#F7A399', '#C7B9E2'];
  // Retorna un color al azar de la lista
  return colores[Math.floor(Math.random() * colores.length)];
}

// Encuentra la última estantería con espacio o crea una nueva si es necesario
function encontrarOCrearEstante() {
  const estantes = $('.bookshelf .shelf');
  let estante;

  if(estantes.length === 0 || estanteLleno($(estantes[estantes.length - 1]))) {
    estante = $('<div class="shelf"></div>');
    $('.bookshelf').append(estante);
  } else {
    estante = $(estantes[estantes.length - 1]);
  }

  return estante;
}

// Comprueba si el estante está lleno
function estanteLleno(estante) {
  return estante.children('.book').length >= limiteLibrosPorEstante;
}

function actualizarEstiloDelLibro(estante) {
  const libros = estante.children('.book');
  if(libros.length === 1) {
      libros.addClass('only-book');
  } else {
      libros.removeClass('only-book');
  }
}

function cargarAsignacionesDelNino() {
  let idNino = localStorage.getItem('idNinoActual');  // Recupera el ID del niño actual desde el almacenamiento local
  $.ajax({
      url: `/asignaciones/actividadesPorNino/${idNino}`, // Llamada AJAX al servidor para obtener las asignaciones
      type: 'GET',
      success: function(asignaciones) {
          const select = $('#assignmentSelect');
          select.empty();  // Limpia las opciones anteriores
          asignaciones.forEach(asignacion => {
              // Agrega cada asignación como opción en el select
              select.append(new Option(asignacion.actividad.nombre, asignacion.id_asignacion));
          });
      },
      error: function(error) {
          console.error('Error al cargar las asignaciones:', error);
      }
  });
}

function cargarActividades() {
    $.ajax({
      url: '/actividades/getActivity',
      type: 'GET',
      dataType: 'json',
      success: function(actividades) {
        const listaActividadesContainer = $('.lista-actividades');
        listaActividadesContainer.empty(); 
        actividades.forEach(function(actividad) {
          const actividadElement = $(`
            <div class="actividad" id="actividad-${actividad.id_actividad}">
              <h5 class="titulo-actividad">${actividad.nombre}</h5>
              <h6 class="categoria-actividad">${actividad.categoria}</h6>
              <p class="duracion-actividad">Duración: ${actividad.duracion}</p>
              <button type="button" class="btn btn-primary float-right" onclick="anadirAsignacion(${actividad.id_actividad}, '${actividad.nombre}')">Añadir</button>
            </div>
          `);
          listaActividadesContainer.append(actividadElement);
        });

        $('#searchInput').on('keyup', function() {
          var value = $(this).val().toLowerCase();
          $('.actividad').filter(function() {
              $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
          });
      });
      },
      error: function(xhr, status, error) {
        console.error('Error fetching actividades:', error);
      }
    });
}

function eliminarAsignacionSeleccionada() {
  let idAsignacion = $('#assignmentSelect').val();
  $.ajax({
      url: `/asignaciones/${idAsignacion}`,
      type: 'DELETE',
      success: function(response) {
          alert('Asignación eliminada con éxito');
          $('#deleteAssignmentModal').modal('hide');
          cargarLibrosEnEstantes(idNino);
      },
      error: function(error) {
          console.error('Error al eliminar la asignación:', error);
      }
  });
}

  
  