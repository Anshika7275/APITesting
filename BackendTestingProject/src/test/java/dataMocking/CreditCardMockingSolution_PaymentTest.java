package dataMocking;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreditCardMockingSolution_PaymentTest {
	
	@Test
	public void paymentTest()
	{
		JSONObject obj=new JSONObject();
		obj.put("creditcard", "123412345678");
		obj.put("cvv", "123");
		obj.put("cardname", "deepak");
		
		given()
		      .contentType(ContentType.JSON)
		      .body(obj)
		.when()
		     .post("http://localhost:8889/credit-card")    
		.then()
		     .log().all();
	}

}
