package com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoRequestDTO {

    @NotBlank
    private String cep;
    @NotBlank
    private String cidade;
    @NotBlank
    private String estado;
    @NotBlank
    private String logradouro;
    @NotNull
    private Integer numero;
    private String complemento;
    @NotBlank
    private String bairro;
    private String ponto_referencia;

}
