$(document).ready(function() {
    getRecursos();
});

function getRecursos(){
    $.ajax({
        url: '/recursos/getRecursos',
        type: 'GET',
        success: function(recursos) {
            recursos.forEach(function(recurso) {
                // Muestra cada recurso en su sección correspondiente
                if (recurso.tipo === 'Articulo') {
                    $('#articulos').append(`<div class="col-md-6"><a href="${recurso.url}" class="btn btn-primary">${recurso.titulo}</a></div>`);
                } else if (recurso.tipo === 'Podcast') {
                    $('#podcasts').append(`<div class="col-md-6"><iframe src="${recurso.url}" style="width:100%; height:232px; border:none;" allow="encrypted-media;"></iframe></div>`);
                } else if (recurso.tipo === 'Video') {
                    $('#videos').append(`<div class="col-md-6"><iframe src="${recurso.url}" style="width:100%; height:315px; border:none;" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe></div>`);
                }
            });
        },
        error: function(xhr, status, error) {
            console.error('Error al cargar los recursos:', error);
        }
    });
}