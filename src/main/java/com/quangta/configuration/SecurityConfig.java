package com.quangta.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.crypto.spec.SecretKeySpec;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final String [] PUBLIC_ENDPOINT = {
            "/api/v1/users/create",
            "/api/v1/auth/token",
            "/api/v1/auth/introspect",
    };

    @Value("${jwt.signerKey}")
    private String signerKey;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
       http
               .authorizeHttpRequests(request -> request
                       .requestMatchers(HttpMethod.POST, PUBLIC_ENDPOINT)
                       .permitAll()
                       .anyRequest()
                       .authenticated()
               )
               .csrf(AbstractHttpConfigurer::disable)
               .oauth2ResourceServer(oauth2 -> oauth2
                       .jwt(jwtConfigurer -> jwtConfigurer.decoder(jwtDecoder()))); //decoder is an interface, so need an implement for this
        return http.build();
    }

    @Bean
    JwtDecoder jwtDecoder(){
        SecretKeySpec secretKeySpec = new SecretKeySpec(signerKey.getBytes(), "HS512");

        return NimbusJwtDecoder
                .withSecretKey(secretKeySpec)
                .macAlgorithm(MacAlgorithm.HS512)
                .build();
    }
}
