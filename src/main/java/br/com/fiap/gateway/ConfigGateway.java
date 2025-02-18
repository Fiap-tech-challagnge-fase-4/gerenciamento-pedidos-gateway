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
                .route("pedido", ped -> ped.path("/api/pedidos/**")
                        .uri("http://localhost:8084"))
                .route("produto", prd -> prd.path("/api/produtos/**")
                        .and()
                        .not(prdNot -> prdNot.path("/api/produtos/atualizarEstoque/**"))
                        .uri("http://localhost:8082"))
                .route("cliente", cli -> cli.path("/api/clientes/**")
                        .uri("http://localhost:8081"))
                .route("entrega", ent -> ent.path("/api/entregas/**")
                        .uri("http://localhost:8083"))
                .route("rastreamento", ent -> ent.path("/api/rastreamentos/**")
                        .uri("http://localhost:8083"))
                .route("carga", ent -> ent.path("/api/carga/**")
                        .uri("http://localhost:8088"))
                .build();
    }
}