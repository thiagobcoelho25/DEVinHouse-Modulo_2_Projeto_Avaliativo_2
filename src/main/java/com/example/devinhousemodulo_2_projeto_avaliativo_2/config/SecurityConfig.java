package com.example.devinhousemodulo_2_projeto_avaliativo_2.config;

import com.example.devinhousemodulo_2_projeto_avaliativo_2.filters.FilterToken;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;


@EnableWebSecurity
@Configuration
public class SecurityConfig {

    private final FilterToken filterToken;

    public SecurityConfig(FilterToken filterToken) {
        this.filterToken = filterToken;
    }


    // VER VIDEO PARA IMPLEMENTAR USER IN MEMORY WITH TOKEN
    // https://www.youtube.com/watch?v=laaCEkhf5cU
    @Bean
    public SecurityFilterChain customSecurityFilterChain(HttpSecurity http) throws Exception {
        /*
        Junção de:
        https://stackoverflow.com/questions/74680244/h2-database-console-not-opening-with-spring-security
        https://github.com/spring-projects/spring-security/issues/12546
        */
//        return http
//                .authorizeHttpRequests()
//                .requestMatchers(antMatcher(HttpMethod.POST, "/login")).permitAll()
//                .anyRequest().authenticated()
//                .and()
////                .formLogin().defaultSuccessUrl("/produto/all",true).permitAll()
////                .and()
//                .headers(headers -> headers.frameOptions().disable())
//                .csrf(csrf -> csrf
//                        .ignoringRequestMatchers(antMatcher("/h2-console/**")))
//                .build();
        return http.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeHttpRequests()
                .requestMatchers(antMatcher("/h2-console/**")).permitAll()
                .requestMatchers(antMatcher("/login")).permitAll()
                .anyRequest().authenticated()
                .and().addFilterBefore(filterToken, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
