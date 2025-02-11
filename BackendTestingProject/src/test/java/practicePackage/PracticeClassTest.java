package practicePackage;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PracticeClassTest {
	
	@Test
	public void practiceTest() {
		RestAssured.get("https://reqres.in/api/users/2").prettyPrint();
	}

}
