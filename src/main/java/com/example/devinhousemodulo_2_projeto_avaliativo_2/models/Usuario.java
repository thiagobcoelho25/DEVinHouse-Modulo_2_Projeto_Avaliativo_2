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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Usuario extends Pessoa implements UserDetails {

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return this.getSenha();
    }

    @Override
    public String getUsername() {
        return this.getNome();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
