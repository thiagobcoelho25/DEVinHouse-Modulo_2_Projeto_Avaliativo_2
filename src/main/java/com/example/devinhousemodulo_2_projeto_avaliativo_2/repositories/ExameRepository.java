package com.example.devinhousemodulo_2_projeto_avaliativo_2.repositories;

import com.example.devinhousemodulo_2_projeto_avaliativo_2.models.Exame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExameRepository extends JpaRepository<Exame, Long> {
    @Modifying
    @Query(value = "DELETE FROM exame WHERE paciente_id = :id", nativeQuery = true)
    void deleteAllById(@Param("id") Long id);
}
