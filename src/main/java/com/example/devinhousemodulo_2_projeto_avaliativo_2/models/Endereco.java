package com.example.devinhousemodulo_2_projeto_avaliativo_2.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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

    @Builder
    public Endereco(String cep, String cidade, String estado, String logradouro, Integer numero, String complemento, String bairro,
                    String ponto_referencia) {
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.ponto_referencia = ponto_referencia;
    }
}
