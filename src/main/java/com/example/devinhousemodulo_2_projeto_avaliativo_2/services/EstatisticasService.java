package com.example.devinhousemodulo_2_projeto_avaliativo_2.services;

import com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.responses.EstatisticaResponseDTO;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.repositories.ConsultaRepository;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.repositories.ExameRepository;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.repositories.PacienteRepository;
import org.springframework.stereotype.Service;

@Service
public class EstatisticasService {
    private final PacienteRepository pacienteRepository;
    private final ConsultaRepository consultaRepository;
    private final ExameRepository exameRepository;

    public EstatisticasService(PacienteRepository pacienteRepository, ConsultaRepository consultaRepository, ExameRepository exameRepository) {
        this.pacienteRepository = pacienteRepository;
        this.consultaRepository = consultaRepository;
        this.exameRepository = exameRepository;
    }


    public EstatisticaResponseDTO getEstatisticas() {
        EstatisticaResponseDTO dto = new EstatisticaResponseDTO();

        dto.setQuantidade_pacientes(pacienteRepository.findAll().size());
        dto.setQuantidade_consultas(consultaRepository.findAll().size());
        dto.setQuantidade_exames(exameRepository.findAll().size());

        return dto;
    }
}
