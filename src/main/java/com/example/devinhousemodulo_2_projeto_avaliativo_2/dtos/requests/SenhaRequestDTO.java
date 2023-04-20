package com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SenhaRequestDTO {

    @NotBlank()
    @Size(min = 8, message = "Senha de no mínimo 8 caracteres alfanuméricos")
    private String senha;
}
