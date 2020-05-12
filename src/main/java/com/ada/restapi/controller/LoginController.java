package com.ada.restapi.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ada.restapi.form.LoginForm;

@Controller
@RequestMapping(path="/v2") 
public class LoginController {
	
	@PostMapping (path = "/login")
	public @ResponseBody int getClave(@RequestBody LoginForm loginForm) {
		Random r = new Random();
		int token = r.nextInt(999999999)+1; 	
		
		return token;
	}
	
	

}
