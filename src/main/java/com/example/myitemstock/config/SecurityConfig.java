package com.example.myitemstock.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(HttpSecurity security) throws Exception {
        security.csrf().disable();
        security.headers().frameOptions().sameOrigin();

        security.httpBasic().disable();

        security.authorizeRequests().anyRequest().permitAll();
    }
}
