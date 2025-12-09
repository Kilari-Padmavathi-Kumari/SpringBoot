package com.newproject.springboot_project.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class DemoSecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager()
    {
        UserDetails padma= User.builder()
                .username("padma")
                .password("{noop}padma@123")
    .roles("Teacher")
    .build();

        UserDetails kavya= User.builder()
                .username("kavya")
                .password("{noop}kavya@123")
                .roles("Teacher","MANAGER")
                .build();

        UserDetails vedha= User.builder()
                .username("vedha")
                .password("{noop}vedha@123")
                .roles("Teacher","manager","admin")
                .build();

        return new InMemoryUserDetailsManager(padma,kavya,vedha);
    }
}
