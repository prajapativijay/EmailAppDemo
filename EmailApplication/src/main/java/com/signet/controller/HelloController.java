package com.signet.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * Hello controller which shows envrionment details based on property value in application.property
 *
 */

@RestController
public class HelloController {

	@Value("${email.application.environment}")
	private String environment;
	
    @RequestMapping("/hello")
    public String hello() {
    	return "Hello " + environment;
    }

}

