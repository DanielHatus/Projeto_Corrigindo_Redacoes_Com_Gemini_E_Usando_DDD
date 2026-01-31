package com.example.correct.Easy.infra.config;

import com.example.correct.Easy.infra.exception.response.filter.ResponseEntryException;
import com.example.correct.Easy.infra.security.filter.FilterJwtRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig{

    private final ResponseEntryException entryException;
    private final FilterJwtRequest filterJwtRequest;

    public SecurityConfig(ResponseEntryException entryException, FilterJwtRequest filterJwtRequest) {
        this.entryException = entryException;
        this.filterJwtRequest = filterJwtRequest;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)throws Exception{
        return httpSecurity.csrf(csrf->csrf.disable())
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(request->request.requestMatchers("/api/auth/register",
                        "/api/auth/login").permitAll().anyRequest().authenticated())
                .exceptionHandling(exception->exception.authenticationEntryPoint(entryException))
                .addFilterBefore(filterJwtRequest, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
