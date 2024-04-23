$(document).ready(function() {
    getActividadesEducativas();
    getActividadesNoElectricas();
    getActividadesBaratas();
    getActividadesRecreativas();
});

function getActividadesEducativas() {
    $.ajax({
        url: "/actividades/munoz",
        type: "GET",
        success: function (actividades) {
            paintActividades(actividades, "#actividadesEducativas");
        },
        error: function (error) {
            console.log(error);
        }
    });
}

function getActividadesNoElectricas() {
    $.ajax({
        url: "/actividades/sanchez",
        type: "GET",
        success: function (actividades) {
            paintActividades(actividades, "#actividadesNoElectricas");
        },
        error: function (error) {
            console.log(error);
        }
    });
}

function getActividadesBaratas() {
    $.ajax({
        url: "/actividades/guevara",
        type: "GET",
        success: function (actividades) {
            paintActividades(actividades, "#actividadesBaratas");
        },
        error: function (error) {
            console.log(error);
        }
    });
}

function getActividadesRecreativas() {
    $.ajax({
        url: "/actividades/Mendivelso",
        type: "GET",
        success: function (actividades) {
            paintActividades(actividades, "#actividadesRecreativas");
        },
        error: function (error) {
            console.log(error);
        }
    });
}

function paintActividades(actividades, selector) {
    let htmlContent = "";
    // Extraemos el prefijo del selector. Por ejemplo, de "#actividadesBaratas" a "Baratas".
    let prefix = selector.replace('#actividades', '').replace('NoElectricas', 'Offline');
    for (let i = 0; i < actividades.length; i++) {
        // Usamos el prefijo y el índice para formar un ID único, como "Baratas-0", "Educativas-1", etc.
        let id = `Actividad-${prefix}${i}`;
        htmlContent += `<tr draggable="true" id="${id}" ondragstart="drag(event)">
                            <td>${actividades[i].nombre}</td>
                        </tr>`;
    }
    $(selector).html(htmlContent);
}


