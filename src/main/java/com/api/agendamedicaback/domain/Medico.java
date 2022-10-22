package com.api.agendamedicaback.domain;

import java.util.ArrayList;
import java.util.List;

public class Medico extends Pessoa{
    private List<Agendamento> agendamentos = new ArrayList<>();

    public Medico() {
        super();
    }

    public Medico(Integer id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }
}
