# Clínica API

API REST desenvolvida em Java com Spring Boot para controle de agendamentos de consultas em uma clínica.

## Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database
- Bean Validation
- Lombok
- JUnit
- Mockito
- Swagger / Springdoc OpenAPI

## Funcionalidades

### Pacientes
- Cadastrar paciente
- Listar pacientes

### Profissionais
- Cadastrar profissional
- Listar profissionais

### Agendamentos
- Criar agendamento
- Listar agendamentos
- Cancelar agendamento
- Filtrar agendamentos por paciente, profissional ou status

### Auditoria
- Registro de cadastro de pacientes
- Registro de cadastro de profissionais
- Registro de criação de agendamentos
- Registro de cancelamento de agendamentos

## Regras de negócio

- Um profissional não pode ter dois agendamentos no mesmo horário.
- Não é permitido criar agendamento com data/hora no passado.
- O cancelamento exige um motivo.
- Ao cancelar um agendamento, o status é alterado para `CANCELADO`.
- Agendamentos cancelados são mantidos no banco de dados.

## Como executar o projeto

### 1. Clonar o repositório

```bash
git clone https://github.com/hnrkDEV/clinica-api.git
cd clinica-api
```

## Executar a aplicação

### Opção 1 — Execução local (sem o Docker)
- No Windows:
```bash
.\gradlew bootRun
```
- No Linux/Mac:
```bash
./gradlew bootRun
```
## Executando com Docker:
```bash
docker build -t clinica-api .
docker run -p 8081:8081 clinica-api
```
### A aplicação será iniciada em:
``
http://localhost:8081
``
### Swagger
A documentação da API pode ser acessada em:
``
http://localhost:8081/swagger-ui/index.html
``
### Banco H2 - para facilitar o teste da API
console do H2:
``
http://localhost:8081/h2-console
``
Configuração: 
```
JDBC URL: jdbc:h2:mem:clinica_db
User: sa
Password: vazio
```
### Testes 
Para executar os testes automatizados:
```
.\gradlew test
```
### Estrutura do projeto
```
controller/   -> endpoints REST
service/      -> regras de negócio
repository/   -> acesso ao banco de dados
entity/       -> entidades JPA
dto/          -> objetos de entrada e saída
adapter/      -> conversão entre DTOs, entidades e auditoria
exception/    -> tratamento centralizado de erros
config/       -> configurações da aplicação
```
### Observações
Utilizei H2 para facilitar na hora de testar a API e não necessitar banco de dados, tudo ficará salvo na memória e os dados da migration já vão ser inseridos quando rodar a aplicação.
