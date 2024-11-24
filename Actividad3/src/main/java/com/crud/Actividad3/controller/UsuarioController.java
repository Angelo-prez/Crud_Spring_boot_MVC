package com.crud.Actividad3.controller;

import com.crud.Actividad3.model.Usuario;
import com.crud.Actividad3.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuarios")

public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String listarUsuario(Model model) {
        model.addAttribute("usuarios", UsuarioService.listarTodas());
        return "usuario-list";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevaUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuario-form";
    }

    @PostMapping
    public String guardarUsuario(Usuario usuario) {
        UsuarioService.guardar(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarUsuario(@PathVariable int id, Model model) {
        model.addAttribute("usuario", UsuarioService.obtenerPorId(id));
        return "usuario-form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable int id) {
        UsuarioService.eliminar(id);
        return "redirect:/usuarios";
    }
}