package miscellaneousTopics;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.io.File;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class JsonSchemeaValidation {
	
	@Test
	public void AddProjectTest()
	{	
		
		JSONObject jsonObj = new JSONObject();

		jsonObj.put("createdBy", "Anshi");
		jsonObj.put("projectName", "TekPyramid_11");
		jsonObj.put("status", "Created");
		jsonObj.put("teamSize", 0);
		
		Response resp = given()
		       .contentType(ContentType.JSON)               
			       
		       .body(jsonObj.toJSONString())                  

		.when()
		       .post("http://49.249.28.218:8091/addProject");
		
		resp.then()
		       .statusCode(201)
		       
		/*JSON Schema validation*/
				.body(JsonSchemaValidator.matchesJsonSchema(new File("./src\\test\\resources\\jsonschema.json")))  
				.body("msg",instanceOf(String.class))     
		       .log().all();
	}

}
