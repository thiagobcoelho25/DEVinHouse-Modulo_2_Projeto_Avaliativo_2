package com.example.devinhousemodulo_2_projeto_avaliativo_2.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String motivo_consulta;
    private LocalDateTime data_hora_consulta;
    private String descricao_problema;
    private String medicacao_receitada;
    private String dosagen_precaucoes;
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @Builder
    public Consulta(String motivo_consulta, LocalDateTime data_hora_consulta, String descricao_problema, String medicacao_receitada, String dosagen_precaucoes, Paciente paciente) {
        this.motivo_consulta = motivo_consulta;
        this.data_hora_consulta = data_hora_consulta;
        this.descricao_problema = descricao_problema;
        this.medicacao_receitada = medicacao_receitada;
        this.dosagen_precaucoes = dosagen_precaucoes;
        this.paciente = paciente;
    }
}
