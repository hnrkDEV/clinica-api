package com.clinica.clinica_api.entity;

import com.clinica.clinica_api.enums.AcaoAuditoria;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "auditorias")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Auditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private AcaoAuditoria acao;

    private String entidade;

    private Long entidadeId;

    private String descricao;

    private LocalDateTime dataHora;
}