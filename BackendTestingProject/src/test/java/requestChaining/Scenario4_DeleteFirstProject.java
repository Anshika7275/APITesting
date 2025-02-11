package requestChaining;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;
import io.restassured.response.Response;

public class Scenario4_DeleteFirstProject {
	
	@Test
	public void DeleteProjectTest()
	{	
		/* Test scenario: Delete first Project
		 * Get all project via API1
		 * Delete the first project via API2
		 */
		
		//API1               
		Response resp = when()
		       .get("http://49.249.28.218:8091/projects-paginated");
		resp.then()
		        .assertThat().statusCode(200)
		        .log().all();
		
		//capture project id from reponse
		
		String proId=resp.jsonPath().get("content[0].projectId");
		
		//API2
		when()
		      .delete("http://49.249.28.218:8091/project/"+proId)
		.then()
		      .assertThat().statusCode(204)
		      .log().all();
		
		
	}

}
