package typesOfParameter;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class FormParameterTest {
	

	@Test
	public void queryParameterTest()
	{
		given()
		      .formParam("teamSize", 1)
		      .log().all()
		.when()
		      .post("http://49.249.28.218:8091/project")
		.then()
		      .log().all();
	}

}
