package validationViaAssertion;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class VerifyResponseHeader {
	
	@Test
	public void verifyResponseHeaderTest()
	{
		Response resp = when().get("http://49.249.28.218:8091/project/NH_PROJ_8835");
		resp.then().log().all();
		resp.then().assertThat()                                //start validation
		           .contentType(ContentType.JSON)               //content type
		           .statusCode(200)                             //status code
		           .statusLine("HTTP/1.1 200 ")                 //status line
		           .header("Transfer-Encoding", "chunked") ;    //header body(random key and value)
		
	}
	

}
