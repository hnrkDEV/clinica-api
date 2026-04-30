package com.clinica.clinica_api.adapter;

import com.clinica.clinica_api.entity.Agendamento;
import com.clinica.clinica_api.entity.Auditoria;
import com.clinica.clinica_api.entity.Paciente;
import com.clinica.clinica_api.entity.Profissional;
import com.clinica.clinica_api.enums.AcaoAuditoria;

import java.time.LocalDateTime;

public class AuditoriaAdapter {

    public static Auditoria pacienteCadastrado(Paciente paciente) {
        return Auditoria.builder()
                .acao(AcaoAuditoria.PACIENTE_CADASTRADO)
                .entidade("Paciente")
                .entidadeId(paciente.getId())
                .descricao("Paciente cadastrado: " + paciente.getNome())
                .dataHora(LocalDateTime.now())
                .build();
    }

    public static Auditoria profissionalCadastrado(Profissional profissional) {
        return Auditoria.builder()
                .acao(AcaoAuditoria.PROFISSIONAL_CADASTRADO)
                .entidade("Profissional")
                .entidadeId(profissional.getId())
                .descricao("Profissional cadastrado: " + profissional.getNome())
                .dataHora(LocalDateTime.now())
                .build();
    }

    public static Auditoria agendamentoCriado(Agendamento agendamento) {
        return Auditoria.builder()
                .acao(AcaoAuditoria.AGENDAMENTO_CRIADO)
                .entidade("Agendamento")
                .entidadeId(agendamento.getId())
                .descricao("Agendamento criado para o profissional ID " + agendamento.getProfissional().getId())
                .dataHora(LocalDateTime.now())
                .build();
    }

    public static Auditoria agendamentoCancelado(Agendamento agendamento, String motivo) {
        return Auditoria.builder()
                .acao(AcaoAuditoria.AGENDAMENTO_CANCELADO)
                .entidade("Agendamento")
                .entidadeId(agendamento.getId())
                .descricao("Agendamento cancelado. Motivo: " + motivo)
                .dataHora(LocalDateTime.now())
                .build();
    }
}