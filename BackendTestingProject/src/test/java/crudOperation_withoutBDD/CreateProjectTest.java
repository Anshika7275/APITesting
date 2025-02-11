package crudOperation_withoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
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
		jsonObj.put("projectName", "TekPyramid_3");
		jsonObj.put("status", "Created");
		jsonObj.put("teamSize", 0);
		
		// add all pre-conditions required to create project
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		
		//get request body from jsonObject and convert it into json string format
		req.body(jsonObj.toJSONString());
		
		//create project with req---> all pre-condition is in req variablejsonObj
		Response resp = req.post("http://49.249.28.218:8091/addProject");
		resp.then().log().all();
		resp.then().assertThat().statusCode(201);	
	}
}
