package com.example.devinhousemodulo_2_projeto_avaliativo_2.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
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
}
