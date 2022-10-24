package com.api.agendamedicaback.repositories;

import com.api.agendamedicaback.domain.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
}
