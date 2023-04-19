package com.example.devinhousemodulo_2_projeto_avaliativo_2.mappers;


import com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.requests.PacienteRequestDTO;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.responses.PacienteResponseDTO;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.models.Endereco;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.models.Paciente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PacienteMapper {

    @Mapping(target = "identificador", source = "id")
    @Mapping(target = "endereco", source = "endereco.id")
    PacienteResponseDTO map(Paciente source);

    Paciente map(PacienteRequestDTO source);

    Endereco map(Long value);

    List<PacienteResponseDTO> map(List<Paciente> source);

}
