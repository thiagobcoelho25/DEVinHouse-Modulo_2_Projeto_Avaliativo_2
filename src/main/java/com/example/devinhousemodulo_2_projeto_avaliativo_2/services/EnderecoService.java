package com.example.devinhousemodulo_2_projeto_avaliativo_2.services;

import com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.requests.EnderecoRequestDTO;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.responses.EnderecoResponseDTO;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.mappers.EnderecoMapper;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.models.Endereco;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.repositories.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final EnderecoMapper mapper;

    public EnderecoService(EnderecoRepository enderecoRepository, EnderecoMapper mapper) {
        this.enderecoRepository = enderecoRepository;
        this.mapper = mapper;
    }


    public EnderecoResponseDTO createEndereco(EnderecoRequestDTO request) {
        Endereco endereco = mapper.map(request);

        return mapper.map(enderecoRepository.save(endereco));
    }

    public List<EnderecoResponseDTO> listEndereco() {
        return mapper.map(enderecoRepository.findAll());
    }
}
