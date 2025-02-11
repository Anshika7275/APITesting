package complexPostRequest;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojoClass.Utility.PostRequest_POJOClass;

public class PostReq_POJOClass {
	
	@Test
	public void AddProjectTest()
	{	
		//generate random number
		Random random=new Random();
		int no = random.nextInt(2000);
		
		//create an object of pojo class
		PostRequest_POJOClass pojo = new PostRequest_POJOClass("TP_"+no, "Created", "Deepak", 0);

		given()
		       .contentType(ContentType.JSON)                  
		       .body(pojo)                  
		.when()
		       .post("http://49.249.28.218:8091/addProject")
		
		.then()
		       .statusCode(201)
		       .log().all();
	}
}
