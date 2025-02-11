package crudOperation_withBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class UpdateProjectTest {

	@Test
	public void updateCompleteProjectTest() {

		/*
		 * ==========================Update complete project==================================
		 * ==========================PUT--->/project/{projectId}==============================
		 */

		// get JSON object for body
		JSONObject jsonObj = new JSONObject();

		// get all key and values
		jsonObj.put("createdBy", "Anshi");
		jsonObj.put("projectName", "TekPyramid_20");
		jsonObj.put("status", "On Going");
		jsonObj.put("teamSize", 0);

		// add all pre-conditions required to update project
		given()
		      .contentType(ContentType.JSON)

		// get request body from jsonObject and convert it into json string format
		      .body(jsonObj.toJSONString())

		// projectID----> NH_PROJ_12856 we get after creation of project
		.when()
		      .put("http://49.249.28.218:8091/project/NH_PROJ_12856")
		
		//perform the validation
		.then()
		        .assertThat().statusCode(200)
		        
		//for getting all the details over console         
		        .log().all();
		
	}
}
