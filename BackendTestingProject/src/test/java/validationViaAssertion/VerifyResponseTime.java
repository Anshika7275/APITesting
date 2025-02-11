package validationViaAssertion;

import static io.restassured.RestAssured.when;

import java.util.concurrent.TimeUnit;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class VerifyResponseTime {
	
	@Test
	public void verifyResponseHeaderTest()
	{
		Response resp = when().get("http://49.249.28.218:8091/project/NH_PROJ_8835");
		resp.then().log().all();
		
		long time = resp.time();                              //Time validation
		long timeSec = resp.timeIn(TimeUnit.SECONDS);         //time validation in second
		System.out.println(time);
		System.out.println(timeSec);
		
		//time validation
		/*
		 * Matcher class---> Hemcrest--->lessthan method,greaterthat method
		 */
		resp.then().assertThat().time(Matchers.lessThan(1500L));         //less than
		resp.then().assertThat().time(Matchers.greaterThan(300L));      //greater than
		
		resp.then().assertThat().time(Matchers.both(Matchers.lessThan(1500L)).and(Matchers.greaterThan(300L)));   //both
		            
		
	}

}
