package com.api.agendamedicaback.repositories;

import com.api.agendamedicaback.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

    Optional<Pessoa> findByCpf(Integer cpf);
}
