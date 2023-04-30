package com.example.devinhousemodulo_2_projeto_avaliativo_2.controllers;


import com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.requests.LoginRequestDTO;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.models.Usuario;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.services.TokenServicePersonalizado;
import jakarta.validation.Valid;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;

    private final TokenServicePersonalizado tokenServicePersonalizado;

    public AuthenticationController(AuthenticationManager authenticationManager, TokenServicePersonalizado tokenServicePersonalizado) {
        this.authenticationManager = authenticationManager;
        this.tokenServicePersonalizado = tokenServicePersonalizado;
    }

    @PostMapping()
    public String autenticar(@Valid @RequestBody LoginRequestDTO loginDTO){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginDTO.getLogin(), loginDTO.getPassword());

        Authentication authentication = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        Usuario usuario = (Usuario) authentication.getPrincipal();

        String token = tokenServicePersonalizado.gerarToken(usuario);

        return token;
    }
}
