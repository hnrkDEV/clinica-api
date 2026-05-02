package com.clinica.clinica_api.service.impl;

import com.clinica.clinica_api.adapter.AuditoriaAdapter;
import com.clinica.clinica_api.entity.Profissional;
import com.clinica.clinica_api.repository.AuditoriaRepository;
import com.clinica.clinica_api.repository.ProfissionalRepository;
import com.clinica.clinica_api.service.ProfissionalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfissionalServiceImpl implements ProfissionalService {

    private final ProfissionalRepository profissionalRepository;
    private final AuditoriaRepository auditoriaRepository;

    @Override
    @Transactional
    public Profissional cadastrar(Profissional profissional) {
        Profissional profissionalSalvo = profissionalRepository.save(profissional);

        auditoriaRepository.save(
                AuditoriaAdapter.profissionalCadastrado(profissionalSalvo)
        );

        return profissionalSalvo;
    }

    @Override
    public List<Profissional> listar() {
        return profissionalRepository.findAll();
    }
}