package com.api.agendamedicaback.services;

import com.api.agendamedicaback.domain.Medico;
import com.api.agendamedicaback.repositories.MedicoRepository;
import com.api.agendamedicaback.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository repository;

    public Medico findById(Integer id){
        Optional<Medico> obj = repository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado!: "+id));
    }
}

