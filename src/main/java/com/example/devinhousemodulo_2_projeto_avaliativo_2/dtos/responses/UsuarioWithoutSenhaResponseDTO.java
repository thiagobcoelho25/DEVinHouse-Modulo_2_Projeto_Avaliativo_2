package com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.responses;

import com.example.devinhousemodulo_2_projeto_avaliativo_2.models.enums.EspecializacaoClinica;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.models.enums.EstadoCivil;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioWithoutSenhaResponseDTO {
    private Long identificador;
    private String nome;
    private String genero;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate data_nascimento;
    private String cpf;
    private String rg;
    private EstadoCivil estado_civil;
    private String telefone;
    private String email;
    private String naturalidade;
    private String crm_uf;
    private EspecializacaoClinica especializacao;
}
