package br.com.petstore.tests;



import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


import org.junit.Test;






public class Read  {
		
		
	
	@Test
	public void buscarPetPorStatus() {
		given()
			
			.queryParam("status", "available")
		.when()
			.get("/pet/findByStatus")
		.then()
		.statusCode(200)
		.log().all()
		;
	}
	
	@Test
	public void buscarPetPorId() {
		given()
						
		.when()
			.get("/pet/6667")
		.then()
		.statusCode(200)
		.log().all()
		.body("id", equalTo(6667),
				"category.name", is("Felino"),
				"name", is("bichano"),
				"photoUrls", hasItem("http://fotodegato/gato1.png"),
				"tags.id", hasItem(55555),
				"tags.name", hasItem("Marrom"))
		
		
		;
	}
	
	@Test
	public void buscarOrderPorId() {
		given()
			
			
		.when()
			.get("/store/order/12345")
		.then()
		.statusCode(200)
		.log().all()
		.body("id", equalTo(12345),
				"petId", equalTo(6667),
				"quantity", equalTo(1),
				"shipDate", is(notNullValue()),
				"status", equalTo("placed"),
				"complete", is(true))
		
		;
	}
	
	@Test
	public void buscarInventory() {
		given()
						
		.when()
			.get("/store/inventory")
		.then()
		.statusCode(200)
		.log().all()
		.body("sold", is(1))
		.body("string", is(89))
		//.body("Nonavailable", is(1))
		//.body("pending", is(44))
		.body("available", is(897))
			
		;
	}
	
	@Test
	public void buscarUserPorId() {
		given()
						
		.when()
			.get("/user/Usuario1")
		.then()
		.statusCode(200)
		.log().all()
		.body("id", equalTo(2222),
				"username", equalTo("Usuario1"),
				"firstName", equalTo("Jose"),
				"lastName", equalTo("Silva"),
				"email", equalTo("jose.silva@bol.com.br"),
				"password", equalTo("senha123456"),
				"phone", equalTo("(11)98552-0904"),
				"userStatus", is(10))
	;
	}
	
	@Test
	public void buscarUserLogin() {
		given()
			.queryParam("username", "Usuario1")
			.queryParam("senha123456")			
		.when()
			.get("/user/login")
		.then()
		.statusCode(200)
		.log().all()
		.body("code", is(200))
		.body("type", is("unknown"))
		//.body("message", is("logged in user session:1593353568724")) COMO VALIDAR ESSA SESSION QUE É DINAMICA???
		
					
		;
	}
	
	@Test
	public void buscarLogout() {
		given()
					
		.when()
			.get("/user/logout")
		.then()
		.statusCode(200)
		.log().all()
		.body("code", is(200))
		.body("type", is("unknown"))
		.body("message", is("ok"))
		
					
		;
	}

}
