package com.api.agendamedicaback.services;


import com.api.agendamedicaback.domain.Paciente;
import com.api.agendamedicaback.domain.Pessoa;
import com.api.agendamedicaback.domain.dtos.PacienteDTO;
import com.api.agendamedicaback.repositories.PacienteRepository;
import com.api.agendamedicaback.repositories.PessoaRepository;
import com.api.agendamedicaback.services.exceptions.DataIntegrityViolationException;
import com.api.agendamedicaback.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public Paciente findById(Integer id) {
        Optional<Paciente> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado!: " + id)
        );
    }

    public List<Paciente> findAll() {
        return repository.findAll();
    }

    public Paciente create(PacienteDTO objDto) {
        objDto.setId(null);
        objDto.setSenha(encoder.encode(objDto.getSenha()));
        validaPorCpfEEmail(objDto);
        Paciente newObj = new Paciente(objDto);
        return repository.save(newObj);
    }

    private void validaPorCpfEEmail(PacienteDTO objDto) {
        Optional<Pessoa> obj = pessoaRepository.findByCpf(objDto.getCpf());
        if (obj.isPresent() && obj.get().getId() != objDto.getId()) {
            throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
        }
        obj = pessoaRepository.findByEmail(objDto.getEmail());
        if (obj.isPresent() && obj.get().getId() != objDto.getId()) {
            throw new DataIntegrityViolationException("E-mail já existente no sistema!");
        }
    }

    public Paciente update(Integer id, PacienteDTO objDto) {
        objDto.setId(id);
        Paciente oldObj = findById(id);
        validaPorCpfEEmail(objDto);
        oldObj = new Paciente(objDto);
        return repository.save(oldObj);
    }

    public void delete(Integer id) {
        Paciente obj = findById(id);
        if (obj.getAgendamento().size() > 0){
            throw new DataIntegrityViolationException(
                    "O paciente possui agendamentos e não pode ser excluido."
            );
        }
        repository.deleteById(id);
    }
}


