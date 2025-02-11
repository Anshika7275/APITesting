package validationViaAssertion;

import static io.restassured.RestAssured.when;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class VerifyResponseBody_JSONPathTool {
	@Test
	public void verifyResponseBodyTest()
	{
		Response resp = when().get("http://49.249.28.218:8091/projects-paginated");
		resp.then().log().all();
		            
		//Inbuilt restAssured method for assertion
		
		resp.then().body("content[0].projectId", Matchers.equalTo("NH_PROJ_9972"));
		resp.then().body("numberOfElements", Matchers.greaterThanOrEqualTo(20));
		resp.then().body("pageable.sort.unsorted", Matchers.equalTo(true));
		
		Object idList = resp.jsonPath().get("content.projectId");
		Object nameList = resp.jsonPath().get("content.projectName");
		System.out.println(idList+"\n"+" "+ nameList);
		
	}

}
