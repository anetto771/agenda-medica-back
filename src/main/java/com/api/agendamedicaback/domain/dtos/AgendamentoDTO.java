package com.api.agendamedicaback.domain.dtos;

import com.api.agendamedicaback.domain.Agendamento;
import com.api.agendamedicaback.domain.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;
import java.io.Serializable;



public class AgendamentoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private String horaAbertura;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private String horaFechamento;
    @NotNull(message = "O campo STATUS é requerido.")
    private Integer status;
    @NotNull(message = "O campo TITULO é requerido.")
    private String titulo;
    @NotNull(message = "O campo OBSERVAÇÃO é requerido.")
    private String observacoes;

    @NotNull(message = "O campo MÉDICO é requerido.")
    private Integer medico;
    @NotNull(message = "O campo PACIENTE é requerido.")
    private Integer paciente;
    private String nomeMedico;
    private String nomePaciente;

    public AgendamentoDTO() {
        super();
    }
    public AgendamentoDTO(Agendamento obj) {
        super();
        this.id = obj.getId();
        this.horaAbertura = obj.getHoraAbertura();
        this.horaFechamento = obj.getHoraFechamento();
        this.status = obj.getStatus().getCodigo();
        this.titulo = obj.getTitulo();
        this.observacoes = obj.getObservacoes();

        this.medico = obj.getMedico().getId();
        this.paciente = obj.getPaciente().getId();
        this.nomeMedico = obj.getMedico().getNome();
        this.nomePaciente = obj.getPaciente().getNome();
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getHoraAbertura() {
        return horaAbertura;
    }
        public void setHoraAbertura(String horaAbertura) {
        this.horaAbertura = horaAbertura;
    }
    public String getHoraFechamento() {
        return horaFechamento;
    }
    public void setHoraFechamento(String horaFechamento) {
        this.horaFechamento = horaFechamento;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getObservacoes() {
        return observacoes;
    }
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Integer getMedico() {
        return medico;
    }
    public void setMedico(Integer medico) {
        this.medico = medico;
    }
    public Integer getPaciente() {
        return paciente;
    }
    public void setPaciente(Integer paciente) {
        this.paciente = paciente;
    }
    public String getNomeMedico() {
        return nomeMedico;
    }
    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }
    public String getNomePaciente() {
        return nomePaciente;
    }
    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }
}