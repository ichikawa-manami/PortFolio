package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;

import com.example.demo.UserDetailsAuthenticationProvider;

@Configuration
public class MyConfig {
	
    // 今作成したCustomAbstractUserDetailsAuthenticationProviderをBean登録する。
	@Bean
	public AuthenticationProvider getAuthenticationProvider() {
		return new UserDetailsAuthenticationProvider();
	}
	
	
}
