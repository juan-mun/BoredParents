package com.BoredParents.BoredParents.Auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.BoredParents.BoredParents.Entities.Role;
import com.BoredParents.BoredParents.Entities.Usuario;
import com.BoredParents.BoredParents.jwt.JwtService;
import com.BoredParents.BoredParents.repositorys.UsuarioRepository;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
       authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
       UserDetails user = usuarioRepository.findByUsername(request.getUsername()).orElseThrow();
       String token = jwtService.getToken(user);
       return AuthResponse.builder().token(token).build();
    }
    public AuthResponse register(RegisterRequest request) {
        Usuario usuario = Usuario.builder()
            .username(request.getUsername())
            .password(passwordEncoder.encode(request.getPassword()))
            .nombre(request.getNombre())
            .apellido(request.getApellido())
            .email(request.getEmail())
            .role(Role.USUARIO)
            .build();

    usuarioRepository.save(usuario);

    return AuthResponse.builder().token(jwtService.getToken(usuario)).build();
}
}
