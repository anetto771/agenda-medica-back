package com.api.agendamedicaback.domain;

import java.util.ArrayList;
import java.util.List;

public class Paciente extends Pessoa{
    private List<Agendamento> agendamentos = new ArrayList<>();

    public Paciente() {
        super();
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
