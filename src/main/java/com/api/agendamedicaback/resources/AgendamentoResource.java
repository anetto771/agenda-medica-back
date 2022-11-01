package com.api.agendamedicaback.resources;


import com.api.agendamedicaback.domain.Agendamento;
import com.api.agendamedicaback.domain.dtos.AgendamentoDTO;
import com.api.agendamedicaback.services.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/service/agendamentos")

public class AgendamentoResource {


    @Autowired
    private AgendamentoService agendamentoService;


    @GetMapping(value = "/{id}")
    public ResponseEntity<AgendamentoDTO> findById(@PathVariable Integer id) {
        Agendamento obj = this.agendamentoService.findById(id);
        return ResponseEntity.ok().body(new AgendamentoDTO(obj));
    }

    @GetMapping
    public ResponseEntity<List<AgendamentoDTO>> findAll() {
        List<Agendamento> list = agendamentoService.findAll();
        List<AgendamentoDTO> lisDto = list.stream().map(obj -> new AgendamentoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(lisDto);
    }

    @PostMapping
    public ResponseEntity<AgendamentoDTO> create(@Valid @RequestBody AgendamentoDTO objDto) {
        Agendamento Obj = agendamentoService.create(objDto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(objDto.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AgendamentoDTO> update(@PathVariable Integer id, @Valid @RequestBody AgendamentoDTO objDto){
        Agendamento newobj = agendamentoService.update(id, objDto);
        return ResponseEntity.ok().body(new AgendamentoDTO(newobj));
    }

}