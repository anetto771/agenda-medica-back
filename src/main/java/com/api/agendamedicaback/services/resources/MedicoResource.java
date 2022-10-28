package com.api.agendamedicaback.services.resources;


import com.api.agendamedicaback.domain.Medico;
import com.api.agendamedicaback.domain.Paciente;
import com.api.agendamedicaback.domain.dtos.MedicoDTO;
import com.api.agendamedicaback.domain.dtos.PacienteDTO;
import com.api.agendamedicaback.services.MedicoService;
import com.api.agendamedicaback.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping
    public ResponseEntity<List<MedicoDTO>> findAll(){
        List<Medico> list = medicoService.findAll();
        List<MedicoDTO> listDto = list.stream().map(obj-> new MedicoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @PostMapping
    public ResponseEntity<MedicoDTO>create(@Valid @RequestBody MedicoDTO objDto){
        Medico newObj = medicoService.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<MedicoDTO> update(@PathVariable Integer id, @RequestBody MedicoDTO objDto){
        Medico obj = medicoService.update(id, objDto);
        return ResponseEntity.ok().body(new MedicoDTO(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<MedicoDTO> delete(@PathVariable Integer id){
        medicoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
