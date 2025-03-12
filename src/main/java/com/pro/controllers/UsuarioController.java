package com.pro.controllers;

import com.pro.models.Usuario;
import com.pro.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Endpoint para obtener el perfil de un usuario por ID
    @GetMapping("/{id}")
    public String perfilUsuario(@PathVariable Long id, Model model) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            model.addAttribute("usuario", usuario.get());
            return "usuarios/perfil";
        } else {
            // Manejo de error si el usuario no existe
            model.addAttribute("error", "Usuario no encontrado");
            return "error";
        }
    }

    // Endpoint para listar todos los usuarios
    @GetMapping("/")
    public String listarUsuarios(Model model) {
        List<Usuario> usuarios = usuarioRepository.findAll();
        model.addAttribute("usuarios", usuarios);
        return "usuarios/lista";
    }

    // Endpoint para mostrar el formulario de creación de un nuevo usuario
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarios/formulario";
    }

    // Endpoint para guardar un nuevo usuario
    @PostMapping("/guardar")
    public String guardarUsuario(@ModelAttribute Usuario usuario) {
        usuarioRepository.save(usuario);
        return "redirect:/usuarios/";
    }

    // Endpoint para eliminar un usuario por ID
    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
        return "redirect:/usuarios/";
    }
}