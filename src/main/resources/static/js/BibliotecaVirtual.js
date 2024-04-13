$(document).ready(function() {
    cargarActividades();
});
  
function cargarActividades() {
    $.ajax({
      url: 'http://localhost:8080/actividades/getActivity',
      type: 'GET',
      dataType: 'json',
      success: function(actividades) {
        const listaActividadesContainer = $('.lista-actividades');
        listaActividadesContainer.empty(); // Limpia el contenedor antes de añadir nuevos elementos
        actividades.forEach(function(actividad) {
          const actividadElement = $(`
            <div class="actividad">
              <h5 class="titulo-actividad">${actividad.nombre}</h5>
              <h6 class="categoria-actividad">${actividad.categoria}</h6>
              <p class="duracion-actividad">Duración: ${actividad.duracion}</p>
              <button type="button" class="btn btn-primary float-right">Añadir</button>
            </div>
          `);
          actividadElement.hover(
            function() {
              // Acción al pasar el ratón por encima
              $(this).append(`<div class="tooltip-custom">${actividad.descripcion}</div>`);
            },
            function() {
              // Acción al salir el ratón
              $(this).find('.tooltip-custom').remove();
            }
          );
          listaActividadesContainer.append(actividadElement);
        });
      },
      error: function(xhr, status, error) {
        console.error('Error fetching actividades:', error);
      }
    });
}
  
  