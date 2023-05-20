package com.example.missyou.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception
    {
        httpSecurity = httpSecurity.cors().and().csrf().disable();
        httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeHttpRequests()
                .requestMatchers("/v3/api-docs/**", "/swagger-ui.html", "/swagger-ui/**")
                .permitAll()
                .requestMatchers("/api/v1/app-user/registration")
                .permitAll()
                .anyRequest()
                .authenticated();
        return httpSecurity.build();
    }
}
