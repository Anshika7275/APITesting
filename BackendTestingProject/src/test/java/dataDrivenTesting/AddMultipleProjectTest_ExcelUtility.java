package dataDrivenTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generic.fileutility.ExcelUtility;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class AddMultipleProjectTest_ExcelUtility {
	
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
	public Object[][] getData() throws Throwable {
		
		ExcelUtility elib = new ExcelUtility();
		int count = elib.getRowcount("project");
		
		Object[][] objarr= new Object[count][2];
		
		for(int i=0; i<count; i++)
		{
			objarr[i][0]=elib.getDatafromExcelfle("project", i+1, 0);
			objarr[i][0]=elib.getDatafromExcelfle("project", i+1, 1);
		}
		
		return objarr;
		
		
	}
	

}
