package crudOperation_withoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProjectTest 
{
	
	@Test	
	public void deleteProjectTest() 
	{

		/*
		 * ==========================get all project details===================================
		 * ==========================DELETE--->/project/{projectId}============================
		 */
		
		Response resp = RestAssured.delete("http://49.249.28.218:8091/project/NH_PROJ_12822");
		
		//validate the status code
		resp.then().assertThat().statusCode(204);
		
		//get all the logs and print in console
		resp.then().log().all();
		
	}

}
