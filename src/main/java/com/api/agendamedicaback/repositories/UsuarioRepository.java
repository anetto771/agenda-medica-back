package com.api.agendamedicaback.repositories;

import com.api.agendamedicaback.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
