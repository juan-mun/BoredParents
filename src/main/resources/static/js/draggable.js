function drag(event) {
    console.log("Comenzando a arrastrar elemento con id:", event.target.id);
    event.dataTransfer.setData("text/plain", event.target.id);
}

function allowDrop(event) {
    event.preventDefault();
}

function drop(event) {
    event.preventDefault();
    var data = event.dataTransfer.getData("text/plain");
    console.log("Soltando elemento con id:", data);
    var draggedElement = document.getElementById(data);
    console.log("Elemento arrastrado:", draggedElement);
    if (event.target.tagName === 'TD') {
        event.target.parentNode.parentNode.appendChild(draggedElement);
    } else if (event.target.tagName === 'TBODY' || event.target.tagName === 'TABLE') {
        event.target.appendChild(draggedElement);
    }
}