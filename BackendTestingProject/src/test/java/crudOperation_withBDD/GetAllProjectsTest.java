package crudOperation_withBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetAllProjectsTest 
{
	
	@Test
	public void getAllProjectTest() 
	{
		
		/*
		 * =============================get all project details========================
		 * =============================GET--->/projects===============================
		 */
		
		//enter all pre-conditions
		given()
		      .get("http://49.249.28.218:8091/projects")
		
		//for validation
		.then()
		       .assertThat().statusCode(200)
		
		//for getting all the details over console
		.log().all();
		
		
	}
}
