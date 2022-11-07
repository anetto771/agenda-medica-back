package com.api.agendamedicaback.domain.dtos;

import com.api.agendamedicaback.domain.Paciente;
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

public class PacienteDTO implements Serializable {
    private static final long serialVersionUID = 1L;


    protected Integer id;
    @NotNull(message = "O campo NOME é requerido!")
    protected String nome;
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dataNascimento  ;

    @CPF
    @Column(unique = true)
    @NotNull(message = "O campo CPF é querido!")
    protected String cpf;
    @NotNull(message = "O campo RG é querido!")
    protected String rg;
    @NotNull(message = "O campo E-MAIL é requerido!")
    protected String email;
    @NotNull(message = "O campo ENDERECO é requerido!")
    protected String endereco;

    @GeneratedValue
    protected String telefone;

    protected Set<Integer> perfis = new HashSet<>();
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dataCriacao = LocalDate.now();

    public PacienteDTO() {
        super();
        addPerfis(Perfil.PACIENTE);
    }

    public PacienteDTO(Paciente obj) {
        super();
        this.id = obj.getId();
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEndereco(){
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
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
