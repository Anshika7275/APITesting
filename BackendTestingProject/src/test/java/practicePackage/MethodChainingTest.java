package practicePackage;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class MethodChainingTest {
	@Test
	public void getRequestTest()
	{
		get("https://reqres.in/api/users?page=2").prettyPrint();    //print only response
		get("https://reqres.in/api/users?page=2")
		.then()                                                         
		.log()      //logs
		.all();     //print response as well as date time status code
		
	}

}
