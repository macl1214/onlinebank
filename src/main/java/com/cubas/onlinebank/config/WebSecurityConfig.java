package com.cubas.onlinebank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/** 
 * Guide on setting up Spring Security:
 * https://spring.io/guides/gs/securing-web/  
 * 
 * 
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/home").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.and()
			.logout()
				.permitAll();
		
	}

	@Bean
	@Override
	protected UserDetailsService userDetailsService() {

		UserDetails user = 
				User.withDefaultPasswordEncoder()
					.username("mac1419")
					.password("password")
					.roles("USER")
					.build();
		
		return new InMemoryUserDetailsManager(user);
	}

	
}
