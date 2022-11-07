package com.api.agendamedicaback.domain.dtos;


import com.api.agendamedicaback.domain.Medico;
import com.api.agendamedicaback.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class MedicoDTO implements Serializable {
    private static final long serialVersionUID = 1L;


    protected Integer id;
    @NotNull(message = "O campo NOME é requerido!")
    protected String nome;
    @NotNull(message = "O campo CPF é requerido!")
    @CPF
    @Column(unique = true)
    protected String cpf;
    @NotNull(message = "O campo E-MAIL é requerido!")
    protected String email;

    @GeneratedValue

    protected String telefone;
    @NotNull(message = "O campo especialidade é requerido!")
    protected String especialidade;
    protected Set<Integer> perfis = new HashSet<>();
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dataCriacao = LocalDate.now();

    public MedicoDTO() {
        super();
        addPerfis(Perfil.MEDICO);
    }
    public MedicoDTO(Medico obj) {
        super();
        this.id= obj.getId();
        this.nome = obj.getNome();
        this.email = obj.getEmail();
        this.cpf = obj.getCpf();
        this.telefone = obj.getTelefone();
        this.especialidade = obj.getEspecialidade();
        this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
        this.dataCriacao = obj.getDataCriacao();
        addPerfis(Perfil.PACIENTE);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEspecialidade()
    { return especialidade;}

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }


    public Set<Perfil> getPerfis() {
        return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
    }

    public void addPerfis(Perfil perfis) {
        this.perfis.add(perfis.getCodigo());
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

}
