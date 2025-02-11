package complexPostRequest;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostReq_JSONObject {
	
	@Test
	public void AddProjectTest()
	{	
		JSONObject jsonObj = new JSONObject();

		jsonObj.put("createdBy", "Anshi");
		jsonObj.put("projectName", "TekPyramid_101");
		jsonObj.put("status", "Created");
		jsonObj.put("teamSize", 0);

		given()
		       .contentType(ContentType.JSON)                  
		       .body(jsonObj.toJSONString())                  
		.when()
		       .post("http://49.249.28.218:8091/addProject")
		
		.then()
		       .statusCode(201)
		       .log().all();
	}
}
