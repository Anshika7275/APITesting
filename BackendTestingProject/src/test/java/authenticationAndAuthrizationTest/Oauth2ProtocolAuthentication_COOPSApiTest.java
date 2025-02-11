package authenticationAndAuthrizationTest;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Oauth2ProtocolAuthentication_COOPSApiTest {
	
	@Test
	public void auth()
	{
		Response resp = given().formParam("client_id", "authExample")   //unique value associated with the resource path
		.formParam("client_secret", "03530bc749866c8208a5f4bfd6f9f72f")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "http://exampleauthentication.com")
		.formParam("code", "authorization_code")
		
		.when().post("http://coop.apps.symfonycasts.com/token");
		
		resp.then().log().all();
		
		String token = resp.jsonPath().get("access_token");
		
		given().auth().oauth2(token)
		.pathParam("uId", 5110)
		
		.when().post("http://coop.apps.symfonycasts.com/api/{uId}/eggs-count")
		.then().log().all();
		
	}

}
