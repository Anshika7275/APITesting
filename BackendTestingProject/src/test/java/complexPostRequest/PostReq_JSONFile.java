package complexPostRequest;

import static io.restassured.RestAssured.given;

import java.io.File;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostReq_JSONFile {
	@Test
	public void AddProjectTest()
	{	
		File file=new File(".\\jsonFile\\NinjaHRM2.json");

		given()
		       .contentType(ContentType.JSON)                  
		       .body(file)                  
		.when()
		       .post("http://49.249.28.218:8091/addProject")
		
		.then()
		       .statusCode(201)
		       .log().all();
	}


}
