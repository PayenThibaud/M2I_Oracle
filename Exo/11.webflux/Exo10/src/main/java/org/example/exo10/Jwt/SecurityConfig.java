package org.example.exo10.Jwt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.AuthenticationWebFilter;
import reactor.core.publisher.Mono;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    private final JwtService jwtService;

    public SecurityConfig(JwtService jwtService) {
        this.jwtService = jwtService;
    }


    @Bean
    public ReactiveAuthenticationManager authenticationManager() {
        return authentication -> {
            if (authentication instanceof UsernamePasswordAuthenticationToken) {
                return Mono.just(authentication);
            }
            return Mono.empty();
        };
    }

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        AuthenticationWebFilter authenticationWebFilter = new AuthenticationWebFilter(authenticationManager());
        authenticationWebFilter.setServerAuthenticationConverter(new JwtAuthentificationFilter(jwtService));

        return http
                .authorizeExchange()
                .pathMatchers("/api/auth/login").permitAll()
                .pathMatchers(HttpMethod.GET, "/api/rooms").hasAnyRole("USER", "ADMIN")
                .pathMatchers(HttpMethod.POST, "/api/rooms").hasRole("ADMIN")
                .pathMatchers(HttpMethod.DELETE, "/api/rooms/{id}").hasRole("ADMIN")
                .anyExchange().authenticated()
                .and()
                .addFilterAt(authenticationWebFilter, SecurityWebFiltersOrder.AUTHENTICATION)
                .csrf().disable()
                .build();
    }
}
