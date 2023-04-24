package com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.requests;


import com.example.devinhousemodulo_2_projeto_avaliativo_2.models.enums.EstadoCivil;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PacienteRequestDTO {

    @NotBlank
    String nome;
    @NotBlank
    String genero;

    @NotNull(message = "O padrão dever ser dd/MM/yyyy e não nulo!")
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING) //  PARA NÃO CAUSAR DateTimeParseException NA DESSERIALIZAÇÃO, AINDA ASSIM SUBSTITUIDO PELO
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    LocalDate data_nascimento;
    @NotBlank
    String cpf;
    @NotBlank
    String rg;

    @NotNull(message = "O Estado Civil deve ser Valido e não nulo!")
    EstadoCivil estado_civil;
    @NotBlank
    String telefone;
    @NotBlank
    String email;
    @NotBlank
    String naturalidade;
    List<String> alergias;
    List<String> cuidados;
    @NotBlank(message = "O Contato de Emergência não pode ser vazio ou nulo!")
    String contato_emergencia;
    String convenio;
    String numero_carteira_convenio;
    String validade_carteira_convenio;
    @NotNull(message = "Indentificador do Endereço não pode ser nulo")
    @Min(value = 1, message = "O valor minino para esse campo e a partir de 1")
    Long endereco;
}
