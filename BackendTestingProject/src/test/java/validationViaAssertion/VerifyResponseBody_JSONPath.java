package validationViaAssertion;

import static io.restassured.RestAssured.when;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class VerifyResponseBody_JSONPath {
	@Test
	public void verifyResponseBodyTest()
	{
		Response resp = when().get("http://49.249.28.218:8091/projects-paginated");
		resp.then().log().all();
		
		int data = resp.jsonPath().get("numberOfElements");   //when we use json path here no need to add dot by default it will understand
		System.out.println(data);
		
		Object data2 = resp.jsonPath().get("pageable.sort.unsorted");
		System.out.println(data2);
		
		Object data3 = resp.jsonPath().get("content[0].projectId");
		System.out.println(data3);
		            
		//Inbuilt restAssured method for assertion
		
		resp.then().body("content[0].projectId", Matchers.equalTo("NH_PROJ_9972"));
		resp.then().body("numberOfElements", Matchers.greaterThanOrEqualTo(20));
		resp.then().body("pageable.sort.unsorted", Matchers.equalTo(true));
		
		
	}

}
