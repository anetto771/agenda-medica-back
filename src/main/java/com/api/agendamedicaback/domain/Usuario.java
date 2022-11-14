package com.api.agendamedicaback.domain;

import com.api.agendamedicaback.domain.dtos.UsuarioDTO;


import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Entity
public class Usuario extends Pessoa {
    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "usuario")
    private List<Agendamento> agendamentos = new ArrayList<>();

    public Usuario() {
        super();
    }

    public Usuario(Integer id, String nome, LocalDate dataNascimento, String cpf, String email,String endereco,String telefone, String especialidade, String senha) {
        super(id, nome, String.valueOf(dataNascimento), cpf, email,endereco,telefone,especialidade, senha);
    }
    public Usuario(UsuarioDTO obj) {
        super();
        this.id = id = obj.getId();
        this.nome =  obj.getNome();
        this.cpf =  obj.getCpf();
        this.email = obj.getEmail();
        this.senha = obj.getSenha();
        this.perfis = obj.getPerfis().stream().map(x-> x.getCodigo()).collect(Collectors.toSet());
        this.dataCriacao = obj.getDataCriacao();
    }

    public List<Agendamento> getAgendamento() {
        return agendamentos;
    }

    public void setAgendamento(List<Agendamento> agendamento) {
        this.agendamentos = agendamento;
    }
}
