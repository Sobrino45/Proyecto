package com.pro.controllers;

import com.pro.models.Asistencia;
import com.pro.services.AsistenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/asistencias")
public class AsistenciaController {

    @Autowired
    private AsistenciaService asistenciaService;

    @GetMapping
    public String listarAsistencias(Model model) {
        List<Asistencia> asistencias = asistenciaService.obtenerTodas();
        model.addAttribute("asistencias", asistencias);
        return "asistencias/listar";
    }

    @GetMapping("/nuevo")
    public String crearFormulario(Model model) {
        model.addAttribute("asistencia", new Asistencia());
        return "asistencias/formulario";
    }

    @PostMapping("/guardar")
    public String guardarAsistencia(@ModelAttribute Asistencia asistencia) {
        asistenciaService.guardarAsistencia(asistencia);
        return "redirect:/asistencias";
    }

    @PostMapping("/actualizar")
    public String actualizarAsistencia(@ModelAttribute Asistencia asistencia) {
        asistenciaService.actualizarAsistencia(asistencia);
        return "redirect:/asistencias";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarAsistencia(@PathVariable("id") Long id) {
        asistenciaService.eliminarAsistencia(id);
        return "redirect:/asistencias";
    }
}
