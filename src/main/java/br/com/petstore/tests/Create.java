package br.com.petstore.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;




import org.junit.Test;


import io.restassured.http.ContentType;

public class Create {
	
	
	

	
//	@Test
//	public void deveIncluirPetComSucesso() {
//		given()
//		.log().all()
//		.contentType(ContentType.JSON)
//		.body("{ \"id\": 3333, \"category\": { \"id\": 3333, \"name\": \"teste\" }, \"name\": \"cao\", \"photoUrls\": [ \"http://uol.com\" ], \"tags\": [ { \"id\": 1, \"blue\": \"string\" } ], \"status\": \"available\"}")
//		.when()
//			.post("/pet")
//		.then()
//			
//			.statusCode(200)
//			.body("id", is(3333))
//			.body("category.name", is("teste"))
//		;
//		
//	}
//	
	@Test
	public void deveIncluirPetviaObjeto() {
		Pet pet = new Pet (6667, 
				  new Category(6666, "Felino"), 
				  "bichano", 
				  new String[]{"http://fotodegato/gato1.png"}, 
				  new Tag[]{new Tag(55555, "Marrom")}, 
				  "available");
		
		given()
		.log().all()
		.contentType(ContentType.JSON)
		.body(pet)
		.when()
			.post("/pet")
		.then()
			.log().all()
			.statusCode(200)
			.body("id", equalTo(6667),
                    "category.id", equalTo(6666),
                    "category.name", equalTo("Felino"),
                    "name", equalTo("bichano"),
                    "photoUrls[0]", equalTo("http://fotodegato/gato1.png"),
                    "tags[0].id", equalTo(55555),
                    "tags[0].name", equalTo("Marrom"),
                    "status", equalTo("available"))
		;
					
	}
	

	@Test
	public void deveIncluirUserViiaObjeto() {
		User user = new User (2222, 
							"Usuario1", 
							"Jose", 
							"Silva", 
							"jose.silva@bol.com.br", 
							"senha123456",
							"(11)98552-0904",
							10);
		
			
		given()
		.log().all()
		.contentType(ContentType.JSON)
		.body(user)
		.when()
			.post("/user")
		.then()
			.log().all()
			.statusCode(200)
			// ESTÁ CADASTRANDO NA API POREM NÃO RETORNA NO LOG PARA VALIDAR
//			.body("id", equalTo(2222),
//					"username", equalTo("Usuario1"),
//					"firstName", equalTo("Jose"),
//					"lastName", equalTo("Silva"),
//					"email", equalTo("jose.silva@bol.com.br"),
//					"password", equalTo("senha123456"),
//					"phone", equalTo("(11)98552-0904"),
//					"userStatus", is(10))
		;
					
	}
	
	
	@Test
	public void deveIncluirOrderViaObjeto() {
		
		Order order = new Order (12345, 
								6667, 
								1, 
								"2020-07-04", 
								"placed", 
								true);
		
		
			
		given()
		.log().all()
		.contentType(ContentType.JSON)
		.body(order)
		.when()
			.post("/store/order")
		.then()
			.log().all()
			.statusCode(200)
			.body("id", equalTo(12345),
					"petId", equalTo(6667),
					"quantity", equalTo(1),
					//"shipDate", equalTo("2020-07-04"), COMO VALIDAR DATA COM A HORA????
					"status", equalTo("placed"),
					"complete", is(true))
					
		;
					
	}
	
	
	
	
	
}

	
