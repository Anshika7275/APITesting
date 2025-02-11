package authenticationAndAuthrizationTest;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class Oauth2ProtocolAuthenticationTest {
	
	@Test
	public void auth()
	{
		
/************************************Pass clientId and client secret for authentication*************************************/
		
		Response resp = given()
	         .formParam("client_id", "ninza-client")   
	         .formParam("client_secret", "gPQBf1Yxew5OMccMhzos1GefIyiSnXzM")
	         .formParam("grant_type", "client_credentials")
	   .when()
	         .post("http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token");
	   resp.then()
	         .log().all();
		
	   //Capture the access token from response{keyCloak (Oauth 2.0)]
	   String token=resp.jsonPath().get("access_token");

/*****************************************With the token we access the resources****************************************/		
		given()
		      .auth().oauth2(token)
	   .when()
		      .get("http://49.249.28.218:8091/project/NH_PROJ_9972")
	   .then()
		      .log().all();
		 
	}

}
