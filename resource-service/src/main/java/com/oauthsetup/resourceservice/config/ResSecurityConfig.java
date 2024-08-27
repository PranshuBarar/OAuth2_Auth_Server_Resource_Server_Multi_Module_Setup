package com.oauthsetup.resourceservice.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Arrays;

@Configuration
@Order(2)
public class ResSecurityConfig {

    @Autowired
    public final JwtDecoder jwtDecoder;

    private static final Logger logger = LoggerFactory.getLogger(ResSecurityConfig.class);

    public ResSecurityConfig(JwtDecoder jwtDecoder) {
        this.jwtDecoder = jwtDecoder;
    }

    @Bean
    public SecurityFilterChain resSecurityFilterChain(HttpSecurity http) throws Exception {
        logger.info("Initializing Resource Server Security Filter Chain");

        return http
                .csrf(csrf -> csrf.ignoringRequestMatchers("/signup"))
                .authorizeHttpRequests(req -> req
                        .requestMatchers("/signup").permitAll()
                        .anyRequest().authenticated())
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()))
                .build();
    }
}
