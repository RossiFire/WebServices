package com.rentalcar.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
@EnableWebSecurity
@CrossOrigin(origins="http://localhost:4200")
public class Securityconfiguration extends WebSecurityConfigurerAdapter{
	
//	@Autowired
//	CustomUserDetailsService userDetails;
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		http.cors();
		http.csrf().disable()
		.authorizeRequests()
	//	.and()
	//	.antMatchers(HttpMethod.OPTIONS, "/**")
		.antMatchers("/**")
		.permitAll();
//		.anyRequest()
//		.fullyAuthenticated().and().httpBasic();	
	}
	
//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception{
//		auth.inMemoryAuthentication()
//		.withUser("Daniele").password("admin").roles("ADMIN");
//	}
	
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
//		auth.inMemoryAuthentication()
//		.withUser("Daniele").password("{noop}admin").roles("ADMIN");
//	}
//	
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	
//	@Bean
//	public PasswordEncoder getPasswordEncoder() { return NoOpPasswordEncoder.getInstance();};
	
}
