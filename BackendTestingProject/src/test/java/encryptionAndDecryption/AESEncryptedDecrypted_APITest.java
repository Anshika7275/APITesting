package encryptionAndDecryption;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class AESEncryptedDecrypted_APITest {
	
	@Test
	public void encryptDecrypttest() throws Throwable {
		
		/*Call the ustility class to encrypt or decrypt the data*/
		
		String privateKey= "Ac03tEam@j!tu_#1";
		AESEncryptionDecryptionTechniqueUtility data = new AESEncryptionDecryptionTechniqueUtility();
		
		//get json body from swagger documnet
		String jsonBody="{ \"employee\": { \"empId\":\"NH_PROJ_9840\", "
				+ "\"designation\": \"string\", "
				+ "\"dob\": null, "
				+ "\"email\": \"demoacc@gmail.com\", "
				+ "\"empName\": \"admin\", "
				+ "\"experience\": 0, "
				+ "\"mobileNo\": \"75645345678\", "
				+ "\"project\": \"string\", "
				+ "\"role\": \"string\", "
				+ "\"username\": “admin” }, "
				+ "\"basicPlusVda\": 0, "
				+ "\"hra\":25000, \"insurance\": 3000, \"lta\": 0, "
				+ "\"lwf\": 0, \"netPay\": 0, \"payroll_id\": 0, "
				+ "\"pf\": 4000, \"pt\": 0, \"stat_bonus\": 0, "
				+ "\"status\": “Active” }";
		
		//call encrypt method from utility class---> to encryp the data
		String jasonReqBody = data.encrypt(jsonBody, privateKey);
		System.out.println(jasonReqBody);
		
		Response resp = given()
		      .body(jasonReqBody)      //pass the encrypted body
		.when()
		      .put("http://49.249.28.218:8091/payroll");
		resp.then()
		      .log().all();	
		
		//call decrypt method from utility class--->decrypt the data
		
		String jsonResponseBody = data.decrypt(resp.getBody().asString(), privateKey);
		System.out.println(jsonResponseBody);
		
	}

}
