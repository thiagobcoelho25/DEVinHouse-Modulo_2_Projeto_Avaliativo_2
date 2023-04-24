package com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.requests;

import com.example.devinhousemodulo_2_projeto_avaliativo_2.models.enums.EspecializacaoClinica;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.models.enums.EstadoCivil;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequestDTO {

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
    @NotBlank
    private String crm_uf;
    @NotNull
    private EspecializacaoClinica especializacao;
    @NotBlank()
    @Size(min = 8, message = "Senha de no mínimo 8 caracteres alfanuméricos")
    private String senha;

}
