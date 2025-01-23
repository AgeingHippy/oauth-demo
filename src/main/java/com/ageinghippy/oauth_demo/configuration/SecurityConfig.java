package com.ageinghippy.oauth_demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/protected").authenticated()
                        .requestMatchers("/homepage").authenticated()
                        .anyRequest().permitAll())
                .oauth2Login(oauth -> oauth
                        .defaultSuccessUrl("/homepage"))
                .logout(logout -> logout.logoutSuccessUrl("/logout-success"));
        return http.build();
    }
}

