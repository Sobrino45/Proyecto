package com.pro.repositories;

import com.pro.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Buscar un usuario por email
    Optional<Usuario> findByEmail(String email);

    // Buscar usuarios por nombre (ignorando mayúsculas y minúsculas)
    List<Usuario> findByNombreIgnoreCase(String nombre);

    // Buscar usuarios cuyo nombre contenga una cadena específica
    List<Usuario> findByNombreContainingIgnoreCase(String nombre);

    // Contar el número de usuarios con un email específico
    long countByEmail(String email);
}