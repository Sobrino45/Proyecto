package com.pro.repositories;

import com.pro.models.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsistenciaRepository extends JpaRepository<Asistencia, Long> {
    List<Asistencia> findByUsuarioId(Long usuarioId);
    List<Asistencia> findByEventoId(Long eventoId);
}
