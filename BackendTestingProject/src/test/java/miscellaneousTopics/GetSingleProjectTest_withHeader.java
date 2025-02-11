package miscellaneousTopics;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetSingleProjectTest_withHeader
{
	
	@Test
	public void getAllProjectTest() 
	{
		
		/*
		 * =======================get all project details=============================
		 * =======================GET--->/project/{projectId}=========================
		 */

		given().cookie("username", "rmgyantra")
		     .get("http://49.249.28.218:8091/project/NH_PROJ_12856")

		// validate the status code
		.then().assertThat().statusCode(200)

		// get all the logs and print in console
		.log().all();

	}

}
