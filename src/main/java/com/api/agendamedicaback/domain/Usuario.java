package com.api.agendamedicaback.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Usuario extends Pessoa {
    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "usuario")
    private List<Agendamento> agendamentos = new ArrayList<>();

    public Usuario() {
        super();
    }

    public Usuario(Integer id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
    }

    public List<Agendamento> getAgendamento() {
        return agendamentos;
    }

    public void setAgendamento(List<Agendamento> agendamento) {
        this.agendamentos = agendamento;
    }
}
