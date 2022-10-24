package com.api.agendamedicaback.repositories;

import com.api.agendamedicaback.domain.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {
}
