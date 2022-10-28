package com.api.agendamedicaback.services;


import com.api.agendamedicaback.domain.Agendamento;
import com.api.agendamedicaback.domain.Medico;
import com.api.agendamedicaback.domain.Paciente;
import com.api.agendamedicaback.domain.dtos.AgendamentoDTO;
import com.api.agendamedicaback.domain.enums.Status;
import com.api.agendamedicaback.repositories.AgendamentoRepository;

import com.api.agendamedicaback.services.MedicoService;
import com.api.agendamedicaback.services.PacienteService;
import com.api.agendamedicaback.services.UsuarioService;
import com.api.agendamedicaback.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AgendamentoService {


    @Autowired
    private AgendamentoRepository repository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private MedicoService medicoService;

    @Autowired
    private PacienteService pacienteService;

    public Agendamento findById(Integer id) {
        Optional<Agendamento> obj = repository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Agendamento não encontrado: " + id));
    }

    public List<Agendamento> findAll() {
        return repository.findAll();
    }

    public Agendamento create(AgendamentoDTO objDto) {
        objDto.setId((null));
        return repository.save(newAgendamento(objDto));
    }
    private Agendamento newAgendamento(AgendamentoDTO obj){
        Medico medico = medicoService.findById(obj.getMedico());
        Paciente paciente = pacienteService.findById(obj.getPaciente());

        Agendamento agendamento = new Agendamento();
        if (obj.getId() != null){
            agendamento.setId(obj.getId());
        }
        agendamento.setMedico(medico);
        agendamento.setPaciente(paciente);
        agendamento.setStatus(Status.toEnum(obj.getStatus()));
        agendamento.setTitulo(obj.getTitulo());
        agendamento.setObservacoes(obj.getObservacoes());

        return agendamento;
    }
}
