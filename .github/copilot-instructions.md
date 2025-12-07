# Copilot Instructions for AI Coding Agents

## Visão Geral da Arquitetura
Este repositório contém múltiplos serviços Java Spring Boot, cada um representando um domínio de negócio distinto:
- `api-compra-pacote-viagem`: Orquestrador principal para compra de pacotes de viagem.
- `api-reserva-carro`, `api-reserva-hotel`, `api-reserva-voo`: Serviços independentes para reserva de carro, hotel e voo, respectivamente.

Cada serviço possui sua própria estrutura de projeto, com diretórios separados para código-fonte (`src/main/java`), recursos (`src/main/resources`), e testes (`src/test/java`).

## Fluxos de Desenvolvimento
- **Build:** Utilize o wrapper Maven local de cada serviço (`./mvnw clean package`) para compilar e empacotar. Exemplo:
  ```bash
  cd api-compra-pacote-viagem && ./mvnw clean package
  ```
- **Testes:** Execute os testes com:
  ```bash
  ./mvnw test
  ```
- **Execução:** Para rodar localmente, utilize:
  ```bash
  ./mvnw spring-boot:run
  ```
- **Ambiente de Integração:** O arquivo `docker-compose.yaml` na raiz permite subir múltiplos serviços simultaneamente para testes de integração.

## Padrões e Convenções Específicas
- **Estrutura de Pacotes:** O namespace base é `com.matera`, podendo variar conforme o serviço.
- **Configuração:** Cada serviço possui seu próprio `application.properties` em `src/main/resources`.
- **Comunicação entre Serviços:** A orquestração ocorre via chamadas HTTP entre os serviços, simulando um ambiente de microserviços.
- **Dependências:** Cada serviço é autônomo, com seu próprio `pom.xml`.
- **Testes:** Testes unitários e de integração estão em `src/test/java/com/matera/`.

## Exemplos de Arquivos-Chave
- `api-compra-pacote-viagem/pom.xml`: Dependências e plugins do orquestrador.
- `api-compra-pacote-viagem/src/main/resources/application.properties`: Configurações do serviço principal.
- `docker-compose.yaml`: Orquestração de múltiplos serviços para testes locais.

## Recomendações para Agentes
- Sempre utilize o Maven Wrapper (`./mvnw`) para garantir compatibilidade.
- Ao modificar integrações, valide o fluxo completo via `docker-compose`.
- Siga a estrutura de pacotes e mantenha a separação de domínios.
- Documente padrões não convencionais diretamente neste arquivo para facilitar futuras contribuições.

---

*Revise e sugira melhorias ou acrescente detalhes específicos do projeto conforme necessário.*
