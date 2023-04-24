package com.example.devinhousemodulo_2_projeto_avaliativo_2.controllers;

import com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.responses.EstatisticaResponseDTO;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.services.EstatisticasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatisticas")
public class EstatisticaController {

    private final EstatisticasService estatisticasService;

    public EstatisticaController(EstatisticasService estatisticasService) {
        this.estatisticasService = estatisticasService;
    }

    @GetMapping
    public ResponseEntity<EstatisticaResponseDTO> getEstatistica() {
        return ResponseEntity.ok(estatisticasService.getEstatisticas());
    }

}
