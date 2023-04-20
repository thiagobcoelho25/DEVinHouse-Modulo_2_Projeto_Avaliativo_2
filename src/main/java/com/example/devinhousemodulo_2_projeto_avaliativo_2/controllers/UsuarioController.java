package com.example.devinhousemodulo_2_projeto_avaliativo_2.controllers;

import com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.requests.SenhaRequestDTO;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.requests.UsuarioRequestDTO;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.requests.UsuarioWithoutSenhaRequestDTO;

import com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.responses.UsuarioResponseDTO;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.responses.UsuarioWithoutSenhaResponseDTO;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> createUsuario(@Valid @RequestBody UsuarioRequestDTO request, UriComponentsBuilder uriBuilder) {
        UsuarioResponseDTO pacienteResponseDTO = usuarioService.createUsuario(request);

        URI uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(pacienteResponseDTO.getIdentificador()).toUri();

        return  ResponseEntity.created(uri).body(pacienteResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioWithoutSenhaResponseDTO> updateUsuario(@Valid @RequestBody UsuarioWithoutSenhaRequestDTO request, @PathVariable Long id){
        return ResponseEntity.ok().body(usuarioService.updateUsuario(request, id));
    }

    @PutMapping("/{id}/senha") // PODERIA SER UM PATCH, MAS FOI DECIDIDO NA DOCUMENTAÇÃO PELO PUT
    public ResponseEntity<UsuarioWithoutSenhaResponseDTO> updateSenhaUsuario(@Valid @RequestBody SenhaRequestDTO request, @PathVariable Long id){
        return ResponseEntity.ok().body(usuarioService.updateSenhaUsuario(request, id));
    }


}
