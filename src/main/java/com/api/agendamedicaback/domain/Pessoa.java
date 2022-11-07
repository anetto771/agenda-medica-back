package com.api.agendamedicaback.domain;

import com.api.agendamedicaback.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public abstract class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    protected String nome;
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dataNascimento;
    @CPF
    @Column(unique = true)
    protected String cpf;
    @Column(unique = true)
    protected String rg;
    @Column(unique = true)
    protected String email;
    protected String endereco;
    @GeneratedValue


    protected String telefone;
    protected String especialidade;
    protected String senha;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "PERFIS")
    protected Set<Integer> perfis = new HashSet<>();
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dataCriacao = LocalDate.now();



    public Pessoa() {
        super();
        addPerfis(Perfil.PACIENTE);
    }

    public Pessoa(Integer id, String nome,String dataNascimento, String cpf,String rg, String email,String endereco,String telefone ,String especialidade, String senha) {
        super();
        this.id = id;
        this.nome = nome;
        this.dataNascimento = LocalDate.parse(dataNascimento);
        this.cpf = cpf;
        this.rg = rg;
        this.email = email;
        this.endereco = endereco;
        this.telefone = telefone;
        this.especialidade = especialidade;
        this.senha = senha;
        addPerfis(Perfil.USUARIO);
    }

    public Pessoa(Integer id, String nome, String valueOf, String cpf, String email, String endereco, String telefone, String especialidade, String senha) {
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

    public void setDataNascimento(LocalDate dataNascimento) {

        this.dataNascimento = dataNascimento;
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
    public String getEndereco() {
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
    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<Perfil> getPerfis() {
        return perfis.stream().map(x -> Perfil.toEnum((x))).collect(Collectors.toSet());
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pessoa other = (Pessoa) obj;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
}

