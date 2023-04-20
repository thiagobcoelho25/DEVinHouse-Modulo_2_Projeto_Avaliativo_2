package com.example.devinhousemodulo_2_projeto_avaliativo_2.services;

import com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.requests.SenhaRequestDTO;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.requests.UsuarioRequestDTO;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.requests.UsuarioWithoutSenhaRequestDTO;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.responses.UsuarioWithoutSenhaResponseDTO;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.responses.UsuarioResponseDTO;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.exceptions.BusinessRuleException;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.mappers.UsuarioMapper;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.models.Usuario;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.repositories.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final UsuarioMapper mapper;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper mapper) {
        this.usuarioRepository = usuarioRepository;
        this.mapper = mapper;
    }


    public UsuarioResponseDTO createUsuario(UsuarioRequestDTO request) {
        if(usuarioRepository.findUsuarioByCpf(request.getCpf()).isPresent()){
            throw new BusinessRuleException("CPF Já Existente no Cadastro de Usuario");
        }

        Usuario usuario = mapper.map(request);

        return mapper.map(usuarioRepository.save(usuario));

    }

    public UsuarioWithoutSenhaResponseDTO updateUsuario(UsuarioWithoutSenhaRequestDTO request, Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuario Não Existe"));

        Usuario usuario_update = mapper.mapWithoutSenha(request);
        usuario_update.setId(id);
        usuario_update.setCpf(usuario.getCpf());
        usuario_update.setRg(usuario.getRg());
        usuario_update.setSenha(usuario.getSenha());

        return mapper.mapWithoutSenha(usuarioRepository.save(usuario_update));
    }

    public UsuarioWithoutSenhaResponseDTO updateSenhaUsuario(SenhaRequestDTO request, Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuario Não Existe"));

        usuario.setSenha(request.getSenha());
        usuarioRepository.save(usuario);

        return mapper.mapWithoutSenha(usuario);
    }
}
