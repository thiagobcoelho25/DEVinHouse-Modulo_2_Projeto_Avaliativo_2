package com.example.devinhousemodulo_2_projeto_avaliativo_2.mappers;

import com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.requests.UsuarioRequestDTO;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.requests.UsuarioWithoutSenhaRequestDTO;

import com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.responses.UsuarioResponseDTO;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.responses.UsuarioWithoutSenhaResponseDTO;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.models.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UsuarioMapper {

    @Mapping(target = "identificador", source = "id")
    UsuarioResponseDTO map(Usuario source);

    Usuario map(UsuarioRequestDTO source);

    List<UsuarioResponseDTO> map(List<Usuario> source);

    @Mapping(target = "identificador", source = "id")
    UsuarioWithoutSenhaResponseDTO mapWithoutSenha(Usuario source);

    Usuario mapWithoutSenha(UsuarioWithoutSenhaRequestDTO source);

}
