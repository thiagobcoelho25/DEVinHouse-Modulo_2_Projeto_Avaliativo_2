package com.example.devinhousemodulo_2_projeto_avaliativo_2.services;

import com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.requests.PacienteRequestDTO;

import com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.responses.PacienteResponseDTO;

import com.example.devinhousemodulo_2_projeto_avaliativo_2.exceptions.BusinessRuleException;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.mappers.PacienteMapper;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.models.Endereco;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.models.Paciente;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.repositories.EnderecoRepository;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.repositories.PacienteRepository;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    private final EnderecoRepository enderecoRepository;

    private final PacienteMapper mapper;

    public PacienteService(PacienteRepository pacienteRepository, EnderecoRepository enderecoRepository, PacienteMapper mapper) {
        this.pacienteRepository = pacienteRepository;
        this.enderecoRepository = enderecoRepository;
        this.mapper = mapper;
    }

    public List<PacienteResponseDTO> getAllPacientes(String nome_paciente){
        if(nome_paciente.isEmpty()){
            return mapper.map(pacienteRepository.findAll());
        } else {
            return mapper.map(pacienteRepository.findAllByNomeContainingIgnoreCase(nome_paciente));
        }
    }

    public PacienteResponseDTO createPaciente(PacienteRequestDTO request){
        // ESTOU SUBSTITUINDO AO INVES DA ObjectNotFoundException, JA QUE ESSA -> EntityNotFoundException É PADRÃO DO JAKARTA, ENQUANTO A SEGUNDA DEVE SER IMPLEMENTADA.
        Endereco endereco = enderecoRepository.findById(request.getEndereco()).orElseThrow(() -> new EntityNotFoundException("Endereço não existe"));

        Paciente paciente = mapper.map(request);

        if(pacienteRepository.findPacienteByCpf(paciente.getCpf()).isPresent()){
            throw new BusinessRuleException("CPF já existente no cadastro de pacientes");
        }

        paciente.setEndereco(endereco);

        return mapper.map(pacienteRepository.save(paciente));
    }

    public PacienteResponseDTO updatePacienteById(PacienteRequestDTO request, Long id){
        Paciente paciente_inicial = pacienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Paciente não existe"));

        Paciente paciente_update = mapper.map(request);

        Endereco endereco = enderecoRepository.findById(request.getEndereco()).orElseThrow(() -> new EntityNotFoundException("Endereço não existe"));

        paciente_update.setId(id);
        paciente_update.setCpf(paciente_inicial.getCpf());
        paciente_update.setRg(paciente_inicial.getRg());
        paciente_update.setEndereco(endereco);

        return mapper.map(pacienteRepository.save(paciente_update));
    }


    public PacienteResponseDTO getPacienteById(Long id) {
        Paciente paciente = pacienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Paciente não existe"));
        return mapper.map(paciente);
    }
}
