package requestChaining;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClass.Utility.EmployeePOJOClass;
import pojoClass.Utility.PostRequest_POJOClass;

public class Scenario2_AddEmployee {
	
	@Test
	public void AddEmployeeTest()
	{
		/* Test scenario: Add employee to project
		 * Create project via API1
		 * Add employee to same project via API2
		 */
		
		Random random=new Random();
		int no = random.nextInt(2000);
		
		//API1
		PostRequest_POJOClass pojo = new PostRequest_POJOClass("TP_"+no, "Created", "Deepak", 0);

		Response resp = given()
		       .contentType(ContentType.JSON)                  
		       .body(pojo)                  
		.when()
		       .post("http://49.249.28.218:8091/addProject");
		resp.then()
		        .log().all()
		        .statusCode(201);
		
		//capture project name from reponse
		
		String proName=resp.jsonPath().get("projectName");

		EmployeePOJOClass empObj = new EmployeePOJOClass("Architect", "24/04/1999", "deepak@gmail.com", "User_"+no, 18, "5467898756", proName, "ROLE_EMPLOYEE", "User_"+no);
		
		given()
		      .contentType(ContentType.JSON)
		      .body(empObj)   
		.when()
		     .post("http://49.249.28.218:8091/employees")
		.then()
		     .log().all();
		
	}

}
