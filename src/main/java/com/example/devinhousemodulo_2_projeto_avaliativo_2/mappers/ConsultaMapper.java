package com.example.devinhousemodulo_2_projeto_avaliativo_2.mappers;

import com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.requests.ConsultaRequestDTO;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.requests.ConsultaWithoutDateTimeDTO;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.responses.ConsultaResponseDTO;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.models.Consulta;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ConsultaMapper {

    @Mapping(target = "identificador", source = "id")
    @Mapping(target = "identificador_usuario", source = "usuario.id")
    @Mapping(target = "identificador_paciente", source = "paciente.id")
    ConsultaResponseDTO map(Consulta source);
    Consulta map(ConsultaRequestDTO request);
    Consulta map(ConsultaWithoutDateTimeDTO request);

    List<ConsultaResponseDTO> map(List<Consulta> source);
}
