package com.rentalcar.webapp;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.rentalcar.webapp.Application;

@SpringBootTest()
@ContextConfiguration(classes = Application.class)
public class TestRestController 
{

	private MockMvc mvc;
	 
	@Autowired
	private WebApplicationContext wac;
	
	@BeforeEach
	public void setup(){
		mvc = MockMvcBuilders
				.webAppContextSetup(wac)
				.build();	
	}
	 
	
	 @Test
	 public void testGreetingsController()
			  throws Exception 
	  {
		 mvc.perform(get("/api/test")
				.contentType(MediaType.APPLICATION_JSON))
		 		.andExpect(status().isOk())
		 		.andExpect(jsonPath("$")
		 				.value("Saluti, sono il tuo primo web services"))
		 		.andDo(print());
	  }
	 
	 
	 @Test
	 public void testGreetingsController2()
			  throws Exception 
	  {
		 mvc.perform(get("/api/test/Dani")
				.contentType(MediaType.APPLICATION_JSON))
		 		.andExpect(status().isOk())
		 		.andExpect(jsonPath("$")
		 				.value("Utentr sta usando sto web service"))
		 		.andDo(print());
	  }
	 
	 
}
