package com.api.agendamedicaback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AgendaMedicaBackApplication {

	public static void main(String[] args) {

		SpringApplication.run(AgendaMedicaBackApplication.class, args);
		System.out.println("Api da Web App Agenda Medica rodando!");
	}
}
