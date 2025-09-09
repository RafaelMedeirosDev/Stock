package com.estudos.stock.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
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
public class SecurityConfigurations {

    @Autowired
    private SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                    .requestMatchers(HttpMethod.POST, "/auth/log").permitAll()
                    .requestMatchers(HttpMethod.POST, "/products").hasAnyAuthority("ROLE_MANAGER")
                    .requestMatchers(HttpMethod.GET, "/products").hasAnyAuthority("ROLE_MANAGER", "ROLE_ATTENDANT")
                    .requestMatchers(HttpMethod.POST, "/employees").hasAnyAuthority("ROLE_MANAGER")
                    .requestMatchers(HttpMethod.GET, "/employees").hasAnyAuthority("ROLE_MANAGER", "ROLE_ATTENDANT")
                    .requestMatchers(HttpMethod.POST, "/movement").hasAnyAuthority("ROLE_MANAGER", "ROLE_ATTENDANT")
                    .requestMatchers(HttpMethod.GET, "/movement").hasAnyAuthority("ROLE_ANAGER", "ROLE_ATTENDANT")
                    .anyRequest().authenticated()
                    )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)  throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
