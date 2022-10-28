package com.api.agendamedicaback.services;


import com.api.agendamedicaback.repositories.AgendamentoRepository;
import com.api.agendamedicaback.repositories.MedicoRepository;
import com.api.agendamedicaback.repositories.PacienteRepository;
import com.api.agendamedicaback.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
public class DBService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    AgendamentoRepository agendamentoRepository;

    //METODO DE INJEÇÃO DE DADOS NO BANCO.
    public void instanciaDB() {

    }
}
