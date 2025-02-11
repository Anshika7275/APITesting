package miscellaneousTopics;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.annotations.Test;

public class UploadImage {
	
	@Test
	public void uploadImageTest() {
		
		File file= new File("C:\\Users\\anshi\\Downloads\\jsonschema.json");
		
		
		given() 
		  // .multiPart(new File("C:\\Users\\anshi\\Downloads\\jsonschema.json"))
	       .body(file)  
	       .log().all()
	    .when()
	        .post("http://postman-echo.com/post")
	    .then()
	          .log().all();
	}
	
	@Test
	public void uploadImage_MultipartTest() {
	
		given() 
		  .multiPart(new File("C:\\Users\\anshi\\Downloads\\jsonschema.json"))  
	       .log().all()
	    .when()
	        .post("http://postman-echo.com/post")
	    .then()
	          .log().all();
	}

}
