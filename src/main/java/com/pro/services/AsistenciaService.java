package com.pro.services;

import com.pro.models.Asistencia;
import com.pro.repositories.AsistenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AsistenciaService {
    
    @Autowired
    private AsistenciaRepository asistenciaRepository;

    public List<Asistencia> obtenerTodas() {
        return asistenciaRepository.findAll();
    }
    
    public List<Asistencia> listarAsistencias() {
        return asistenciaRepository.findAll();
    }

    public Optional<Asistencia> obtenerPorId(Long id) {
        return asistenciaRepository.findById(id);
    }

    public Asistencia guardarAsistencia(Asistencia asistencia) {
        return asistenciaRepository.save(asistencia);
    }

    public void eliminarAsistencia(Long id) {
        asistenciaRepository.deleteById(id);
    }
    
    public Asistencia actualizarAsistencia(Asistencia asistencia) {
        return asistenciaRepository.save(asistencia);
    }
}