package io.desafio.compramoedas.conf;

import com.fasterxml.classmate.TypeResolver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.AlternateTypeRule;
import springfox.documentation.schema.AlternateTypeRules;
import springfox.documentation.schema.WildcardType;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;

import java.util.Collection;

@Configuration
@EnableSwagger2WebFlux
public class SwaggerConfig {

    @Bean
    public Docket apiForTemplates(TypeResolver typeResolver,
                                  @Value("${SERVER_CONTEXT_PATH:/}") final String contextPath,
                                  @Value("${VERSION:latest}") final String version) {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("io.desafio")
                .apiInfo(getApiInfo(version))
                .select()
                .apis(RequestHandlerSelectors.basePackage("io.desafio.compramoedas"))
                .paths(PathSelectors.any())
                .build()
                .ignoredParameterTypes(ServerHttpRequest.class)
                .pathMapping(contextPath)
                .alternateTypeRules(getRules(typeResolver));
    }


    private AlternateTypeRule[] getRules(TypeResolver typeResolver) {
        return new AlternateTypeRule[]{AlternateTypeRules.newRule(
                typeResolver.resolve(Flux.class, WildcardType.class),
                typeResolver.resolve(Collection.class, WildcardType.class)),
                AlternateTypeRules.newRule(
                        typeResolver.resolve(Flux.class,
                                typeResolver.resolve(ResponseEntity.class, WildcardType.class)),
                        typeResolver.resolve(Collection.class, WildcardType.class)),
                AlternateTypeRules.newRule(
                        typeResolver.resolve(Mono.class,
                                typeResolver.resolve(ResponseEntity.class, WildcardType.class)),
                        typeResolver.resolve(WildcardType.class)),
                AlternateTypeRules.newRule(
                        typeResolver.resolve(Mono.class, WildcardType.class),
                        typeResolver.resolve(WildcardType.class))};
    }

    private ApiInfo getApiInfo(String version) {
        return new ApiInfoBuilder()
                .title("Desafio - Compra Moedas :D")
                .version(version)
                .build();
    }
}
