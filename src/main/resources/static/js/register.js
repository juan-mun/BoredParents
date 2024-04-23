$(document).ready(function() {
    $('#register-form').submit(function(event) {
        event.preventDefault();

        var name = $('#name').val();
        var lastname = $('#lastname').val();
        var email = $('#email').val();
        var password = $('#password').val();
        var birthdate = $('#birthdate').val();  

        var registerData = {
            username: email,
            password: password,
            nombre: name,
            apellido: lastname,
            email: email
        };

        $.ajax({
            type: 'POST',
            url: '/auth/register',
            contentType: 'application/json',
            data: JSON.stringify(registerData),
            success: function(data) {
                localStorage.setItem('token', data.token);
                alert('Registro exitoso. Por favor, inicia sesión.');
                window.location.href = '/vistas/perfilHijos.html';
            },
            error: function(xhr, status, error) {
                console.error('Error en la solicitud de registro:', error);
            }
        });
    });
});