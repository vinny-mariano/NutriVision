# NutriApp / NutriVision
App de registro de dieta e consumo de calorias.

Arquitetura e Fluxo Operacional — NutriApp / NutriVision

Este documento formaliza a arquitetura de microsserviços, o modelo de dados e o fluxo de trabalho ágil baseado em Kanban para o desenvolvimento do nosso MVP do Projeto Integrador.


1. Visão Geral da Arquitetura (Poliglota e Desacoplada)

Para garantir escalabilidade, manutenibilidade e segurança, nossa solução separa o domínio transacional da inteligência artificial de processamento de imagem, evitando gargalos no monólito.


```markdown
[ App Mobile (Kotlin / Android) ]
      │ (HTTP / Multipart)
      ▼
[ Spring Boot (Gateway & Domínio) ] ──(REST / WebClient)──► [ FastAPI (Microsserviço de IA) ]
      │                                                           │
      └──────────────────────────► [ PostgreSQL ] ◄───────────────┘
```
      
Interface de Usuário (Cliente):

MVP (Projeto Integrador I): Protótipo navegável interativo (Figma) para validação dos fluxos de uso e regras de negócio.

Evolução do Produto: Aplicativo nativo Android desenvolvido em Kotlin, otimizando o desempenho na captura de imagem via câmera e na comunicação com a API.

Backend Transacional (Java / Spring Boot): Responsável pelas regras de negócio, persistência relacional, autenticação segura via JWT e gerenciamento de transações.

Serviço de Visão Computacional (Python / FastAPI): Microsserviço isolado dedicado a receber imagens de refeições, processar matrizes de pixels e retornar a extração de dados nutricionais estruturados em JSON.

Persistência (PostgreSQL + Flyway): Banco de dados relacional com versionamento estrito de schema e seed imutável da tabela de referência nutricional (TACO - Unicamp).

Fluxo de Trabalho (Kanban & Sistema Pull)

Nosso processo de desenvolvimento segue rigorosamente o modelo de fluxo contínuo demonstrado em engenharia de software, garantindo qualidade por meio de subcolunas de WIP (Work in Progress):

```Markdown
┌─────────┐   ┌───────────────────────────┐   ┌─────────────────────────────┐   ┌────────────────────────────┐
│ Backlog │──►│     Especificação WIP     │──►│      Implementação WIP      │──►│   Revisão de Código WIP    │
│         │   │ (Em esp. │ Especificadas) │   │ (Em impl. │ Implementadas)  │   │ (Em revisão │ Revisadas)   │
└─────────┘   └───────────────────────────┘   └─────────────────────────────┘   └────────────────────────────┘
```

Regras do Quadro:

Sistema Pull: Os desenvolvedores puxam ativamente as tarefas do topo do backlog conforme liberam capacidade nas subcolunas.

Limitação de WIP: O trabalho em andamento é restrito para evitar gargalos de contexto e garantir entregas incrementais testadas.

Ciclo de Qualidade: Nenhuma tarefa passa para a coluna seguinte sem atender aos critérios de especificação formal, codificação limpa e revisão cruzada de código.
      
