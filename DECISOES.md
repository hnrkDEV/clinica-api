
```md
# Decisões Técnicas

## Principais decisões técnicas

- Foi utilizada arquitetura em camadas, separando responsabilidades entre Controller, Service, Repository, Entity, DTO, Adapter e Exception.
- As regras de negócio foram concentradas na camada Service.
- Foram utilizados DTOs para entrada de dados, evitando acoplamento direto entre requisições e entidades.
- Foram criados Adapters para conversão entre objetos e para centralizar a criação dos registros de auditoria.
- O tratamento de erros foi centralizado com `GlobalExceptionHandler`.
- Foram separadas exceções de regra de negócio (`BusinessException`) e recurso não encontrado (`NotFoundException`).
- O banco H2 foi escolhido para facilitar a execução local do projeto.
- Foi criada uma entidade de auditoria para registrar ações importantes do sistema.
- Foram implementados testes automatizados cobrindo regras de negócio.

## O que foi priorizado

- Implementação das regras obrigatórias do desafio.
- Organização e clareza do código.
- Facilidade para executar o projeto localmente.
- Tratamento básico de erros.
- Testes automatizados.
- Documentação dos endpoints com Swagger.
- Auditoria de operações relevantes.

## O que ficou de fora

- Autenticação e autorização, pois não faziam parte do escopo obrigatório.
- Paginação nas listagens.
- Regras avançadas de disponibilidade, como duração da consulta ou agenda por intervalo.

## Uso de IA

Foi utilizada IA como apoio durante o desenvolvimento para:

- Sugerir estrutura inicial do projeto.
- Auxiliar na escrita de testes automatizados.
- Revisar boas práticas de arquitetura e tratamento de erros.
- Apoiar na documentação do projeto.

As sugestões geradas por IA foram revisadas, adaptadas manualmente ao contexto do desafio e validadas por meio de execução local, testes automatizados e testes manuais via Swagger.
