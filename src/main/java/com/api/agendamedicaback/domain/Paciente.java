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
    public Paciente(Integer id, String nome,String dataNascimento, String cpf,String rg, String email,String endereco,String telefone,String especialidade, String senha) {
        super(id, nome,dataNascimento, cpf, rg, email,endereco,telefone,especialidade, senha);
    }
    public Paciente(PacienteDTO obj) {
        super();
        this.id = id = obj.getId();
        this.nome = obj.getNome();
        this.dataNascimento = obj.getDataNascimento();
        this.cpf = obj.getCpf();
        this.rg = obj.getRg();
        this.email = obj.getEmail();
        this.endereco = obj.getEndereco();
        this.telefone = obj.getTelefone();
        this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
        this.dataCriacao = obj.getDataCriacao();
        addPerfis(Perfil.PACIENTE);
    }





    public List<Agendamento> getAgendamento() {
        return agendamentos;
    }

    public void setAgendamento(List<Agendamento> agendamento) {
        this.agendamentos = agendamento;
    }
}
