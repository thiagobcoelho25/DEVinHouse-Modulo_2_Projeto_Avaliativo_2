package com.example.devinhousemodulo_2_projeto_avaliativo_2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.expression.ParseException;

@Configuration
@Profile("test")
public class TesteConfig {

    private final DBService dbService;

    public TesteConfig(DBService dbService) {
        this.dbService = dbService;
    }

    @Bean
    public boolean instantiateDatabase() throws ParseException {
        dbService.instantiateTestDatabase();
        return true;
    }

}
