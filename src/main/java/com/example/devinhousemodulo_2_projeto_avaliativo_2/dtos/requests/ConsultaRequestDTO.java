package com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.requests;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaRequestDTO {

    @NotBlank
    private String motivo_consulta;
    @NotNull(message = "O padrão dever ser dd/MM/yyyy HH:mm:ss e não nulo!")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING)
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime data_hora_consulta;
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
