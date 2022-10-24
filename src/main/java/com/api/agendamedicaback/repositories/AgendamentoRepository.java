package com.api.agendamedicaback.repositories;

import com.api.agendamedicaback.domain.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {
}
