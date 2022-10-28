package com.api.agendamedicaback.domain;

import com.api.agendamedicaback.domain.dtos.PacienteDTO;
import com.api.agendamedicaback.domain.enums.Perfil;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Paciente extends Pessoa {

    private static final long serialVersionUID = 1L;
    @OneToMany(mappedBy = "paciente")
    private List<Agendamento> agendamentos = new ArrayList<>();

    public Paciente() {
        super();
    }
    public Paciente(PacienteDTO obj) {
        super();
        this.id = id = obj.getId();
        this.nome = obj.getNome();
        this.cpf = obj.getCpf();
        this.email = obj.getEmail();
        this.senha = obj.getSenha();
        this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
        this.dataCriacao = obj.getDataCriacao();
        addPerfis(Perfil.PACIENTE);
    }


    public Paciente(Integer id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
    }


    public List<Agendamento> getAgendamento() {
        return agendamentos;
    }

    public void setAgendamento(List<Agendamento> agendamento) {
        this.agendamentos = agendamento;
    }
}
