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
@AllArgsConstructor
@NoArgsConstructor
public class ExameRequestDTO {

    @NotBlank
    private String nome_exame;
    @NotNull(message = "O padrão dever ser dd/MM/yyyy HH:mm:ss e não nulo!")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING)
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime data_hora_exame;
    @NotBlank
    private String tipo_exame;
    @NotBlank
    private String laboratorio;
    private String arquivo_exame;
    @NotBlank
    private String resultado_exame;
    @NotNull
    private Long identificador_paciente;
    @NotNull
    private Long identificador_usuario;

}
