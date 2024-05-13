package com.example.demo;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



@Configuration
@EnableMethodSecurity
public class WebSecurityConfig {
  @Autowired
  private DataSource dataSource;
  
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.csrf().disable();
    http.authorizeHttpRequests(authorize -> {
      authorize.anyRequest().permitAll();
    });
    http.formLogin(form -> {
      form.defaultSuccessUrl("/user/top")
      .loginPage("/user/login");
    });
    return http.build();
  }
  
  

  @Bean
  public UserDetailsManager userDetailsManager(){
    return new JdbcUserDetailsManager(this.dataSource);
  }
  
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();}
	    
	

	  protected void configure(HttpSecurity http) throws Exception {
	    http
	      .authorizeRequests().antMatchers("/login", "/register").permitAll().anyRequest().authenticated()
	      .and()
	      .formLogin().loginPage("/login").defaultSuccessUrl("/")
	      .usernameParameter("email")  //usernameの値を"email"から取得するよう設定する
	      .passwordParameter("password")
	      .and()
	      .rememberMe();
	  }
		

	  protected void configure(AuthenticationManagerBuilder auth) throws Exception{
	    auth  //ユーザの設定
	      //userDetailsServiceで、DBからユーザーを参照できるようにする
	      .PortFolioService(portFolioService)
	      .passwordEncoder(passwordEncoder());
	  }
}