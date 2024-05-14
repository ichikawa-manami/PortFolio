package com.example.demo.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	
        http.formLogin(login -> login
                .loginProcessingUrl("/user/login?now")
                .loginPage("/user/login")
                .defaultSuccessUrl("/user/top",true)
                .failureUrl("/user/login?error")
                .permitAll()
				.usernameParameter("name")
				.passwordParameter("password")
        ).logout(logout -> logout
        		.logoutUrl("/user/logout") 
                .logoutSuccessUrl("/user/login")
        ).authorizeHttpRequests(authz -> authz
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .requestMatchers("/user/signin","/user/login","/user/top").permitAll()
                .requestMatchers("/css/**").permitAll()
                .anyRequest().authenticated()
        );
        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}

