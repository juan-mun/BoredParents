function handleLogin() {
    var email = $('#email').val();
    var password = $('#password').val();

    var loginData = {
        username: email,
        password: password
    };

    $.ajax({
        type: 'POST',
        url: '/auth/login',
        contentType: 'application/json',
        data: JSON.stringify(loginData),
        success: function(data) {
            console.log(data); // Esto imprimirá la respuesta en la consola.
            if(data.token) {
                localStorage.setItem('token', data.token);
                window.location.href = "/vistas/perfilHijos.html"; // Redirigir a donde sea apropiado
            } else {
                console.error('Token no presente en la respuesta');
            }
        },
        error: function(xhr, status, error) {
            console.error('Error durante el login:', error);
        }
    });
}