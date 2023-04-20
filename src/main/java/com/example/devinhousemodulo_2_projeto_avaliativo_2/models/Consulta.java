package com.example.devinhousemodulo_2_projeto_avaliativo_2.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotBlank
    private String motivo_consulta;
    @NotNull
    private LocalDateTime data_hora_consulta;
    @NotBlank
    private String descricao_problema;
    @NotBlank
    private String medicacao_receitada;
    @NotBlank
    private String dosagen_precaucoes;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Builder
    public Consulta(String motivo_consulta, LocalDateTime data_hora_consulta, String descricao_problema, String medicacao_receitada,
                    String dosagen_precaucoes, Paciente paciente, Usuario usuario) {
        this.motivo_consulta = motivo_consulta;
        this.data_hora_consulta = data_hora_consulta;
        this.descricao_problema = descricao_problema;
        this.medicacao_receitada = medicacao_receitada;
        this.dosagen_precaucoes = dosagen_precaucoes;
        this.paciente = paciente;
        this.usuario = usuario;
    }
}
