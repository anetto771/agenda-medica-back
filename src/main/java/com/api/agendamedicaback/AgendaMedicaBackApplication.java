package com.api.agendamedicaback;


import com.api.agendamedicaback.domain.Agendamento;
import com.api.agendamedicaback.domain.Medico;
import com.api.agendamedicaback.domain.Paciente;
import com.api.agendamedicaback.domain.Usuario;
import com.api.agendamedicaback.domain.enums.Perfil;
import com.api.agendamedicaback.domain.enums.Status;
import com.api.agendamedicaback.repositories.AgendamentoRepository;
import com.api.agendamedicaback.repositories.MedicoRepository;
import com.api.agendamedicaback.repositories.PacienteRepository;
import com.api.agendamedicaback.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;


@SpringBootApplication
public class AgendaMedicaBackApplication{



	public static void main(String[] args) {

		SpringApplication.run(AgendaMedicaBackApplication.class, args);
		System.out.println("Api da Web App Agenda Medica rodando!");
	}
}
