package com.example.devinhousemodulo_2_projeto_avaliativo_2.controllers;

import com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.requests.PacienteRequestDTO;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.responses.PacienteResponseDTO;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.services.PacienteService;
import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;



    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping
    public ResponseEntity<List<PacienteResponseDTO>> getAllPacientes(@RequestParam(name = "nome_paciente", required = false) String nome_paciente) {
        return  ResponseEntity.ok(pacienteService.getAllPacientes(nome_paciente));
    }

    @PostMapping
    public ResponseEntity<PacienteResponseDTO> createPaciente(@Valid @RequestBody PacienteRequestDTO request, UriComponentsBuilder uriBuilder) {
        PacienteResponseDTO pacienteResponseDTO = pacienteService.createPaciente(request);

        URI uri = uriBuilder.path("/pacientes/{id}").buildAndExpand(pacienteResponseDTO.getIdentificador()).toUri();

        return  ResponseEntity.created(uri).body(pacienteResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteResponseDTO> updatePacienteById(@Valid @RequestBody PacienteRequestDTO request, @PathVariable Long id){

        return ResponseEntity.ok(pacienteService.updatePacienteById(request, id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponseDTO> getPacienteById(@PathVariable Long id) {
        return  ResponseEntity.ok(pacienteService.getPacienteById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConsulta(@PathVariable Long id) {
        pacienteService.deletePaciente(id);
        return ResponseEntity.noContent().build();
    }

}
