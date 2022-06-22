package com.cubas.onlinebank.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/** 
 * Guide on setting up Spring Security:
 * https://spring.io/guides/gs/securing-web/  
 * 
 * 
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth
			.userDetailsService(userDetailsService)
			.passwordEncoder(passwordEncoder());
	}

	/**
	 * HttpSecurity Docs:
	 * https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/config/annotation/web/builders/HttpSecurity.html
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/home").permitAll()
				.antMatchers("/aboutUs").permitAll()
				.antMatchers("/register").permitAll()
				.antMatchers("/samplePortal").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.and()
			.logout()
				.logoutSuccessUrl("/")
				.permitAll();
		
	}

	/**
	 * WebScurity Docs:
	 * https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/config/annotation/web/builders/WebSecurity.html
	 */
	@Override
	public void configure(WebSecurity web) throws Exception {
	
		web
				.ignoring()
					.antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/assets/**");
	}
}
