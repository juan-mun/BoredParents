const idNino = localStorage.getItem('idNinoActual');
const idActividad = localStorage.getItem('idAsignacionActual');

function cargarActividades() {
    $.ajax({
        url: '/RegistroActividadController/registrosPorActividades/' + idNino + '/' + 1, 
        type: 'GET',
        dataType: 'json',
        success: function(actividades) {    
            const tableBody = $('#actividades-table tbody');
            tableBody.empty(); // Asegúrate de limpiar la tabla antes de agregar nuevas filas
            actividades.forEach(function(actividad) {
                const duracion = calcularDuracion(actividad.tiempo_inicio, actividad.tiempo_final);
                tableBody.append(`
                    <tr>
                        <td>${actividad.tiempo_inicio}</td>
                        <td>${actividad.tiempo_final}</td>
                        <td>${duracion}</td>
                    </tr>
                `);
            });
            crearGraficoBarras(actividades);
            crearGraficoLineas(actividades);
        },
        error: function(error) {
            console.log('No se pudo cargar la información de las actividades: ' + error.responseText);
        }
    });
}

function calcularDuracion(tiempoInicio, tiempoFinal) {
    // Suponemos que la hora inicial y final están en el mismo día
    const inicio = new Date("2024-01-01 " + tiempoInicio); // Agregamos una fecha arbitraria para crear un objeto Date válido
    const final = new Date("2024-01-01 " + tiempoFinal); // Agregamos una fecha arbitraria para crear un objeto Date válido
    
    // Verificar si final es anterior a inicio
    if (final < inicio) {
        return "Fecha final anterior a la inicial";
    }

    const diferencia = (final.getTime() - inicio.getTime()) / 60000; // Convertir milisegundos a minutos
    return Math.floor(diferencia); // Redondear hacia abajo para obtener el número entero de minutos
}

function crearGraficoBarras(actividades) {
    const duraciones = actividades.map(actividad => calcularDuracion(actividad.tiempo_inicio, actividad.tiempo_final));

    const ctx = document.getElementById('grafico-barras').getContext('2d');
    const grafico = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: actividades.map((_, index) => `Intento ${index + 1}`), // Etiquetas para el eje X
            datasets: [{
                label: 'Duración',
                data: duraciones, // Datos para el eje Y
                backgroundColor: 'rgba(75, 192, 192, 0.2)',
                borderColor: 'rgba(75, 192, 192, 1)',
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });
}

function crearGraficoLineas(actividades) {
    const duraciones = actividades.map(actividad => calcularDuracion(actividad.tiempo_inicio, actividad.tiempo_final));

    const ctx = document.getElementById('grafico-lineas').getContext('2d');
    const grafico = new Chart(ctx, {
        type: 'line',
        data: {
            labels: actividades.map((_, index) => `Intento ${index + 1}`), // Etiquetas para el eje X
            datasets: [{
                label: 'Duración',
                data: duraciones, // Datos para el eje Y
                fill: false,
                borderColor: 'rgba(75, 192, 192, 1)', // Color de la línea
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });
}

function graficoLineasButton(){
    var lineas = $("#grafico-lineas").css("display") !== "none";

    if(lineas){
        $("#grafico-lineas").hide();
    }else{
        $("#grafico-lineas").show();
    }

}

function graficoBarrasButton(){
    var barras = $("#grafico-barras").css("display") !== "none";

    if(barras){
        $("#grafico-barras").hide();
    }else{
        $("#grafico-barras").show();
    }

}

function descargarExcel() {
    // Obtener los datos de la tabla
    const table = document.getElementById('actividades-table');
    const datos = [];
    for (let i = 0; i < table.rows.length; i++) {
        const row = table.rows[i];
        const rowData = [];
        for (let j = 0; j < row.cells.length; j++) {
            rowData.push(row.cells[j].innerText);
        }
        datos.push(rowData);
    }

    // Crear un libro de Excel
    const wb = XLSX.utils.book_new();
    const ws = XLSX.utils.aoa_to_sheet(datos);
    XLSX.utils.book_append_sheet(wb, ws, 'Actividades');

    // Guardar el libro de Excel
    XLSX.writeFile(wb, 'actividades.xlsx');
}

$(document).ready(function() {
    cargarActividades();
});
