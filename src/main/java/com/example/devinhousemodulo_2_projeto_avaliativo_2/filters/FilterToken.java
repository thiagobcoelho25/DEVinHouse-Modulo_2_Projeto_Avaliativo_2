package com.example.devinhousemodulo_2_projeto_avaliativo_2.filters;

import com.example.devinhousemodulo_2_projeto_avaliativo_2.models.Usuario;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.repositories.UsuarioRepository;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.services.TokenServicePersonalizado;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class FilterToken  extends OncePerRequestFilter {

    private final TokenServicePersonalizado tokenServicePersonalizado;

    private final UsuarioRepository usuarioRepository;

    public FilterToken(TokenServicePersonalizado tokenServicePersonalizado, UsuarioRepository usuarioRepository) {
        this.tokenServicePersonalizado = tokenServicePersonalizado;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token;

        String authorizarionHeader = request.getHeader("Authorization");

        if(authorizarionHeader != null){
            token = authorizarionHeader.replace("Bearer ", "");
            String subject = this.tokenServicePersonalizado.getSubject(token);

            Usuario usuario = this.usuarioRepository.findByNome(subject).orElseThrow(() -> new EntityNotFoundException("Usuario Não Encontrado"));

            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }

}
