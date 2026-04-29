package com.clinica.clinica_api.controller;

import com.clinica.clinica_api.entity.Profissional;
import com.clinica.clinica_api.repository.ProfissionalRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profissionais")
@RequiredArgsConstructor
public class ProfissionalController {

    private final ProfissionalRepository profissionalRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Profissional cadastrar(@RequestBody @Valid Profissional profissional) {
        return profissionalRepository.save(profissional);
    }

    @GetMapping
    public List<Profissional> listar() {
        return profissionalRepository.findAll();
    }
}