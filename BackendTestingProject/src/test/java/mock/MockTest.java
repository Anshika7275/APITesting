package mock;

import org.mockito.BDDMockito.Then;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;



public class MockTest {
	
	@Test
	public void generateToken() {
		
		Response resp = given().contentType(ContentType.JSON)
		.queryParam("email", "test@airportgap.com")
		.queryParam("password", "airportgappassword")
		
		.when().post("https://airportgap.com/api/tokens");
		resp.then().log().all();
		
		String data=resp.jsonPath().get("token");
		
		System.out.println(data);
		
	//get all the airport id
		when().get("https://airportgap.com/api/airports")
		.then().log().all();
		String id=resp.jsonPath().get("data[0].id");

	
//add to favorite
		
		given().contentType(ContentType.JSON)
		.auth().oauth2(data)
		.queryParam("airport_id", "YAY")
		
		.when().post("https://airportgap.com/api/favorites")
		.then().log().all();
		
		String aid=resp.jsonPath().get("data.id");
		
		//update faurite
		
		given().contentType(ContentType.JSON)
		.auth().oauth2(data)
		.queryParam("note", "My usual layover when visiting family")
		.when().post("https://airportgap.com/api/favorites/"+aid+"")
		.then().log().all();
		
		
		
	

	
	
	
	}
	
	
	
	
	
	
	
	
}



