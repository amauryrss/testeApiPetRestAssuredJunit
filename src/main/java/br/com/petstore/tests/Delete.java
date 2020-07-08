package br.com.petstore.tests;

import static io.restassured.RestAssured.given;


import org.junit.Test;



public class Delete {
	

	@Test
	public void deveDeletarPetComSucesso() {
		given()
		
		.when()
			.delete("pet/6667")
		.then()
		.statusCode(200)
		;
		
	}
	
	@Test
	public void deveDeletarUserComSucesso() {
		given()
		
		.when()
			.delete("user/Usuario1")
		.then()
		.statusCode(200)
		;
		
	}
	
	@Test
	public void deveDeletarOrderComSucesso() {
		given()
		
		.when()
			.delete("/store/order/12345")
		.then()
		.statusCode(200)
		;
		
	}
}
