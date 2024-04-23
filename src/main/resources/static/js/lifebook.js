let currentPage = 0;
let croppieInstance = null;
const idNino = localStorage.getItem('idNinoActual');
console.log(idNino);

function confirmCrop() {
    // Obtener el resultado de Croppie
    croppieInstance.result({ type: 'canvas', size: 'viewport' }).then(function(img) {
        const imageDisplay = document.getElementById(`imageDisplay${currentPage}`);
        imageDisplay.innerHTML = `<img src="${img}" alt="Imagen recortada">`;
        const uploadArea = document.getElementById(`uploadArea${currentPage}`);
        uploadArea.style.display = 'none';
        // Ocultar el modal
        document.getElementById('croppieModal').style.display = 'none';
        // Destruir la instancia de Croppie para evitar usos futuros
        croppieInstance.destroy();
        croppieInstance = null;
    });
}

function handleImageUpload(input, pageNumber) {
    const file = input.files[0];
    if (file) {
        // Crear un FileReader para leer el archivo
        const reader = new FileReader();
        reader.onload = function(e) {
            // Obtener el modal y el contenedor de Croppie
            const croppieModal = document.getElementById('croppieModal');
            const croppieContainer = document.getElementById('croppieContainer');
            // Asegurarse de que Croppie se inicialice solo una vez
            if (!croppieInstance) {
                croppieInstance = new Croppie(croppieContainer, {
                    viewport: { width: 500, height: 500 },
                    boundary: { width: 600, height: 600 },
                    enforceBoundary: false
                });
            }
            croppieInstance.bind({
                url: e.target.result
            });
            // Mostrar el modal
            croppieModal.style.display = 'block';
        };
        reader.readAsDataURL(file);
    }
}

function createPage() {
    if (currentPage === 0) {
        hideCover();
    }
    addNewPage();
}

function hideCover() {
    const cover = document.getElementById('cover');
    cover.style.opacity = '0';
    setTimeout(() => cover.style.display = 'none', 500);
}

function addNewPage() {
    currentPage++;

    const pages = document.getElementById('pages');
    const newPage = document.createElement('div');
    newPage.className = 'book-page';
    newPage.id = `page${currentPage}`;
    newPage.innerHTML = `
        <h2>Página ${currentPage}</h2>
        <div class="image-container" id="imageContainer${currentPage}">
            <div class="upload-area" id="uploadArea${currentPage}" onclick="triggerUpload(${currentPage})">
                Agregar Imagen
            </div>
            <input type="file" onchange="handleImageUpload(this, ${currentPage})" style="display:none;">
            <div id="imageDisplay${currentPage}"></div>
        </div>
        <textarea placeholder="Escribe una descripción para la foto..."></textarea>
        <button onclick="addNewPage()">Siguiente Página</button>
        ${currentPage > 1 ? `<button onclick="previousPage(${currentPage - 1})">Página Anterior</button>` : ''}
    `;
    pages.appendChild(newPage);
    updatePageView();
}

function previousPage(pageNumber) {
    currentPage = pageNumber;
    updatePageView();
}

function updatePageView() {
    const pages = document.getElementById('pages');
    pages.style.transform = `translateX(-${(currentPage - 1) * 100}%)`;
}

function triggerUpload(pageNumber) {
    document.getElementById(`imageContainer${pageNumber}`).querySelector('input[type=file]').click();
}

function hideAllPages() {
    const pages = document.getElementById('pages');
    for (let i = 0; i < pages.children.length; i++) {
        pages.children[i].style.display = 'none';
    }
}

window.addEventListener('beforeunload', function() {
    if (croppieInstance) {
        croppieInstance.destroy();
    }
});
