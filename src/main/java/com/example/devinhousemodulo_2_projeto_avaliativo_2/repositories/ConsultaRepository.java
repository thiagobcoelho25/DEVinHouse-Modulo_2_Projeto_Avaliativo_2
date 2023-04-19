package com.example.devinhousemodulo_2_projeto_avaliativo_2.repositories;

import com.example.devinhousemodulo_2_projeto_avaliativo_2.models.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}
