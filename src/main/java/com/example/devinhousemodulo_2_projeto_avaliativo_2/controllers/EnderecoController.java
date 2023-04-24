package com.example.devinhousemodulo_2_projeto_avaliativo_2.controllers;

import com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.requests.EnderecoRequestDTO;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.responses.EnderecoResponseDTO;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.services.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @PostMapping
    public ResponseEntity<EnderecoResponseDTO> createEndereco(@Valid @RequestBody EnderecoRequestDTO request, UriComponentsBuilder uriBuilder){

        EnderecoResponseDTO enderecoResponseDTO = enderecoService.createEndereco(request);

        URI uri = uriBuilder.path("/consultas/{id}").buildAndExpand(enderecoResponseDTO.getIdentificador()).toUri();

        return ResponseEntity.created(uri).body(enderecoResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<EnderecoResponseDTO>> listEndereco(){
        return ResponseEntity.ok(enderecoService.listEndereco());
    }

}
