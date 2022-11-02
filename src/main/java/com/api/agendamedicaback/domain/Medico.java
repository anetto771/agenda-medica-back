package com.api.agendamedicaback.domain;

import com.api.agendamedicaback.domain.dtos.MedicoDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Medico extends Pessoa {

    private static final long serialVersionUID = 1L;


    @JsonIgnore
    @OneToMany(mappedBy = "medico")
    private List<Agendamento> agendamentos = new ArrayList<>();

    public Medico() {
        super();
    }

    public Medico(Integer id, String nome, String cpf, String email, String senha, String especialidade) {
        super(id, nome, cpf, email,especialidade, senha);

    }

    public Medico(MedicoDTO obj) {
        super();
        this.id = id = obj.getId();
        this.nome =  obj.getNome();
        this.cpf =  obj.getCpf();
        this.email = obj.getEmail();
        this.especialidade = obj.getEspecialidade();
        this.senha = obj.getSenha();
        this.perfis = obj.getPerfis().stream().map(x-> x.getCodigo()).collect(Collectors.toSet());
        this.dataCriacao = obj.getDataCriacao();
    }

    public List<Agendamento> getAgendamento() {
        return agendamentos;
    }

    public void setAgendamentos(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }

}
