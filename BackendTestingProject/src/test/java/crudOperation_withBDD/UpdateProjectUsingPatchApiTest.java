package crudOperation_withBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class UpdateProjectUsingPatchApiTest 
{
	
	@Test
	public void updatePartialProjectTest()
	{
		
		/*
		 * ================================Update complete project=====================================
		 * ================================PATCH--->/project/{projectId}===============================
		 */

		//get JSON object for body
		JSONObject jsonObj = new JSONObject();
		
		//get all key and values
		jsonObj.put("status", "Completed");
		
		//add all pre-conditions required to create project  
		given()
		       .contentType(ContentType.JSON)
		
		//get request body from jsonObject and convert it into json string format
		       .body(jsonObj.toJSONString())
		
		//projectID----> NH_PROJ_12817  we get after creation of project
		.when()
		      .patch("http://49.249.28.218:8091/project/NH_PROJ_12856")
		
		//perform validation
		.then()
		      .assertThat().statusCode(200)
		      
		//for getting all the details over console      
		      .log().all();
		
	}
}
