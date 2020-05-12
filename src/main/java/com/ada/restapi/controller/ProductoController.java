package com.ada.restapi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ada.restapi.form.LoginForm;
import com.ada.restapi.model.Producto;
import com.ada.restapi.repository.ProductoRepository;

@Controller
@RequestMapping(path="/v1") 
public class ProductoController {
	
	@Autowired
	private ProductoRepository prodRepo;

	/*@GetMapping(path="/test")
	public @ResponseBody String getDate(@RequestParam String nombre) {
		Date date = new Date();
		return "Hola " + nombre + "Fecha: " + date;
	}

	@GetMapping(path = "/login")
	public @ResponseBody String login(@RequestParam String usuario, @RequestParam String contrasena) {

		return "Hola " + usuario + " Fecha: " + new Date();
	}

	@GetMapping(path = "/login/{name}/{age}")
	public @ResponseBody String getMessage(@PathVariable("name") String name, @PathVariable("age") String age) {

		String msg = String.format("%s is %s years old", name, age);

		return msg;
	}

	/*@PostMapping (path = "/login")
	public @ResponseBody String loginUser(@RequestBody LoginForm loginForm) {
		
		return "El usuario es " + loginForm.getUser();
	}*/
	
	@PostMapping (path = "/login")
	public @ResponseBody int getClave(@RequestBody LoginForm loginForm) {
		Random r = new Random();
		int token = r.nextInt(999999999)+1; 	
		
		return token;
	}
	
	
	@GetMapping (path = "/welcome/{user}")
	public @ResponseBody List<Producto> welcome (@RequestParam int token, @PathVariable String user) {
		
		List<Producto> prodList = new ArrayList<Producto>();
		
		Producto prod1 = new Producto(1, "Nokia 1100", 100);
		Producto prod2 = new Producto(2, "Motorola", 200);
		Producto prod3 = new Producto(3, "Samsung", 300);
		
		prodList.add(prod1);
		prodList.add(prod2);
		prodList.add(prod3);
		
		
		return prodList;

	}
	
	@DeleteMapping (path = "/{user}")
	public @ResponseBody String delete (@RequestParam int id, @PathVariable String user) {
		
		
		
		String delete = "usuario borrado";
		
		
		return delete;

	}
	
	@PutMapping (path = "/mail")
	public @ResponseBody String modificarPass(@RequestBody LoginForm loginForm) {
		
		String modificada = "pass modificada";
		
		return modificada;
	}
	
	@PostMapping (path = "/producto")
	public @ResponseBody String altaProducto(@RequestBody Producto producto) {
		
		System.out.println("producto guardado");
		
		prodRepo.save(producto);
		return "Guardado";
		
		
	}
	
	

}
