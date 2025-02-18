#  Microsserviço de Orquestração com Spring Cloud Gateway

Este projeto faz parte do *Tech Challenge - Fase 4* e implementa um Microsserviço de Orquestração utilizando Spring Cloud Gateway. Ele atua como um gateway para os outros microsserviços agindo de modo a centralizar as requisições de forma transparente. Essa abordagem melhora a escalabilidade, segurança e manutenção da arquitetura.

## Tecnologias Utilizadas

- **Java 17**: Versão de linguagem utilizada.
- **Spring Boot**: Framework para desenvolvimento de aplicações Java.
- **Spring Cloud Gateway**:  Solução para roteamento dinâmico e gestão de requisições entre microsserviços.

## Para executar a aplicação via Docker, siga os comandos abaixo:

1. **Faça login no Docker:**
   ```bash
   docker login
    ```
2. **Execute o seguinte comando para subir os serviços:**
     ```bash
    docker compose up -d
    ```