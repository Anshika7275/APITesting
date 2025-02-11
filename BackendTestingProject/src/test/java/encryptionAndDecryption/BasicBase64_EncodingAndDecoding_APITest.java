package encryptionAndDecryption;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BasicBase64_EncodingAndDecoding_APITest {
	
	@Test
	public void encodingAndDecodingTest()
	{
		given()
		      .auth()
		      .preemptive().basic("rmgyantra", "rmgy@9999")
		      .log().all()
		.when()
		      .get("http://49.249.28.218:8091/projects-paginated")
		.then()
		      .log().all();
	}

}
