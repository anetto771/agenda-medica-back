package com.api.agendamedicaback.resources;

import com.api.agendamedicaback.domain.Medico;
import com.api.agendamedicaback.domain.dtos.MedicoDTO;
import com.api.agendamedicaback.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/service/medicos")

public class MedicoResource {

    @Autowired
    private MedicoService medicoService;

    @GetMapping(value="/{id}")
    public ResponseEntity<MedicoDTO> findById(@PathVariable Integer id) {
        Medico obj = this.medicoService.findById(id);
        return ResponseEntity.ok().body(new MedicoDTO(obj));
    }
}
