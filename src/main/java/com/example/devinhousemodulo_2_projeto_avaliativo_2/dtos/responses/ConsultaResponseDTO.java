package com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaResponseDTO {

    private Long identificador;
    private String motivo_consulta;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING)
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime data_hora_consulta;
    private String descricao_problema;
    private String medicacao_receitada;
    private String dosagen_precaucoes;
    private Long identificador_paciente;
    private Long identificador_usuario;

}
