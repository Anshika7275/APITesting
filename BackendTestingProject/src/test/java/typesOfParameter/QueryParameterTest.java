package typesOfParameter;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class QueryParameterTest {
	

	@Test
	public void queryParameterTest()
	{
		given()
		      .queryParam("teamSize", 1)
		      .log().all() 
		.when()
		      .get("http://49.249.28.218:8091/project")
		.then()
		      .log().all();
	}

}
