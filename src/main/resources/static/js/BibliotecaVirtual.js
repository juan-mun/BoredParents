$(document).ready(function() {
    cargarActividades();
});

function anadirAsignacion(idActividad, nombreActividad) {
  const postData = {
    nino: {id_nino: 1},
    actividad: {id_actividad: idActividad}
  };

  $.ajax({
    url: 'asignaciones/addAsignacion',
    type: 'POST',
    contentType: 'application/json',
    data: JSON.stringify(postData),
    success: function(response) {
      $(`#actividad-${idActividad}`).hide();
      const estante = $('.bookshelf .shelf').first();
      const libro = $(`
        <div class="book" id="book-${idActividad}">
            <div class="book-text">${nombreActividad}</div>
        </div>
      `);
      estante.append(libro);

      // Actualiza la clase 'only-book' para el nuevo estado del estante.
      actualizarEstiloDelLibro(estante);
    },
    error: function(xhr, status, error) {
      console.error('error creando asignacion: ', error, xhr, status);
    }
  });
}

function actualizarEstiloDelLibro(estante) {
  const libros = estante.children('.book');
  if(libros.length === 1) {
      $(libros[0]).addClass('only-book');
  } else {
      libros.removeClass('only-book');
  }
}

function cargarActividades() {
    $.ajax({
      url: 'actividades/getActivity',
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
      },
      error: function(xhr, status, error) {
        console.error('Error fetching actividades:', error);
      }
    });
}
  
  