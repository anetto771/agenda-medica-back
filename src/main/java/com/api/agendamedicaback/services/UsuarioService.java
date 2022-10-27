package com.api.agendamedicaback.services;


import com.api.agendamedicaback.domain.Usuario;
import com.api.agendamedicaback.domain.dtos.UsuarioDTO;
import com.api.agendamedicaback.repositories.UsuarioRepository;
import com.api.agendamedicaback.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public Usuario findById(Integer id){
        Optional<Usuario> obj = repository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado!: "+id));
    }

    public List<Usuario> findAll() {
        return repository.findAll();
    }

    public Usuario create(UsuarioDTO objDto) {
        objDto.setId(null);
        Usuario newObj = new Usuario(objDto);
        return repository.save(newObj);
    }
}

