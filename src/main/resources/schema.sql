CREATE TABLE pacientes (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           nome VARCHAR(255) NOT NULL,
                           email VARCHAR(255),
                           telefone VARCHAR(255)
);

CREATE TABLE profissionais (
                               id BIGINT AUTO_INCREMENT PRIMARY KEY,
                               nome VARCHAR(255) NOT NULL,
                               especialidade VARCHAR(255)
);

CREATE TABLE agendamentos (
                              id BIGINT AUTO_INCREMENT PRIMARY KEY,
                              paciente_id BIGINT NOT NULL,
                              profissional_id BIGINT NOT NULL,
                              data_hora TIMESTAMP,
                              tipo_atendimento VARCHAR(50),
                              status VARCHAR(50),
                              motivo_cancelamento VARCHAR(255),

                              CONSTRAINT fk_agendamento_paciente
                                  FOREIGN KEY (paciente_id) REFERENCES pacientes(id),

                              CONSTRAINT fk_agendamento_profissional
                                  FOREIGN KEY (profissional_id) REFERENCES profissionais(id)
);

CREATE TABLE auditorias (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            acao VARCHAR(100),
                            entidade VARCHAR(100),
                            entidade_id BIGINT,
                            descricao VARCHAR(255),
                            data_hora TIMESTAMP
);