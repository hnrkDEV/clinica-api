package com.clinica.clinica_api.service.impl;

import com.clinica.clinica_api.entity.Agendamento;
import com.clinica.clinica_api.enums.StatusAgendamento;
import com.clinica.clinica_api.enums.TipoAtendimento;
import com.clinica.clinica_api.exception.BusinessException;
import com.clinica.clinica_api.repository.AgendamentoRepository;
import com.clinica.clinica_api.repository.PacienteRepository;
import com.clinica.clinica_api.repository.ProfissionalRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgendamentoServiceImplTest {

    @Mock
    private AgendamentoRepository agendamentoRepository;

    @Mock
    private PacienteRepository pacienteRepository;

    @Mock
    private ProfissionalRepository profissionalRepository;

    @InjectMocks
    private AgendamentoServiceImpl agendamentoService;

    @Test
    void deveLancarErroQuandoProfissionalJaPossuirAgendamentoNoMesmoHorario() {

        Long pacienteId = 1L;
        Long profissionalId = 1L;
        LocalDateTime dataHora = LocalDateTime.now().plusDays(1);

        Agendamento agendamento = Agendamento.builder()
                .tipoAtendimento(TipoAtendimento.CONSULTA)
                .build();

        when(agendamentoRepository.existsByProfissionalIdAndDataHoraAndStatus(
                profissionalId,
                dataHora,
                StatusAgendamento.AGENDADO
        )).thenReturn(true);

        assertThrows(BusinessException.class, () ->
                agendamentoService.criar(
                        pacienteId,
                        profissionalId,
                        dataHora,
                        agendamento
                )
        );
    }

    @Test
    void deveLancarErroQuandoDataForNoPassado() {

        Long pacienteId = 1L;
        Long profissionalId = 1L;
        LocalDateTime dataHora = LocalDateTime.now().minusDays(1);

        Agendamento agendamento = Agendamento.builder()
                .tipoAtendimento(TipoAtendimento.CONSULTA)
                .build();

        assertThrows(BusinessException.class, () ->
                agendamentoService.criar(
                        pacienteId,
                        profissionalId,
                        dataHora,
                        agendamento
                )
        );
    }
}