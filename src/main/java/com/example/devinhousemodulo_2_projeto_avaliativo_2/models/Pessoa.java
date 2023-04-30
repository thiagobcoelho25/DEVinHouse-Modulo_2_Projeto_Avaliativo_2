package com.example.devinhousemodulo_2_projeto_avaliativo_2.models;

import com.example.devinhousemodulo_2_projeto_avaliativo_2.models.enums.EstadoCivil;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@MappedSuperclass
@Data
@NoArgsConstructor
public abstract class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(unique = true)
    private String nome;
    @NotBlank
    private String genero;
    @NotNull
    private LocalDate data_nascimento;
    @NotBlank
    private String cpf;
    @NotBlank
    private String rg;
    @NotNull
    @Enumerated(EnumType.STRING)
    private EstadoCivil estado_civil;
    @NotBlank
    private String telefone;
    @NotBlank
    private String email;
    @NotBlank
    private String naturalidade;

    public Pessoa(String nome, String genero, LocalDate data_nascimento, String cpf, String rg, EstadoCivil estado_civil, String telefone,
                  String email, String naturalidade) {
        this.nome = nome;
        this.genero = genero;
        this.data_nascimento = data_nascimento;
        this.cpf = cpf;
        this.rg = rg;
        this.estado_civil = estado_civil;
        this.telefone = telefone;
        this.email = email;
        this.naturalidade = naturalidade;
    }
}
