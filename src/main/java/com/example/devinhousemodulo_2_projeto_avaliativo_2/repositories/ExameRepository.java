package com.example.devinhousemodulo_2_projeto_avaliativo_2.repositories;

import com.example.devinhousemodulo_2_projeto_avaliativo_2.models.Exame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExameRepository extends JpaRepository<Exame, Long> {
}
