package com.pro.controllers;

import com.pro.models.Evento;
import com.pro.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/eventos")
public class EventoController {
    @Autowired
    private EventoRepository eventoRepository;

    @GetMapping
    public String listarEventos(Model model) {
        List<Evento> eventos = eventoRepository.findAll();
        model.addAttribute("eventos", eventos);
        return "eventos/lista";
    }
}