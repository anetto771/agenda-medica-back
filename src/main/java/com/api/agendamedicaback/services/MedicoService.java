package com.api.agendamedicaback.services;


import com.api.agendamedicaback.domain.Medico;
import com.api.agendamedicaback.domain.Pessoa;
import com.api.agendamedicaback.domain.dtos.MedicoDTO;
import com.api.agendamedicaback.repositories.MedicoRepository;
import com.api.agendamedicaback.repositories.PessoaRepository;
import com.api.agendamedicaback.services.exceptions.DataIntegrityViolationException;
import com.api.agendamedicaback.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository repository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public Medico findById(Integer id) {
        Optional<Medico> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado: " + id));
    }

    public List<Medico> findAll() {
        return repository.findAll();
    }

    public Medico create(MedicoDTO objDto) {
        objDto.setId(null);
        objDto.setSenha(encoder.encode(objDto.getSenha()));
        validaPorCpfEEmail(objDto);
        Medico newObj = new Medico(objDto);
        return repository.save(newObj);
    }

    private void validaPorCpfEEmail(MedicoDTO objDto) {
        Optional<Pessoa> obj = pessoaRepository.findByCpf(objDto.getCpf());
        if (obj.isPresent() && obj.get().getId() != objDto.getId()) {
            throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
        }
        obj = pessoaRepository.findByEmail(objDto.getEmail());
        if (obj.isPresent() && obj.get().getId() != objDto.getId()) {
            throw new DataIntegrityViolationException("E-mail já existente no sistema!");
        }
    }

    public Medico update(Integer id, MedicoDTO objDto) {
        objDto.setId(id);
        objDto.setSenha(encoder.encode(objDto.getSenha()));
        Medico oldObj = findById(id);
        validaPorCpfEEmail(objDto);
        oldObj = new Medico(objDto);
        return repository.save(oldObj);
    }

    public void delete(Integer id) {
        Medico obj = findById(id);
        if (obj.getAgendamento().size() > 0){
            throw new DataIntegrityViolationException(
                    "O paciente possui agendamentos e não pode ser excluido."
            );
        }
        repository.deleteById(id);
    }
}



