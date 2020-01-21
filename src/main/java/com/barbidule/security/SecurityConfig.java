package com.barbidule.security;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests() // Define access control
                .antMatchers("/admin/**").hasRole("ADMIN") // L'url "/admin" et les urls suivantes ont besoin de la connection "ADMIN"
                .anyRequest().permitAll() // Acces sans authentication sur le reste du site
                .and()
                .formLogin() // Login par défaut avec le formulaire embarqué.
        ;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser("barbidule")
                .password(encoder.encode("barbidule"))
                .roles("ADMIN");
    }
}
