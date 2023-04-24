package com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstatisticaResponseDTO {

    private int quantidade_pacientes;
    private int quantidade_consultas;
    private int quantidade_exames;
}
