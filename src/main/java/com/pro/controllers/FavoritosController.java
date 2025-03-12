package com.pro.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pro.models.Evento;
import com.pro.repositories.EventoRepository;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/favoritos")
public class FavoritosController {
    @Autowired
    private EventoRepository eventoRepository;
    
    @PostMapping("/agregar/{id}")
    public String agregarFavorito(@PathVariable Long id, HttpSession session) {
        List<Evento> favoritos = (List<Evento>) session.getAttribute("favoritos");
        Evento evento = eventoRepository.findById(id).orElse(null);
        if (evento != null && !favoritos.contains(evento)) {
            favoritos.add(evento);
            session.setAttribute("favoritos", favoritos);
        }
        return "redirect:/eventos";
    }
    
    @PostMapping("/eliminar/{id}")
    public String eliminarFavorito(@PathVariable Long id, HttpSession session) {
        List<Evento> favoritos = (List<Evento>) session.getAttribute("favoritos");
        favoritos.removeIf(evento -> evento.getId().equals(id));
        session.setAttribute("favoritos", favoritos);
        return "redirect:/favoritos";
    }
    
    @GetMapping
    public String mostrarFavoritos(HttpSession session, Model model) {
        List<Evento> favoritos = (List<Evento>) session.getAttribute("favoritos");
        model.addAttribute("favoritos", favoritos);
        return "favoritos/lista";
    }
}
