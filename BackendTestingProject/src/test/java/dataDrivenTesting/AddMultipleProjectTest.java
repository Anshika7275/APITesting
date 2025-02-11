package dataDrivenTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class AddMultipleProjectTest {
	
	@Test(dataProvider = "getData")
	public void addMultipleProjectTest(String projectname, String status)
	{
		
		String reqBody="{\r\n"
				+ "  \"createdBy\": \"Deepak\",\r\n"
				+ "  \"projectName\": \""+projectname+"\",\r\n"
				+ "  \"status\": \""+status+"\",\r\n"
				+ "  \"teamSize\": 0\r\n"
				+ "}";
		
		given()
		      .contentType(ContentType.JSON)
		      .body(reqBody)
		.when()
		      .post("http://49.249.28.218:8091/addProject")
		.then()
		      .log().all();
		
	}
	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] objarr= new Object[3][2];
		
		objarr[0][0]="AirIndia_1";
		objarr[0][1]="Created";
		
		objarr[1][0]="AirIndia_2";
		objarr[1][1]="Created";
		
		objarr[2][0]="AirIndia_3";
		objarr[2][1]="Created";
		
		return objarr;
		
		
	}
	

}
