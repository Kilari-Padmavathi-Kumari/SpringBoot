package com.newproject.springboot_project.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails padma = User.builder()
                .username("padma")
                .password("{noop}padma@123")
                .roles("TEACHER")
                .build();

        UserDetails kavya = User.builder()
                .username("kavya")
                .password("{noop}kavya@123")
                .roles("TEACHER", "MANAGER")
                .build();

        UserDetails vedha = User.builder()
                .username("vedha")
                .password("{noop}vedha@123")
                .roles("TEACHER", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(padma, kavya, vedha);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable());

        http.authorizeHttpRequests(auth -> auth
                .requestMatchers(HttpMethod.GET, "/api/teacher/**").hasRole("TEACHER")
                .requestMatchers(HttpMethod.POST, "/api/teacher").hasRole("MANAGER")
                .requestMatchers(HttpMethod.PUT, "/api/teacher").hasRole("MANAGER")
                .requestMatchers(HttpMethod.DELETE, "/api/teacher/**").hasRole("ADMIN")
                .anyRequest().authenticated()
        );

        http.httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
