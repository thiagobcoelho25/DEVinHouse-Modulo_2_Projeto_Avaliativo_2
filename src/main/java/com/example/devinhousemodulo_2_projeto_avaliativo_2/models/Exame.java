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
public class Exame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome_exame;
    @NotNull
    @Column(updatable = false)
    private LocalDateTime data_hora_exame;
    @NotBlank
    private String tipo_exame;
    @NotBlank
    private String laboratorio;
    private String arquivo_exame;
    @NotBlank
    private String resultado_exame;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Builder
    public Exame(String nome_exame, LocalDateTime data_hora_exame, String tipo_exame, String laboratorio,
                 String arquivo_exame, String resultado_exame, Paciente paciente, Usuario usuario) {
        this.nome_exame = nome_exame;
        this.data_hora_exame = data_hora_exame;
        this.tipo_exame = tipo_exame;
        this.laboratorio = laboratorio;
        this.arquivo_exame = arquivo_exame;
        this.resultado_exame = resultado_exame;
        this.paciente = paciente;
        this.usuario = usuario;
    }
}
