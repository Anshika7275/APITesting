package validationViaAssertion;

import static io.restassured.RestAssured.when;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.jayway.jsonpath.JsonPath;
import io.restassured.response.Response;

public class VerifyResponseBody_complexJsonXPath {
	@Test
	public void verifyResponseBodyTest()
	{
		Response resp = when().get("http://49.249.28.218:8091/projects-paginated");
		resp.then().log().all();
		
		//json path class 
		List<String> list =JsonPath.read(resp.asString(),".content[*].projectName");
		System.out.println(list);
		
		for(String proName: list)
		{
			System.out.println(proName);
		}
		
		List<String> list1 =JsonPath.read(resp.asString(),".content[*].[?(@.projectName=='Sales_Factory')].projectId");
		
		String actProId = list1.get(0);
		Assert.assertEquals(actProId, "NH_PROJ_9972");
	}

}
