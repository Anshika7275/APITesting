package crudOperation_withBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProjectTest 
{	
	
	@Test
	public void AddProjectTest()
	{	
		/*
		 * ============================Create a project=============================
		 * ============================POST--->/addProject==========================
		 */
		
		//get JSON object for body
		JSONObject jsonObj = new JSONObject();
		
		//get all key and values
		jsonObj.put("createdBy", "Anshi");
		jsonObj.put("projectName", "TekPyramid_11");
		jsonObj.put("status", "Created");
		jsonObj.put("teamSize", 0);
		
		// add all pre-conditions required to create project
		given()
		       .contentType(ContentType.JSON)                  //set content type
		
	    //get request body from jsonObject and convert it into json string format	       
		       .body(jsonObj.toJSONString())                  
		
		//Enter URI with http method
		.when()
		       .post("http://49.249.28.218:8091/addProject")
		
		//Perform validation
		.then()
		       .statusCode(201)
		       
		//for getting all the details over console       
		       .log().all();
		
		
		
	}
}
