package com.example.devinhousemodulo_2_projeto_avaliativo_2.controllers;

import com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.requests.ConsultaRequestDTO;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.requests.ConsultaWithoutDateTimeDTO;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.responses.ConsultaResponseDTO;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.services.ConsultaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    private final ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @PostMapping
    public ResponseEntity<ConsultaResponseDTO> createConsulta(@Valid @RequestBody ConsultaRequestDTO request, UriComponentsBuilder uriBuilder){

        ConsultaResponseDTO consultaResponseDTO = consultaService.createConsulta(request);

        URI uri = uriBuilder.path("/consultas/{id}").buildAndExpand(consultaResponseDTO.getIdentificador()).toUri();

        return ResponseEntity.created(uri).body(consultaResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsultaResponseDTO> updateConsulta(@Valid @RequestBody ConsultaWithoutDateTimeDTO request, @PathVariable Long id){
        return ResponseEntity.ok(consultaService.updateConsulta(request, id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaResponseDTO> getConsultaById(@PathVariable Long id){
        return ResponseEntity.ok(consultaService.getConsultaById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConsulta(@PathVariable Long id) {
        consultaService.deleteConsulta(id);
        return ResponseEntity.noContent().build();
    }

}
