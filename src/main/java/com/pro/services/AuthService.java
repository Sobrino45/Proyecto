package com.pro.services;

import com.pro.models.Usuario;
import com.pro.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;

    public AuthService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario authenticate(String email) {
        return usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsuarioNoEncontradoException("Usuario con email " + email + " no encontrado"));
    }

    // Clase de excepción personalizada para un mejor manejo de errores
    public static class UsuarioNoEncontradoException extends RuntimeException {
        public UsuarioNoEncontradoException(String message) {
            super(message);
        }
    }
}
