package com.api.agendamedicaback.resources;


import com.api.agendamedicaback.domain.Paciente;
import com.api.agendamedicaback.domain.dtos.PacienteDTO;
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
@RequestMapping(value="/service/pacientes")

public class PacienteResource {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping(value="/{id}")
    public ResponseEntity<PacienteDTO> findById(@PathVariable Integer id) {
        Paciente obj = this.pacienteService.findById(id);
        return ResponseEntity.ok().body(new PacienteDTO(obj));
    }

    @GetMapping
    public ResponseEntity<List<PacienteDTO>> findAll(){
        List<Paciente> list = pacienteService.findAll();
        List<PacienteDTO> listDto = list.stream().map(obj-> new PacienteDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @PostMapping
    public ResponseEntity<PacienteDTO>create(@Valid @RequestBody PacienteDTO objDto){
        Paciente newObj = pacienteService.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PacienteDTO> update(@PathVariable Integer id, @RequestBody PacienteDTO objDto){
        Paciente obj = pacienteService.update(id, objDto);
        return ResponseEntity.ok().body(new PacienteDTO(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<PacienteDTO> delete(@PathVariable Integer id){
        pacienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
