package com.api.agendamedicaback.services;


import com.api.agendamedicaback.domain.Pessoa;
import com.api.agendamedicaback.domain.Usuario;
import com.api.agendamedicaback.domain.dtos.UsuarioDTO;
import com.api.agendamedicaback.repositories.PessoaRepository;
import com.api.agendamedicaback.repositories.UsuarioRepository;
import com.api.agendamedicaback.services.exceptions.DataIntegrityViolationException;
import com.api.agendamedicaback.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public Usuario findById(Integer id) {
        Optional<Usuario> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!: " + id));
    }

    public List<Usuario> findAll() {
        return repository.findAll();
    }

    public Usuario create(UsuarioDTO objDto) {
        objDto.setId(null);
        objDto.setSenha(encoder.encode(objDto.getSenha()));
        validaPorCpfEEmail(objDto);
        Usuario newObj = new Usuario(objDto);
        return repository.save(newObj);
    }

    private void validaPorCpfEEmail(UsuarioDTO objDto) {
        Optional<Pessoa> obj = pessoaRepository.findByCpf(objDto.getCpf());
        if (obj.isPresent() && obj.get().getId() != objDto.getId()) {
            throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
        }
        obj = pessoaRepository.findByEmail(objDto.getEmail());
        if (obj.isPresent() && obj.get().getId() != objDto.getId()) {
            throw new DataIntegrityViolationException("E-mail já existente no sistema!");
        }
    }

    public Usuario update(Integer id, UsuarioDTO objDto) {
        objDto.setId(id);
        Usuario oldObj = findById(id);
        validaPorCpfEEmail(objDto);
        oldObj = new Usuario(objDto);
        return repository.save(oldObj);
    }

    public void delete(Integer id) {
        Usuario obj = findById(id);
        if (obj.getAgendamento().size() > 0){
            throw new DataIntegrityViolationException(
                    "O usuário possui agendamentos e não pode ser excluido."
            );
        }
        repository.deleteById(id);
    }
}


