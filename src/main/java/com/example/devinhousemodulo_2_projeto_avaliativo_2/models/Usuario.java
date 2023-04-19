package com.example.devinhousemodulo_2_projeto_avaliativo_2.models;

import com.example.devinhousemodulo_2_projeto_avaliativo_2.models.enums.EspecializacaoClinica;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.models.enums.EstadoCivil;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Usuario extends Pessoa {

    @NotBlank
    private String crm_uf;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EspecializacaoClinica especializacao;


    @NotBlank()
    @Size(min = 8, message = "Senha de no mínimo 8 caracteres alfanuméricos")
    private String senha;


    @Builder
    public Usuario(String nome, String genero, LocalDate data_nascimento, String cpf, String rg, EstadoCivil estado_civil, String telefone, String email, String naturalidade, String crm_uf, EspecializacaoClinica especializacao, String senha) {
        super(nome, genero, data_nascimento, cpf, rg, estado_civil, telefone, email, naturalidade);
        this.crm_uf = crm_uf;
        this.especializacao = especializacao;
        this.senha = senha;
    }
}
