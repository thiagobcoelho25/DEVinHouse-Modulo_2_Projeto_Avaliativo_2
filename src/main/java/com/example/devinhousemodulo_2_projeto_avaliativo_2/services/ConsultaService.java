package com.example.devinhousemodulo_2_projeto_avaliativo_2.services;

import com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.requests.ConsultaRequestDTO;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.requests.ConsultaWithoutDateTimeDTO;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.dtos.responses.ConsultaResponseDTO;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.mappers.ConsultaMapper;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.models.Consulta;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.models.Paciente;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.models.Usuario;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.repositories.ConsultaRepository;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.repositories.PacienteRepository;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.repositories.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final PacienteRepository pacienteRepository;
    private final UsuarioRepository usuarioRepository;

    private final ConsultaMapper mapper;

    public ConsultaService(ConsultaRepository consultaRepository, PacienteRepository pacienteRepository, UsuarioRepository usuarioRepository, ConsultaMapper mapper) {
        this.consultaRepository = consultaRepository;
        this.pacienteRepository = pacienteRepository;
        this.usuarioRepository = usuarioRepository;
        this.mapper = mapper;
    }


    public ConsultaResponseDTO createConsulta(ConsultaRequestDTO request){
        Paciente paciente = pacienteRepository.findById(request.getIdentificador_paciente()).orElseThrow(() -> new EntityNotFoundException("Paciente Não Encontrado"));
        Usuario usuario = usuarioRepository.findById(request.getIdentificador_usuario()).orElseThrow(() -> new EntityNotFoundException("Médico Não Encontrado"));

        Consulta consulta = mapper.map(request);

        consulta.setUsuario(usuario);
        consulta.setPaciente(paciente);

        return mapper.map(consultaRepository.save(consulta));
    }

    public ConsultaResponseDTO updateConsulta(ConsultaWithoutDateTimeDTO request, Long id) {
        Consulta consulta = consultaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Consulta Não Encontrado"));
        Paciente paciente = pacienteRepository.findById(request.getIdentificador_paciente()).orElseThrow(() -> new EntityNotFoundException("Paciente Não Encontrado"));
        Usuario usuario = usuarioRepository.findById(request.getIdentificador_usuario()).orElseThrow(() -> new EntityNotFoundException("Médico Não Encontrado"));

        Consulta consulta_update = mapper.map(request);
        consulta_update.setId(id);
        consulta_update.setPaciente(paciente);
        consulta_update.setUsuario(usuario);
        consulta_update.setData_hora_consulta(consulta.getData_hora_consulta());

        return mapper.map(consultaRepository.save(consulta_update));
    }

    public ConsultaResponseDTO getConsultaById(Long id) {
        Consulta consulta = consultaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Consulta Não Encontrado"));

        return mapper.map(consulta);
    }

    public void deleteConsulta(Long id) {
        Consulta consulta = consultaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Consulta Não Encontrado"));
        consultaRepository.delete(consulta);
    }
}
