package miscellaneousTopics;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.config.LogConfig;

public class DataMasking {
	
	@Test
	public void dataMasking()
	{
		JSONObject jsonObj = new JSONObject();

		jsonObj.put("createdBy", "Anshi");
		jsonObj.put("projectName", "TekPyramid_11");
		jsonObj.put("status", "Created");
		jsonObj.put("teamSize", 0);
		
		given()
	       .config(config.logConfig(LogConfig.logConfig().blacklistHeader("Content-Type")))                     
	       .body(jsonObj.toJSONString())  
	       .log().all()
	    .when()
	        .post("http://49.249.28.218:8091/getAll")
	    .then()
	          .log().all();
	}

}
