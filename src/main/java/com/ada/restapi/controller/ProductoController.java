package com.ada.restapi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.google.common.collect.Lists;
import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Controller
@RequestMapping(path = "/v1")
public class ProductoController {

	@Autowired
	private ProductoRepository prodRepo;

	Logger log = Logger.getLogger(ProductoController.class.getName());

	// POST

	@PostMapping(path = "/producto/alta")
	public ResponseEntity<Producto> altaProducto(@RequestBody Producto producto) {
				
		log.info("metodo: altaProducto.");
		prodRepo.save(producto);
		log.info("metodo: Producto guardado.");

		return new ResponseEntity<>(producto, HttpStatus.CREATED);

	}


	// PUT

	@PutMapping(path = "/producto/modificar/nombre")
	public ResponseEntity<Producto> modificarNombre(@RequestBody Producto producto, @RequestParam String newNombre) {

		log.info("metodo: modificarNombre.");
		producto.setNombre(newNombre);
		prodRepo.save(producto);

		return new ResponseEntity<>(producto, HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/producto/modificar/precio")
	public ResponseEntity<Producto> modificarPrecio(@RequestBody Producto producto, @RequestParam double newPrecio) {

		log.info("metodo: modificarPrecio.");
		producto.setPrecio(newPrecio);
		prodRepo.save(producto);

		return new ResponseEntity<>(producto, HttpStatus.CREATED);
	}


	// DELETE
	
	@DeleteMapping(path = "/producto/{nombre}")
	public ResponseEntity<String> deleteById(@RequestParam int id, @PathVariable String nombre) {
	
		log.info("Borrando Producto id :" + id);
		java.util.Optional<Producto> produ = prodRepo.findById(id);
		
		if (produ.isPresent()) {
			prodRepo.deleteById(id);
			return new ResponseEntity<>("Producto borrado.", HttpStatus.OK);
		}
		else {
			log.info("Producto id: " + id + " no encontrado");
			return new ResponseEntity<>("Producto no encontrado.", HttpStatus.BAD_REQUEST);
		}

	}

	
	// GET
	
	@GetMapping(path = "/productos")
	public ResponseEntity<List<Producto>> listadoProducto() {
		log.info("comienzo invocacion listar productos...");
		Iterable<Producto> lp = prodRepo.findAll();
		List<Producto> result = Lists.newArrayList(lp);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	
	@GetMapping(path = "/productos/{id}")
	public ResponseEntity<Producto> getProductoById(@PathVariable("id") Integer id) {
		log.info("metodo: getProducto" + id);
		java.util.Optional<Producto> produ = prodRepo.findById(id);
		Producto produRespuesta = produ.get();
		if (java.util.Optional.empty().equals(produ)) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(produRespuesta, HttpStatus.OK);
		}
	}

	
	@GetMapping(path = "/productos/nombre")
	public ResponseEntity<List<Producto>> getProductoByNombre(@RequestParam String nombre) {
		log.info("metodo: getProdByNom" + nombre);

		List<Producto> productosByNombre = prodRepo.findByNombreStartingWith(nombre);
		return new ResponseEntity<>(productosByNombre, HttpStatus.OK);
	}

}
