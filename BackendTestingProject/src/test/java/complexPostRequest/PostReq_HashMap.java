package complexPostRequest;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostReq_HashMap {
	
	@Test
	public void AddProjectTest()
	{	
		HashMap<String, Object> map = new HashMap();    //object store any type of data it si super most class
		
//		JSONObject jsonObj = new JSONObject();
//
		map.put("createdBy", "Anshi");
		map.put("projectName", "TekPyramid_1001");
		map.put("status", "Created");
		map.put("teamSize", 0);

		given()
		       .contentType(ContentType.JSON)                  
		       .body(map)                  
		.when()
		       .post("http://49.249.28.218:8091/addProject")
		
		.then()
		       .statusCode(201)
		       .log().all();
	}

}
