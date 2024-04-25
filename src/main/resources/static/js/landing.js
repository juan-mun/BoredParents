// Función para animar la imagen al desplazar la página
window.addEventListener('scroll', function() {
    const image = document.getElementById('hero-image');
    const scrollPosition = window.scrollY;
    image.style.transform = 'translateY(' + scrollPosition * 0.1 + 'px)';
});