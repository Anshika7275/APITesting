package crudOperation_withoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

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
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		
		//get request body from jsonObject and convert it into json string format
		req.body(jsonObj.toJSONString());
		
		//create project with req---> all pre-condition is in req variablejsonObj
		//projectID----> NH_PROJ_12817  we get after creation of project
		Response resp = req.patch("http://49.249.28.218:8091/project/NH_PROJ_12822");
		resp.then().log().all();
		resp.then().assertThat().statusCode(200);
	}
}
