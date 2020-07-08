package br.com.petstore.tests;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import io.restassured.RestAssured;

@RunWith(org.junit.runners.Suite.class)
@SuiteClasses({
	Create.class,
	Read.class,
	Update.class,
	Delete.class
})
public class Suite {
	@BeforeClass
	public static void SetupUrl() {
		 String APP_BASE_URL = "https://petstore.swagger.io/v2";
		 String APP_BASE_PATH = "";
				
		
		RestAssured.baseURI = APP_BASE_URL;
		RestAssured.basePath = APP_BASE_PATH;
		  
	}

}
