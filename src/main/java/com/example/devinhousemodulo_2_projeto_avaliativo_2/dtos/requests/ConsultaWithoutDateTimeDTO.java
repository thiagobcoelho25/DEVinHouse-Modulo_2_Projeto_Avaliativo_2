package com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaWithoutDateTimeDTO {

    @NotBlank
    private String motivo_consulta;
    @NotBlank
    private String descricao_problema;
    @NotBlank
    private String medicacao_receitada;
    @NotBlank
    private String dosagen_precaucoes;
    @NotNull
    private Long identificador_paciente;
    @NotNull
    private Long identificador_usuario;
}
