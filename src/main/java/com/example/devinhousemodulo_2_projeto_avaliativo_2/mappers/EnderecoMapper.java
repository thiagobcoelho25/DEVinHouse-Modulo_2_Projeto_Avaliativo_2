package com.example.devinhousemodulo_2_projeto_avaliativo_2.mappers;

import com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.requests.EnderecoRequestDTO;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.responses.EnderecoResponseDTO;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.models.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EnderecoMapper {

    @Mapping(target = "identificador", source = "id")
    EnderecoResponseDTO map(Endereco source);
    Endereco map(EnderecoRequestDTO request);

    List<EnderecoResponseDTO> map(List<Endereco> source);

}
