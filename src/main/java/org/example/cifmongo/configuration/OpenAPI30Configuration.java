package org.example.cifmongo.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class OpenAPI30Configuration {
    @Value("${application.swagger-url}")
    private String swaggerUrl;

    @Bean
    public OpenAPI customOpenAPI() {
        Server server = new Server();
        server.setDescription("Base url");
        server.setUrl(swaggerUrl);
        final String securitySchemeName = "bearerAuth";
        return new OpenAPI()
//                .servers(Arrays.asList(server))
//                .components(new Components().addSecuritySchemes("Bearer  (apiKey)",
//                        new SecurityScheme().type(SecurityScheme.Type.APIKEY).scheme("bearer").bearerFormat("JWT")
//                                .in(SecurityScheme.In.HEADER).name("Authorization")))
//                .info(new Info().title("Сервис SPPR").version("1.00"))
//                .addSecurityItem(
//                        new SecurityRequirement().addList("Bearer  (apiKey)", Arrays.asList("read", "write")))
                ;
    }

}
