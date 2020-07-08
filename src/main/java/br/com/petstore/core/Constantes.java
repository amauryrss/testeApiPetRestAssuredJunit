package br.com.petstore.core;

import io.restassured.http.ContentType;

public interface Constantes {
	
	String APP_BASE_URL = "http://petstore.swagger.io/";
	Integer APP_PORT = 80;
	String APP_BASE_PATH = "";
	
	ContentType APP_CONTENT_TYPE = ContentType.JSON;
	
	Long MAX_TIMEOUT = 8000L;
	

}
