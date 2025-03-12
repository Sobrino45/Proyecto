package com.pro.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pro.models.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
    List<Evento> findByNombreContainingIgnoreCase(String nombre);
}
