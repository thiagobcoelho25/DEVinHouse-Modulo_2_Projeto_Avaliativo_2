package com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.requests;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDTO {

    @NotBlank(message = "Login não pode ser nulo")
    private String login;
    @NotBlank(message = "Senha não pode ser nulo")
    private String password;

}
