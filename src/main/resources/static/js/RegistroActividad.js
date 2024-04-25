function cargarActividades() {
    $.ajax({
        url: '/RegistroActividadController/registrosPorActividades/10', 
        type: 'get',
        dataType: 'json',
        success: function(actividades) {
            const tableBody = $('#actividades-table tbody');
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
            crearGraficoBarras();
            crearGraficoLineas();
        },
        error: function(error) {
            alert('No se pudo cargar la información de las actividades: ' + error.responseText);
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

function crearGraficoBarras() {
    const filas = $('#actividades-table tbody tr').length;
    const duraciones = [];
    $('#actividades-table tbody tr').each(function() {
        const duracion = parseInt($(this).find('td:nth-child(3)').text()); // Obtener la duración de la tercera columna
        duraciones.push(duracion);
    });

    // Crear el gráfico de barras
    const ctx = document.getElementById('grafico-barras').getContext('2d');
    const grafico = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: Array.from({ length: filas }, (_, i) => i + 1), // Etiquetas para el eje X
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
                yAxes: [{
                    ticks: {
                        beginAtZero: true
                    }
                }]
            }
        }
    });
}

function crearGraficoLineas() {
    const filas = $('#actividades-table tbody tr').length;
    const duraciones = [];
    $('#actividades-table tbody tr').each(function() {
        const duracion = parseInt($(this).find('td:nth-child(3)').text()); // Obtener la duración de la tercera columna
        duraciones.push(duracion);
    });

    // Crear el gráfico de líneas
    const ctx = document.getElementById('grafico-lineas').getContext('2d');
    const grafico = new Chart(ctx, {
        type: 'line',
        data: {
            labels: Array.from({ length: filas }, (_, i) => i + 1), // Etiquetas para el eje X
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
                yAxes: [{
                    ticks: {
                        beginAtZero: true
                    }
                }]
            }
        }
    });
}

function descargarComoCSV() {
    const tabla = document.getElementById('actividades-table');
    let csv = [];
    for (let i = 0; i < tabla.rows.length; i++) {
        let row = [], cols = tabla.rows[i].cells;
        for (let j = 0; j < cols.length; j++) 
            row.push('"' + cols[j].innerText + '"'); // Agregamos comillas para manejar comas en los datos
        csv.push(row.join(',')); // Unir cada columna con coma y cada fila con nueva línea
    }
    csv = csv.join('\n');

    // Crear un enlace para descargar el CSV
    const hiddenElement = document.createElement('a');
    hiddenElement.href = 'data:text/csv;charset=utf-8,' + encodeURI(csv);
    hiddenElement.target = '_blank';
    hiddenElement.download = 'actividades.csv';
    hiddenElement.click();
}
/*
//Listener 
$(document).ready(function() {
    // Asegúrate de que solo se cargue una vez y que no haya múltiples bindings del evento.
    $('#descargarExcel').off('click').on('click', function() {
        descargarComoCSV();
    });

    // Llama a cargarActividades solo una vez al cargar la página.
    cargarActividades();
});
*/


$(document).ready(function() {
    cargarActividades();
});
