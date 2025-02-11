package requestChaining;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class Scenario3_GetPayrolViaAuth {
	@Test
	public void GetPayrollInfoTest()
	{
		/* Test scenario: Get payroll via authentication
		 * Login to app via API1
		 * Get auth token get an payroll info via API2
		 */
		
		Response resp = given()
		      .formParam("client_id", "ninza-client")   
		      .formParam("client_secret", "gPQBf1Yxew5OMccMhzos1GefIyiSnXzM")
		      .formParam("grant_type", "client_credentials")
		      
		.when()
		      .post("http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token");
		resp.then()
		      .log().all();
		
		//capture token from response
		String token = resp.jsonPath().get("access_token");
		
		//API 2
		given().auth().oauth2(token)
		.when()
		     .get("http://49.249.28.218:8091/admin/payrolls")
		.then()
		     .log().all();
		
	}

}
