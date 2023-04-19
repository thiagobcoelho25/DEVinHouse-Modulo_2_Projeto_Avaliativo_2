package com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.responses;

import com.example.devinhousemodulo_2_projeto_avaliativo_2.models.Consulta;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.models.Endereco;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.models.Exame;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.models.enums.EstadoCivil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PacienteResponseDTO {

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
    private List<String> alergias;
    private List<String> cuidados;
    private String contato_emergencia;
    private String convenio;
    private String numero_carteira_convenio;
    private String validade_carteira_convenio;
    private Long endereco;
    private List<Exame> exames = new ArrayList<>();

}
