package com.example.devinhousemodulo_2_projeto_avaliativo_2.models;

import com.example.devinhousemodulo_2_projeto_avaliativo_2.models.enums.EstadoCivil;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.validators.interfaces.EnumValidator;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@MappedSuperclass
@Data
@NoArgsConstructor
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String genero;
    private LocalDate data_nascimento;
    private String cpf;
    private String rg;
    @NotNull
    @Enumerated(EnumType.STRING)
    private EstadoCivil estado_civil;
    private String telefone;
    private String email;
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
