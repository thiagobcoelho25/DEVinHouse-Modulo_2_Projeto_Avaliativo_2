package com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.requests;


import com.example.devinhousemodulo_2_projeto_avaliativo_2.models.enums.EspecializacaoClinica;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.models.enums.EstadoCivil;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UsuarioWithoutSenhaRequestDTO {
    String nome;
    String genero;
    @NotNull(message = "O padrão dever ser dd/MM/yyyy e não nulo!")
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING) //  PARA NÃO CAUSAR DateTimeParseException NA DESSERIALIZAÇÃO, AINDA ASSIM SUBSTITUIDO PELO
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    LocalDate data_nascimento;
    String cpf;
    String rg;
    @NotNull(message = "O Estado Civil deve ser Valido e não nulo!")
    EstadoCivil estado_civil;
    String telefone;
    String email;
    String naturalidade;
    @NotBlank
    private String crm_uf;
    @NotNull
    private EspecializacaoClinica especializacao;
}
