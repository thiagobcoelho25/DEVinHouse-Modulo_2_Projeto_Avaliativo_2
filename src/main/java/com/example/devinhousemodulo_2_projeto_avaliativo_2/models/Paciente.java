package com.example.devinhousemodulo_2_projeto_avaliativo_2.models;

import com.example.devinhousemodulo_2_projeto_avaliativo_2.models.enums.EstadoCivil;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
//@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Paciente extends Pessoa {

    /*FUNCIONA SEM, MAS CAUSA ERRO DE IMPLEMENTÇÃO NA IDE intellij
        COM ISSO AO INVES DE SALVAR A LISTA NO BANCO, SALVA UMA TABELA COM ID DO PACINETE
     */
    @ElementCollection
    private List<String> alergias;
    @ElementCollection
    private List<String> cuidados;
    private String contato_emergencia;
    private String convenio;
    private String numero_carteira_convenio;
    private String validade_carteira_convenio;
    @ManyToOne
    @JoinColumn(name = "endereco_id", nullable = false)
    private Endereco endereco;


//    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Consulta> consultas = new ArrayList<>();

    @Builder
    public Paciente(String nome, String genero, LocalDate data_nascimento, String cpf, String rg, EstadoCivil estado_civil, String telefone,
                    String email, String naturalidade, List<String> alergias, List<String> cuidados, String contato_emergencia, String convenio,
                    String numero_carteira_convenio, String validade_carteira_convenio, Endereco endereco) {
        super(nome, genero, data_nascimento, cpf, rg, estado_civil, telefone,
                email, naturalidade);
        this.alergias = alergias;
        this.cuidados = cuidados;
        this.contato_emergencia = contato_emergencia;
        this.convenio = convenio;
        this.numero_carteira_convenio = numero_carteira_convenio;
        this.validade_carteira_convenio = validade_carteira_convenio;
        this.endereco = endereco;
    }
}
