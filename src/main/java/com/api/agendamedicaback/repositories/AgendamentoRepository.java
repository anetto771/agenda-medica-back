package com.api.agendamedicaback.repositories;

import com.api.agendamedicaback.domain.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {
    @Query(value = "CALL sps_relatorio_fechados(:idMedico, CURRENT_DATE())", nativeQuery = true)
    Optional<List<Agendamento>> reportyByMedicoAgendamento(Integer idMedico);
}


