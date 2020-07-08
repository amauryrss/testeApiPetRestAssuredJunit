package br.com.petstore.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


import org.junit.Test;


import io.restassured.http.ContentType;

public class Update {
	
	
	
	@Test
	public void deveAtualizarPetComSucesso() {
		
			Pet pet = new Pet (6667, 
					  new Category(6666, "Felino Atualizado"), 
					  "bichano Atualizado", 
					  new String[]{"http://fotodegato/atualizado/gato1.png"}, 
					  new Tag[]{new Tag(55555, "Marrom Atualizado")}, 
					  "available");
			
			given()
			.log().all()
			.contentType(ContentType.JSON)
			.body(pet)
			.when()
				.put("/pet")
			.then()
				.log().all()
				.statusCode(200)
				.body("id", equalTo(6667),
	                    "category.id", equalTo(6666),
	                    "category.name", equalTo("Felino Atualizado"),
	                    "name", equalTo("bichano Atualizado"),
	                    "photoUrls[0]", equalTo("http://fotodegato/atualizado/gato1.png"),
	                    "tags[0].id", equalTo(55555),
	                    "tags[0].name", equalTo("Marrom Atualizado"),
	                    "status", equalTo("available"))
			;

}
	
	@Test
	public void deveAtualizarUserViiaObjeto() {
		User user = new User (2222, 
							"Usuario1", 
							"Jose_Atualizado", 
							"Silva_Atualizado", 
							"jose.silva@bol.com.br_Atualizado", 
							"senha123456_Atualizado",
							"(11)98552-0904_Atualizado",
							10);
		
			
		given()
		.log().all()
		.contentType(ContentType.JSON)
		.body(user)
		.when()
			.put("/user/Usuario1")
		.then()
			.log().all()
			.statusCode(200)
			// só traz o cod 200 no response body da api
//			.body("id", equalTo(2222),
//					"username", equalTo("Usuario1_Atualizado"),
//					"firstName", equalTo("Jose_Atualizado"),
//					"lastName", equalTo("Silva_Atualizado"),
//					"email", equalTo("jose.silva@bol.com.br_Atualizado"),
//					"password", equalTo("senha123456_Atualizado"),
//					"phone", equalTo("(11)98552-0904_Atualizado"),
//					"userStatus", is(10))
		;
					
	}
	// NÃO TEM O METODO PUT EM PETSTORE ORDERS
//	@Test
//	public void deveAtualizarOrderViaObjeto() {
//		
//		Order order = new Order (12345, 
//								6667, 
//								100, 
//								"2020-07-04", 
//								"placed", 
//								true);
//		
//		
//			
//		given()
//		.log().all()
//		.contentType(ContentType.JSON)
//		.body(order)
//		.when()
//			.post("/store/order/12345")
//		.then()
//			.log().all()
//			.statusCode(200)
//			.body("id", equalTo(12345),
//					"petId", equalTo(6667),
//					"quantity", equalTo(1),
//					//"shipDate", equalTo("2020-07-04"), COMO VALIDAR DATA COM A HORA????
//					"status", equalTo("placed"),
//					"complete", is(true))
//					
//		;
//					
//	}
}
