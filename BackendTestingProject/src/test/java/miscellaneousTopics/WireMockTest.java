package miscellaneousTopics;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class WireMockTest {
	@Test
	public void wireMockTest()
	{
		JSONObject jsonObj = new JSONObject();

		jsonObj.put("debitCardNum", "1234567887654321");
		jsonObj.put("cvv", "543");
		jsonObj.put("expDate", "28/30");
		
		given()
		   .contentType(ContentType.JSON)
	       .body(jsonObj.toJSONString())  
	       .log().all()
	    .when()
	        .post("http://localhost:9999/debitCard")
	    .then()
	          .log().all();
	}

}
