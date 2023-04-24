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
public class ExameResponseDTO {

    private Long identificador;
    private String nome_exame;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING)
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime data_hora_exame;
    private String tipo_exame;
    private String laboratorio;
    private String arquivo_exame;
    private String resultado_exame;
    private Long identificador_paciente;
    private Long identificador_usuario;

}
