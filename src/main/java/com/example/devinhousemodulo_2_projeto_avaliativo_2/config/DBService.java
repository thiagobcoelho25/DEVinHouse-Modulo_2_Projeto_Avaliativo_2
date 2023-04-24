package com.example.devinhousemodulo_2_projeto_avaliativo_2.config;

import com.example.devinhousemodulo_2_projeto_avaliativo_2.models.*;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.models.enums.EspecializacaoClinica;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.models.enums.EstadoCivil;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.repositories.*;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DBService {

    private final EnderecoRepository enderecoRepository;
    private final PacienteRepository pacienteRepository;
    private final ConsultaRepository consultaRepository;
    private final UsuarioRepository usuarioRepository;
    private final ExameRepository exameRepository;

    public DBService(EnderecoRepository enderecoRepository, PacienteRepository pacienteRepository, ConsultaRepository consultaRepository, UsuarioRepository usuarioRepository, ExameRepository exameRepository) {
        this.enderecoRepository = enderecoRepository;
        this.pacienteRepository = pacienteRepository;
        this.consultaRepository = consultaRepository;
        this.usuarioRepository = usuarioRepository;
        this.exameRepository = exameRepository;
    }

    public void instantiateTestDatabase() throws ParseException {

        Endereco endereco_1 = new Endereco("29313810", "Cachoeiro", "ES", "Logradouro 1", 45, "nenhum complemento", "Bairro 1",
                "nenhum ponto referencia");

        Endereco endereco_2 = new Endereco("72859380", "Somewhere Beyond Time & Space", "Imaginario", "Rua sem nome", 45, "nenhum complemento", "Bairro 2",
                "nenhum ponto referencia");

        Endereco endereco_3 = new Endereco("68903215", "Vitoria", "ES", "Rua 3", 76, "perto posto oasis", "Bairro 3",
                "nenhum ponto referencia");

        Endereco endereco_4 = new Endereco("58303355", "São Paulo", "SP", "4", 89, "nenhum complemento", "Bairro 4",
                "nenhum ponto referencia");

        Paciente paciente_1 = new Paciente("Thiago", "masculino", LocalDate.of(2001, 8, 7),
                "62155358008", "283925358", EstadoCivil.SOLTEIRO, "99939393", "thiago@email.com", "Brasileira",
                List.of("Camarão","Amendoim"), List.of("Cuidado Perna", "Cuidado cabeça"),
                "9995859", "SANTA CASA", "9393", "09/09/2023", endereco_1);

        Paciente paciente_2 = new Paciente("GUTO", "Não Binario", LocalDate.of(2002, 8, 8),
                "28526650009", "298842312", EstadoCivil.SOLTEIRO, "99949993", "guto@email.com", "Brasileira",
                null, List.of("Cuidado cabeça"),
                "9995859", "UNIMED", "9293", "09/09/2023", endereco_2);

        Usuario usuario_1 = new Usuario("Médico 1", "Não Binario", LocalDate.of(2001,8,8), "3212321231", "3123-SP",
                EstadoCivil.DIVORCIADO, "99984948", "medico_1@gmail.com", "Brasileira", "121212-es",
                EspecializacaoClinica.CLINICO_GERAL, "12345678");

        Usuario usuario_2 = new Usuario("Médico 2", "Feminino", LocalDate.of(2001,8,8), "3212321231", "3123-SP",
                EstadoCivil.CASADO, "99984948", "medico_1@gmail.com", "Brasileira", "121212-es",
                EspecializacaoClinica.GINECOLOGIA, "senhaforte123");

        Consulta consulta_1 = new Consulta("Consulta Rotina", LocalDateTime.now(), "Apenas consulta de rotina",
                "nenhuma", "nenhuma", paciente_1, usuario_1);

        Consulta consulta_2 = new Consulta("Consulta Retorno", LocalDateTime.now(), "Retorno da consulta de rotina",
                "nenhuma", "nenhuma", paciente_1, usuario_1);

        Consulta consulta_3 = new Consulta("Consulta Inicial", LocalDateTime.now(), "Consulta Inicial para averiguação de dor joelho",
                "Dipirona", "3x ao dia", paciente_2, usuario_2);

        Consulta consulta_4 = new Consulta("Retorno de Consulta Inicial", LocalDateTime.now(), "Retorno da consulta Inicial",
                "nenhuma", "diminuição de Execicios", paciente_2, usuario_2);

        Exame exame_1 = new Exame("Exame comum", LocalDateTime.now(), "Exame sangue", "Laboratorio Analises CLinicas",
                "https://docs.google.com/document/d/101UUYQBIvVog0CVIFefyPaJiVrZkW04-LZndx5fj1Qo/edit", "tudo OK!",paciente_1, usuario_1);

        Exame exame_2 = new Exame("Ultrasonografia", LocalDateTime.now(), "Ultrasonografia", "Laboratorio Analises CLinicas",
                "https://docs.google.com/document/d/101UUYQBIvVog0CVIFefyPaJiVrZkW04-LZndx5fj1Qo/edit", "tudo OK!",paciente_2, usuario_1);

        Exame exame_3 = new Exame("Exame rotina", LocalDateTime.now(), "Eletrocardiograma", "Laboratorio 2",
                "https://docs.google.com/document/d/101UUYQBIvVog0CVIFefyPaJiVrZkW04-LZndx5fj1Qo/edit", "tudo OK!",paciente_1, usuario_2);

        Exame exame_4 = new Exame("Exame comum", LocalDateTime.now(), "teste nervo cranial", "Laboratorio 3",
                "https://docs.google.com/document/d/101UUYQBIvVog0CVIFefyPaJiVrZkW04-LZndx5fj1Qo/edit", "tudo OK!",paciente_1, usuario_2);

        enderecoRepository.saveAll(List.of(endereco_1, endereco_2, endereco_3, endereco_4));
        pacienteRepository.saveAll(List.of(paciente_1, paciente_2));
        usuarioRepository.saveAll(List.of(usuario_1, usuario_2));
        consultaRepository.saveAll(List.of(consulta_1, consulta_2, consulta_3, consulta_4));
        exameRepository.saveAll(List.of(exame_1, exame_2, exame_3, exame_4));
    }
}
