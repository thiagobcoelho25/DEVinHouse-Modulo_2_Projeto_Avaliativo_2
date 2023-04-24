package com.example.devinhousemodulo_2_projeto_avaliativo_2.mappers;


import com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.requests.ExameRequestDTO;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.responses.ExameResponseDTO;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.models.Exame;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ExameMapper {

    @Mapping(target = "identificador", source = "id")
    @Mapping(target = "identificador_usuario", source = "usuario.id")
    @Mapping(target = "identificador_paciente", source = "paciente.id")
    ExameResponseDTO map(Exame source);
    Exame map(ExameRequestDTO request);
    List<ExameResponseDTO> map(List<Exame> source);
}
