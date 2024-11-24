package com.crud.Actividad3.service;

import com.crud.Actividad3.model.Usuario;
import com.crud.Actividad3.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private PersonaRepository personaRepository;

    public List<Usuario> listarTodas() {
        return UsuarioRepository.findAll();
    }

    public Usuario guardar(Usuario usuario) {
        return UsuarioRepository.save(usuario);
    }

    public Usuario obtenerPorId(int id) {
        return UsuarioRepository.findById(id).orElse(null);
    }

    public void eliminar(int id) {
        UsuarioRepository.deleteById(id);
    }
}