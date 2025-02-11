package requestChaining;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClass.Utility.PostRequest_POJOClass;

public class Scenario1_DeleteProjectTest {
	
	@Test
	public void DeleteProjectTest()
	{	
		/* Test scenario: Delete Project
		 * Create project via API1
		 * Delete the same project via API2
		 */
		
		Random random=new Random();
		int no = random.nextInt(2000);
		
		//API1
		PostRequest_POJOClass pojo = new PostRequest_POJOClass("TP_"+no, "Created", "Deepak", 0);

		Response resp = given()
		       .contentType(ContentType.JSON)                  
		       .body(pojo)                  
		.when()
		       .post("http://49.249.28.218:8091/addProject");
		resp.then()
		        .assertThat().statusCode(201)
		        .log().all();
		
		//capture project id from reponse
		
		String proId=resp.jsonPath().get("projectId");
		
		//API2
		when()
		      .delete("http://49.249.28.218:8091/project/"+proId)
		.then()
		      .assertThat().statusCode(204)
		      .log().all();
		
		
	}
}
