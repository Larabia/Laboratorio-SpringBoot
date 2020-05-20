package com.ada.restapi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ada.restapi.form.LoginForm;
import com.ada.restapi.model.Producto;

@Controller
@RequestMapping(path="/v2") 
public class LoginController {
	
	@PostMapping (path = "/login")
	public @ResponseBody int getClave(@RequestBody LoginForm loginForm) {
		Random r = new Random();
		int token = r.nextInt(999999999)+1; 	
		
		return token;
	}
	
	@GetMapping(path = "/welcome/{user}")
	public @ResponseBody List<Producto> welcome(@RequestParam int token, @PathVariable String user) {

		List<Producto> prodList = new ArrayList<Producto>();

		Producto prod1 = new Producto("Nokia 1100", 100);
		Producto prod2 = new Producto("Motorola", 200);
		Producto prod3 = new Producto("Samsung", 300);

		prodList.add(prod1);
		prodList.add(prod2);
		prodList.add(prod3);

		return prodList;

	}

	

}
