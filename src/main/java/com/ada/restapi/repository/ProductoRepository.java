package com.ada.restapi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ada.restapi.model.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Integer> {

	public List<Producto> findByNombreStartingWith(String nombre);
	
	

}
