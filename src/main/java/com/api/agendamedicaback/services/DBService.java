package com.api.agendamedicaback.services;

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
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    AgendamentoRepository agendamentoRepository;

    //METODO DE INJEÇÃO DE DADOS NO BANCO.
    public void instanciaDB(){
        Usuario usu1 = new Usuario(null,"Aecio Netto",
                "151.052.997-79","anetto771@gmail.com","aecio2204");
        usu1.addPerfis(Perfil.USUARIO);

        Medico med1 = new Medico(null,"Eychila Eleuterio",
                "167.666.567.60","eychilaeleuterio@gmail.com","miguel2904");

        Paciente pac1 = new Paciente(null,"Giovane Rodrigues",
                "653.820.560-72","giorodrigues171@gmail.com","gio171");

        Agendamento agd1 = new Agendamento(null, Status.ENCERRADO,"Dor de cabeça",
                "Paciente reclama de dor de cabeça constante",med1,pac1);

        usuarioRepository.saveAll(Arrays.asList(usu1));
        medicoRepository.saveAll(Arrays.asList(med1));
        pacienteRepository.saveAll(Arrays.asList(pac1));
        agendamentoRepository.saveAll(Arrays.asList(agd1));
    }

}
