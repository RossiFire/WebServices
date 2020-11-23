package com.rentalcar.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.rentalcar.config" })
@PropertySource(value = { "classpath:application.properties"})
public class JdbcConfig {
	@Autowired
	private Environment environment;
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource)
	{
		return new JdbcTemplate(dataSource);
	}
	
	@Bean 
	public NamedParameterJdbcTemplate getJdbcTemplate(DataSource dataSource) 
	{ 
	    return new NamedParameterJdbcTemplate(dataSource); 
	} 
	
	@Bean(name = "dataSource")
	public DataSource dataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName(environment.getRequiredProperty("spring.datasource.driver-class-name"));
		dataSource.setUrl(environment.getRequiredProperty("spring.datasource.url"));
		dataSource.setUsername(environment.getRequiredProperty("spring.datasource.username"));
		dataSource.setPassword(environment.getRequiredProperty("spring.datasource.password"));
		
		return dataSource;
	}
	
}
