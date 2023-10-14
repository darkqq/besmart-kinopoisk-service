package com.besmartkinopoiskservice.security;

import com.besmartkinopoiskservice.enumeration.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http
                .csrf(csrf -> csrf.disable())
                .authorizeRequests(auth -> auth
                        .requestMatchers(new AntPathRequestMatcher("/auth/*")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/resource/**")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/user/**")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/movie/**")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/movie/add")).hasAuthority(Role.ADMIN.toString())
                        .requestMatchers(new AntPathRequestMatcher("/movie/update/*")).hasAuthority(Role.ADMIN.toString())
                        .anyRequest().authenticated())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
