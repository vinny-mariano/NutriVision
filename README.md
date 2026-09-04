# NutriApp / NutriVision
App de registro de dieta e consumo de calorias.

Arquitetura e Fluxo Operacional — NutriApp / NutriVision

Este documento formaliza a arquitetura de microsserviços, o modelo de dados e o fluxo de trabalho ágil baseado em Kanban para o desenvolvimento do nosso MVP do Projeto Integrador.


1. Visão Geral da Arquitetura (Poliglota e Desacoplada)

Para garantir escalabilidade, manutenibilidade e segurança, nossa solução separa o domínio transacional da inteligência artificial de processamento de imagem, evitando gargalos no monólito.


```text
[ Angular SPA ]
      │ (HTTP / Multipart)
      ▼
[ Spring Boot (Gateway & Domínio) ] ──(REST / WebClient)──► [ FastAPI (Microsserviço de IA) ]
      │                                                                       │
      └──────────────────────────► [ PostgreSQL ] ◄───────────────────────────┘
```
      
Frontend (Angular): Interface de usuário responsiva e acessível para o usuário final e telas de gestão.
‌

Backend Transacional (Java / Spring Boot): Responsável pelas regras de negócio, persistência relacional, autenticação segura via JWT e gerenciamento de transações.
‌

Serviço de Visão Computacional (Python / FastAPI): Microsserviço isolado dedicado a receber imagens de refeições, processar matrizes de pixels e retornar a extração de dados nutricionais estruturados em JSON.
‌

Persistência (PostgreSQL + Flyway): Banco de dados relacional com versionamento estrito de schema e seed imutável da tabela de referência nutricional (TACO - Unicamp).
‌

2. Fluxo de Trabalho (Kanban & Sistema Pull)

Nosso processo de desenvolvimento segue rigorosamente o modelo de fluxo contínuo demonstrado em engenharia de software, garantindo qualidade por meio de subcolunas de WIP (Work in Progress):


```text
[ Angular SPA ]
      │ (HTTP / Multipart)
      ▼
[ Spring Boot (Gateway & Domínio) ] ──(REST / WebClient)──► [ FastAPI (Microsserviço de IA) ]
      │                                                                       │
      └──────────────────────────► [ PostgreSQL ] ◄───────────────────────────┘
```
      
Regras do Quadro:

Sistema Pull: Os desenvolvedores puxam ativamente as tarefas do topo do backlog conforme liberam capacidade nas subcolunas.
‌

Limitação de WIP: O trabalho em andamento é restrito para evitar gargalos de contexto e garantir entregas incrementais testadas.
‌

Ciclo de Qualidade: Nenhuma tarefa passa para a coluna seguinte sem atender aos critérios de especificação formal, codificação limpa e revisão cruzada de código.
