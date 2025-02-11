package crudOperation_withBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeleteProjectTest 
{
	
	@Test	
	public void deleteProjectTest() 
	{

		/*
		 * ==========================get all project details===================================
		 * ==========================DELETE--->/project/{projectId}============================
		 */
		
		//projectID----> NH_PROJ_12817  we get after creation of project
		when()
		      .delete("http://49.249.28.218:8091/project/NH_PROJ_12856")
		
		//validate the status code
		.then()
		       .assertThat().statusCode(204)
		
		//get all the logs and print in console
	    .log().all();
	 	
	}

}
