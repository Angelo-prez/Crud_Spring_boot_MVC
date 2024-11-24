package com.crud.Actividad3.repository;

import com.crud.Actividad3.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, int> {

}