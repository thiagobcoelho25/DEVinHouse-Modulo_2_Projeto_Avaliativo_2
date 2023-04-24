package com.example.devinhousemodulo_2_projeto_avaliativo_2.controllers;

import com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.requests.ExameRequestDTO;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.responses.ExameResponseDTO;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.services.ExameService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/exames")
public class ExameController {

    private final ExameService exameService;

    public ExameController(ExameService exameService) {
        this.exameService = exameService;
    }


    @PostMapping
    public ResponseEntity<ExameResponseDTO> createExame(@Valid @RequestBody ExameRequestDTO request, UriComponentsBuilder uriBuilder){

        ExameResponseDTO exameResponseDTO = exameService.createExame(request);

        URI uri = uriBuilder.path("/exames/{id}").buildAndExpand(exameResponseDTO.getIdentificador()).toUri();

        return ResponseEntity.created(uri).body(exameResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExameResponseDTO> updateExame(@Valid @RequestBody ExameRequestDTO request, @PathVariable Long id){
        return ResponseEntity.ok(exameService.updateExame(request, id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExameResponseDTO> getExameById(@PathVariable Long id){
        return ResponseEntity.ok(exameService.getExameById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExameById(@PathVariable Long id){
        exameService.deleteExameById(id);
        return ResponseEntity.noContent().build();
    }
}
