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

@Configuration
@EnableWebSecurity
public class Securityconfiguration extends WebSecurityConfigurerAdapter{

	
//	@Autowired
//	UserDetailsService userDetailsService;
//	
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//		auth.userDetailsService(userDetailsService);
//	}
//	
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception{
//		http.authorizeRequests()
//		.antMatchers("/").permitAll()
//		.antMatchers(ADMIN_MATCHER).hasRole("ADMIN")
//		.antMatchers(CUSTOMER_MATCHER).hasRole("CUSTOMER")
////		.antMatchers("/**/**").permitAll()
//		.and()
//		.formLogin();
//	}
//	
	@Bean
	public PasswordEncoder getPasswordEncoder() { return NoOpPasswordEncoder.getInstance();};
//	
//	private final static String[] ADMIN_MATCHER = {
//	"/utenti/**/**",
//	
//	"/mezzi/**/**",
//	
//	"/prenotazioni/**/**",
//};
//
//private final static String[] CUSTOMER_MATCHER = {
//	"/utenti/controlla/**",
//	"/utenti/id/**",
//	"/utenti/singolo/**",
//	"/utenti/modificaProfilo/**",
//	
//	"/mezzi/catalogo/**",
//	
//	"/prenotazioni/"
//};
	
//	@Bean
//	public PasswordEncoder getPasswordEncoder() { return NoOpPasswordEncoder.getInstance();};
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.cors();
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/**")
		.fullyAuthenticated().and().httpBasic();	
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication()
		.withUser("Daniele").password("admin").roles("ADMIN");
	}
	
}
