package com.pro.services;

import com.pro.models.Evento;
import com.pro.repositories.EventoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EventoService {
    
    private final EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public List<Evento> listarEventos() {
        return eventoRepository.findAll();
    }

    public Optional<Evento> obtenerEventoPorId(Long id) {
        return eventoRepository.findById(id);
    }

    public Evento guardarEvento(Evento evento) {
        return eventoRepository.save(evento);
    }

    public Evento actualizarEvento(Evento evento) {
        return eventoRepository.save(evento);
    }

    public void eliminarEvento(Long id) {
        eventoRepository.deleteById(id);
    }
}
