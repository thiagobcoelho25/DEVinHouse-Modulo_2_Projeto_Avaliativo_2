package com.example.devinhousemodulo_2_projeto_avaliativo_2.services;

import com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.requests.ExameRequestDTO;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.responses.ExameResponseDTO;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.mappers.ExameMapper;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.models.Exame;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.models.Paciente;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.models.Usuario;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.repositories.ExameRepository;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.repositories.PacienteRepository;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.repositories.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ExameService {

    private final ExameRepository exameRepository;
    private final UsuarioRepository usuarioRepository;
    private final PacienteRepository pacienteRepository;
    private final ExameMapper mapper;

    public ExameService(ExameRepository exameRepository, UsuarioRepository usuarioRepository, PacienteRepository pacienteRepository, ExameMapper mapper) {
        this.exameRepository = exameRepository;
        this.usuarioRepository = usuarioRepository;
        this.pacienteRepository = pacienteRepository;
        this.mapper = mapper;
    }

    public ExameResponseDTO createExame(ExameRequestDTO request) {
        Usuario usuario = usuarioRepository.findById(request.getIdentificador_usuario()).orElseThrow(() -> new EntityNotFoundException("Usuario Não Existe"));
        Paciente paciente = pacienteRepository.findById(request.getIdentificador_paciente()).orElseThrow(() -> new EntityNotFoundException("Paciente Não Existe"));

        Exame exame = mapper.map(request);

        exame.setUsuario(usuario);
        exame.setPaciente(paciente);

        return mapper.map(exameRepository.save(exame));
    }

    public ExameResponseDTO updateExame(ExameRequestDTO request, Long id) {
        Exame exame = exameRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Exame não Existe"));
        Usuario usuario = usuarioRepository.findById(request.getIdentificador_usuario()).orElseThrow(() -> new EntityNotFoundException("Usuario Não Existe"));
        Paciente paciente = pacienteRepository.findById(request.getIdentificador_paciente()).orElseThrow(() -> new EntityNotFoundException("Paciente Não Existe"));

        Exame exame_update = mapper.map(request);

        exame_update.setId(id);
        exame_update.setPaciente(paciente);
        exame_update.setUsuario(usuario);
        // PARA QUE NA HORA DO RETORNO SEJA RETORNADO O VALOR CORRETO, AINDA QUE NO BANCO NÃO SEJA ATUALIZADO, APENAS PARA O JSON
        exame_update.setData_hora_exame(exame.getData_hora_exame());

        return mapper.map(exameRepository.save(exame_update));
    }

    public ExameResponseDTO getExameById(Long id) {
        Exame exame = exameRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Exame não Existe"));
        return mapper.map(exame);
    }

    public void deleteExameById(Long id) {
        Exame exame = exameRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Exame não Existe"));
        exameRepository.delete(exame);
    }
}
