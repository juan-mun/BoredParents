$(document).ready(function(){
    $('#CalendarioWeb').fullCalendar({
        header:{
            left:'today,prev,next',
            center:'title',
            right:'month,basicWeek, basicDay, agendaWeek, agendaDay'
        },
        customButtons:{
            Miboton:{
                text:"Botón 1",
                click:function(){
                    alert("Acción del botón");
                }
            }
        },
        dayClick:function(date,jsEvent,view){
            alert("Valor seleccionado: "+date.format());
            alert("Vista actual: "+view.name);
            $(this).css('background-color','red')
        }
    });
});