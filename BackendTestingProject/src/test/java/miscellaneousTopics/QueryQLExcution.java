package miscellaneousTopics;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class QueryQLExcution {
	
	@Test
	public void getAllProject()
	{
		
		String query="{ getAllProjects{ projectId projectName status } }";
		given()
	       .contentType(ContentType.JSON)                     
	       .body(query)  
	       .log().all()
	    .when()
	        .post("http://49.249.28.218:8091/getAll")
	    .then()
	          .log().all();
	}
	
	@Test
	public void addProject()
	{
		
		String query="{ addProject( projectName: \"Project Name\", "
				+ "teamSize: 5, createdBy: \"John Doe\", "
				+ "createdOn: \"2024-07-05\", status: \"Created\" ) "
				+ "{ projectId projectName teamSize createdBy createdOn status } }";
		given()
	       .contentType(ContentType.JSON)                     
	       .body(query)  
	       .log().all()
	    .when()
	        .post("http://49.249.28.218:8091/addProject-graphql")
	    .then()
	          .log().all();
	}
	
	@Test
	public void getProjectByProjectID()
	{
		
		String query="{ findProject(projectId:\"NH_PROJ_12856\"){ projectId projectName status createdBy teamSize } }";
		given()
	       .contentType(ContentType.JSON)                     
	       .body(query)  
	       .log().all()
	    .when()
	        .post("http://49.249.28.218:8091/getProjectByProjectId")
	    .then()
	          .log().all();
	}
	
	@Test
	public void updateProject()
	{
		
		String query="{ updateProject( projectId: \"NH_PROJ_12856\" "
				+ "projectName: \"Updated Project Name\", teamSize: 1, "
				+ "createdBy: \"John Doe\", createdOn: \"2024-07-05\", status: \"Created\" ) "
				+ "{ projectId projectName teamSize createdBy createdOn status } }";
		given()
	       .contentType(ContentType.JSON)                     
	       .body(query)  
	       .log().all()
	    .when()
	        .post("http://49.249.28.218:8091/updateProject-graphql")
	    .then()
	          .log().all();
	}

}
