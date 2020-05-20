package com.ada.restapi.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ada.restapi.form.LoginForm;

public class UsuarioController {

	
	@PutMapping(path = "/mail")
	public @ResponseBody String modificarPass(@RequestBody LoginForm loginForm) {

		String modificada = "pass modificada";

		return modificada;
	}
	
	@DeleteMapping(path = "/{user}")
	public @ResponseBody String delete(@RequestParam int id, @PathVariable String user) {

		String delete = "usuario borrado";

		return delete;

	}
}
