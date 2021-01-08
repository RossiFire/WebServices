package com.rentalcar.webapp.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MyErrorController implements ErrorController {

	@Override
	public String getErrorPath() {
		return null;
	}
	
	@RequestMapping("/error")
	public String HandleHerror() {
		return "errorPage";
	}

}
