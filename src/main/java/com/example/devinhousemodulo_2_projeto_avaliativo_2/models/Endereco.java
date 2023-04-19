package com.example.devinhousemodulo_2_projeto_avaliativo_2.models;

import jakarta.persistence.*;
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
    @Column(name = "id")
    private Long id;
    private String cep;
    private String cidade;
    private String estado;
    private String logradouro;
    private Integer numero;
    private String complemento;
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
