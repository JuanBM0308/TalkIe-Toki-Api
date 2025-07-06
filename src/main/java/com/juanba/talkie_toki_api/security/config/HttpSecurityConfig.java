package com.juanba.talkie_toki_api.security.config;

import com.juanba.talkie_toki_api.security.config.filter.JwtAuthenticationFilter;
import com.juanba.talkie_toki_api.util.JwtService;
import com.juanba.talkie_toki_api.util.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class HttpSecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public HttpSecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(http -> {
                    // ! Public endpoints
                    http.requestMatchers(HttpMethod.POST, "/api/v1/authenticate").permitAll();

                    // ! User endpoints
                    http.requestMatchers(HttpMethod.POST, "/api/v1/users").permitAll();
                    http.requestMatchers(HttpMethod.GET, "/api/v1/users/{id}").hasAnyRole(Role.ADMINISTRATOR.name(), Role.HELP_DESK.name());
                    http.requestMatchers(HttpMethod.GET, "/api/v1/users").hasAnyRole(Role.ADMINISTRATOR.name(), Role.HELP_DESK.name());
                    http.requestMatchers(HttpMethod.DELETE, "/api/v1/users/{id}").hasAnyRole(Role.ADMINISTRATOR.name(), Role.HELP_DESK.name());
                    http.requestMatchers(HttpMethod.PUT, "/api/v1/users").hasAnyRole(Role.ADMINISTRATOR.name(), Role.HELP_DESK.name(), Role.NORMAL_USER.name());

                    // ! Comment endpoint
                    http.requestMatchers(HttpMethod.POST, "/api/v1/comments").hasAnyRole(Role.ADMINISTRATOR.name(), Role.NORMAL_USER.name());
                    http.requestMatchers(HttpMethod.GET, "/api/v1/comments/{id}").hasAnyRole(Role.ADMINISTRATOR.name(), Role.HELP_DESK.name(), Role.NORMAL_USER.name());
                    http.requestMatchers(HttpMethod.GET, "/api/v1/comments").hasAnyRole(Role.ADMINISTRATOR.name(), Role.HELP_DESK.name(), Role.NORMAL_USER.name());
                    http.requestMatchers(HttpMethod.DELETE, "/api/v1/comments/{id}").hasAnyRole(Role.ADMINISTRATOR.name(), Role.HELP_DESK.name(), Role.NORMAL_USER.name());
                    http.requestMatchers(HttpMethod.PUT, "/api/v1/comments/{id}").hasAnyRole(Role.ADMINISTRATOR.name(), Role.HELP_DESK.name(), Role.NORMAL_USER.name());

                    http.anyRequest().authenticated();
                })
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
