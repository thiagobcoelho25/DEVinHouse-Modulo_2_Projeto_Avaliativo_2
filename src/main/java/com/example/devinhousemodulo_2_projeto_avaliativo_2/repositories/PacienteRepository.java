package com.example.devinhousemodulo_2_projeto_avaliativo_2.repositories;

import com.example.devinhousemodulo_2_projeto_avaliativo_2.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    Optional<Paciente> findPacienteByCpf(String cpf);
    List<Paciente> findAllByNomeContainingIgnoreCase(String nome_paciente);
}
