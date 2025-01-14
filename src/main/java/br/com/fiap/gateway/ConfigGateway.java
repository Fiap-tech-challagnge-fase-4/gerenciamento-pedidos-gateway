package br.com.fiap.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigGateway {

    @Bean
    public RouteLocator custom(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("pedido", ped -> ped.path("/api/pedido/**")
                        .uri("http://localhost:8084"))
                .route("produto", prd -> prd.path("/api/produto/**")
                        .and()
                        .not(prdNot -> prdNot.path("/api/produto/atualizarEstoque/**")) // Nao deixa acessar esta rota diretamente
                        // .filters(f -> f.stripPrefix(1)) --Exemplo pra filtrar
                        .uri("http://localhost:8082"))
                .route("cliente", cli -> cli.path("/api/cliente/**")
                        .uri("http://localhost:8081"))
                .route("entrega", ent -> ent.path("/api/entrega/**")
                        .uri("http://localhost:8083"))
                .build();
    }
}