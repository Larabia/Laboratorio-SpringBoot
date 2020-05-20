package com.ada.restapi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class TestProducto {

@Test
public void shouldReturnStatusOkay() throws UnirestException {
    HttpResponse<JsonNode> jsonResponse 
      = Unirest.get("http://localhost:8080/v1/welcome/Ada?aleatorio=111111111")
      .header("accept", "application/json").queryString("apiKey", "123")
      .asJson();
 
    assertNotNull(jsonResponse.getBody());
    assertEquals(200, jsonResponse.getStatus());
}
	

}
