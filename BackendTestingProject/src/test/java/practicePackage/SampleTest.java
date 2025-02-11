package practicePackage;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SampleTest {
	@Test
	public void sampleGetReqTest()
	{
		//ReqRes---> GET operation
		
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(response.prettyPeek());
		
		
	}

}
