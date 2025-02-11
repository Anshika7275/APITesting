package crudOperation_withoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllProjectsTest 
{
	
	@Test
	public void getAllProjectTest() 
	{
		
		/*
		 * =============================get all project details========================
		 * =============================GET--->/projects===============================
		 */
		
		Response resp = RestAssured.get("http://49.249.28.218:8091/projects");
		System.out.println(resp.prettyPrint());
		
		//validate the status code
		resp.then().assertThat().statusCode(200);
		
		//get all the logs and print in console
		resp.then().log().all();
		
	}
}
