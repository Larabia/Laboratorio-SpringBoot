package com.ada.restapi;

import static org.junit.Assert.assertTrue;
import java.io.IOException;
import java.util.Collections;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.ada.restapi.model.Producto;
public class TestProductoV2{

	private static RestTemplate restTemplate;
	private static String productosURL = "http://localhost:8082/v1/productos";

	@BeforeClass
	public static void runBeforeAllTestMethods() {
		restTemplate = new RestTemplate();
	}

	@Test
	public void testGetMethod() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		// set `content-type` header
		headers.setContentType(MediaType.APPLICATION_JSON);
		// set `accept` header
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
		ResponseEntity<Producto[]> responseEntity = restTemplate.getForEntity(productosURL,  Producto[].class);
		Producto[] objects = responseEntity.getBody();
		MediaType contentType = responseEntity.getHeaders().getContentType();
		HttpStatus statusCode = responseEntity.getStatusCode();
		System.out.println(statusCode);
		System.out.println(objects);
		System.out.println(contentType);
		assertTrue(objects.length > 0);
	}
	
	@Test
	public void testGetById() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		// set `content-type` header
		headers.setContentType(MediaType.APPLICATION_JSON);
		// set `accept` header
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
		ResponseEntity<Producto[]> responseEntity = restTemplate.getForEntity(productosURL + "/" + 1,  Producto[].class);
		Producto[] objects = responseEntity.getBody();
		MediaType contentType = responseEntity.getHeaders().getContentType();
		HttpStatus statusCode = responseEntity.getStatusCode();
		System.out.println(statusCode);
		System.out.println(objects);
		System.out.println(contentType);
		assertTrue(objects.length > 0);
	}
	
	@Test
	public void testGetByNombre() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		// set `content-type` header
		headers.setContentType(MediaType.APPLICATION_JSON);
		// set `accept` header
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
		ResponseEntity<Producto[]> responseEntity = restTemplate.getForEntity(productosURL + "/notebook",  Producto[].class);
		Producto[] objects = responseEntity.getBody();
		MediaType contentType = responseEntity.getHeaders().getContentType();
		HttpStatus statusCode = responseEntity.getStatusCode();
		System.out.println(statusCode);
		System.out.println(objects);
		System.out.println(contentType);
		assertTrue(objects.length > 0);
	}

	@Test
	public void testPost() {
		Producto prod = new Producto("Auricular", 88);
		

		ResponseEntity<Producto> result = restTemplate.postForEntity(productosURL, prod, Producto.class);
		System.out.println(result.getBody());
		Producto ptest = result.getBody();
		System.out.println(ptest.getNombre());
		System.out.println(result.getStatusCodeValue());
	}

}















