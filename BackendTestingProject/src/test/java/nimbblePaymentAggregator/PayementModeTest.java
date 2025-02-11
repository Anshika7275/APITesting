package nimbblePaymentAggregator;

import static io.restassured.RestAssured.*;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PayementModeTest {

	public static void main(String[] args) {
		
		baseURI="https://api.nimbbl.tech";
		
System.out.println("********************************Authorization post request************************************");
//==============================Authorization post request to generate the token===============================================
		
		String accessKey="access_key_pKx7rWVgVpbXQvq2";
		String accessSecret="access_secret_DX3w55VKAkXbx7aB";
		
		String authorizatioRequestBody="{\"access_key\": \""+accessKey+"\", \"access_secret\": \""+accessSecret+"\"}";
		Response authorizationResponseBody = given()
				                                   .body(authorizatioRequestBody)
		                                           .contentType(ContentType.JSON)
		                                           .post("/api/v3/generate-token");
		             authorizationResponseBody.then()
		                                            .log().all();
		             
		String bearerToken = authorizationResponseBody.jsonPath().get("token");
		
System.out.println("****************************Create an order to post request********************************************");
//=========================================Create an order to post request======================================================
		
		String invoiceId= "inv_"+new Random().nextInt();
		String createOrderRequestBody= "{\r\n"
				+ "  \"amount_before_tax\": 2100,\r\n"
				+ "  \"tax\": 105,\r\n"
				+ "  \"total_amount\": 2205,\r\n"
				+ "  \"user\": {\r\n"
				+ "    \"email\": \"wonderwoman@themyscira.gov\",\r\n"
				+ "    \"first_name\": \"Diana\",\r\n"
				+ "    \"last_name\": \"Prince\",\r\n"
				+ "    \"country_code\": \"+91\",\r\n"
				+ "    \"mobile_number\": \"9876543210\"\r\n"
				+ "  },\r\n"
				+ "  \"shipping_address\": {\r\n"
				+ "    \"address_1\": \"1080 Beach Mansion\",\r\n"
				+ "    \"street\": \"Magic Beach Drive\",\r\n"
				+ "    \"landmark\": \"Opposite Magic Mountain\",\r\n"
				+ "    \"area\": \"Elyria\",\r\n"
				+ "    \"city\": \"Atlantis\",\r\n"
				+ "    \"state\": \"Castalia\",\r\n"
				+ "    \"pincode\": \"100389\",\r\n"
				+ "    \"address_type\": \"Beach House\"\r\n"
				+ "  },\r\n"
				+ "  \"currency\": \"INR\",\r\n"
				+ "  \"invoice_id\": \""+invoiceId+"\",\r\n"
				+ "  \"referrer_platform\": \"string\",\r\n"
				+ "  \"referrer_platform_version\": \"string\",\r\n"
				+ "  \"ip_address\": \"106.201.232.161\",\r\n"
				+ "  \"merchant_shopfront_domain\": \"https://merchant-shopfront.example.com\",\r\n"
				+ "  \"order_line_items\": [\r\n"
				+ "    {\r\n"
				+ "      \"sku_id\": \"item_2783027490\",\r\n"
				+ "      \"title\": \"Best Sliced Alphonso Mango\",\r\n"
				+ "      \"description\": \"The Alphonso mango is a seasonal fruit harvested from mid-April through the end of June. The time from flowering to harvest is about 90 days, while the time from harvest to ripening is about 15 days.The fruits generally weigh between 150 and 300 grams (5.3 and 10.6 oz), have a rich, creamy, tender texture and delicate, non-fibrous, juicy pulp. As the fruit matures, the skin of an Alphonso mango turns golden-yellow with a tinge of red across the top of the fruit\",\r\n"
				+ "      \"image_url\": \"https://en.wikipedia.org/wiki/Alphonso_mango#/media/File:Alphonso_mango.jpg\",\r\n"
				+ "      \"rate\": 1050,\r\n"
				+ "      \"quantity\": \"2\",\r\n"
				+ "      \"amount_before_tax\": \"2100.00\",\r\n"
				+ "      \"tax\": \"105.00\",\r\n"
				+ "      \"total_amount\": \"2205.00\"\r\n"
				+ "    }\r\n"
				+ "  ],\r\n"
				+ "  \"bank_account\": {\r\n"
				+ "    \"account_number\": \"10038849992883\",\r\n"
				+ "    \"name\": \"Diana Prince\",\r\n"
				+ "    \"ifsc\": \"ICIC0000011\"\r\n"
				+ "  },\r\n"
				+ "  \"custom_attributes\": {\r\n"
				+ "    \"name\": \"Diana\",\r\n"
				+ "    \"place\": \"Themyscira\",\r\n"
				+ "    \"animal\": \"Jumpa\",\r\n"
				+ "    \"thing\": \"Tiara\"\r\n"
				+ "  }\r\n"
				+ "}";
		
		 Response createOrderResponseBody = given()
		                                          .header("Authorization","Bearer "+bearerToken)
		                                          .body(createOrderRequestBody)
		                                          .post("/api/v3/create-order");
		             createOrderResponseBody.then()
		                                          .log().all();
		             
		 String orderId=createOrderResponseBody.jsonPath().get("order_id");
		 String userToken=createOrderResponseBody.jsonPath().get("user.token");
		 
System.out.println("*********************************Initiate Payment post request*************************************");
//==========================================initiate payment POST request========================================================
		 
		 LinkedHashMap<String, String> initiatePaymentHeader = new LinkedHashMap<String, String>();
		 initiatePaymentHeader.put("Authorization", "Bearer "+bearerToken);
		 initiatePaymentHeader.put("x-nimbble-user-token", userToken);
		 
		 String initiatePaymentRequestBody="{\r\n"
		 		+ "  \"order_id\": \""+orderId+"\",\r\n"
		 		+ "  \"callback_url\": \"https://mangoseller.awesome/transaction-response\",\r\n"
		 		+ "  \"payment_mode_code\": \"net_banking\",\r\n"
		 		+ "  \"bank_code\": \"axis\"\r\n"
		 		+ "}";
		Response initiatePaymentResponseBody = given()
				                                     .headers(initiatePaymentHeader)
		                                             .body(initiatePaymentRequestBody)
		                                             .contentType(ContentType.JSON)
		                                             .post("/api/v3/initiate-payment");
		
		             initiatePaymentResponseBody.then()
		                                             .log().all();
		             
		String redirectUrl=initiatePaymentResponseBody.jsonPath().get("next[0].url");
		String transactionId= initiatePaymentResponseBody.jsonPath().get("transaction_id");
		
		System.out.println("transaction id : "+transactionId);
		System.out.println("redirect URL : "+redirectUrl);
		
System.out.println("*********************************WebHook payment confirmation****************************************");
		
		//WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get(redirectUrl);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("username")).sendKeys("payu");
		driver.findElement(By.id("password")).sendKeys("payu");
		
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		
		driver.manage().window().minimize();
		
System.out.println("*******************************Transaction enquiry POST request*************************************");
		
		LinkedHashMap<String, String> transactionEnquiryHeader = new LinkedHashMap<String, String>();
		transactionEnquiryHeader.put("Authorization", "Bearer "+bearerToken);
		transactionEnquiryHeader.put("x-nimbble-user-token", userToken);
		
		String transactionEnquiryRequestPayBody="{\r\n"
				+ "  \"transaction_id\": \""+transactionId+"\",\r\n"
				+ "  \"order_id\": \""+orderId+"\",\r\n"
				+ "  \"invoice_id\": \""+invoiceId+"\"\r\n"
				+ "}";
		Response transcationEnquiryResponseBody = given() 
				                                        .headers(transactionEnquiryHeader)
		                                                .body(transactionEnquiryRequestPayBody)
		                                                .contentType(ContentType.JSON)
		                                          .when()
		                                               .post("/api/v3/transaction-enquiry");
		
		            transcationEnquiryResponseBody.then()
		                                               .log().all();
		
		String orderStatus=transcationEnquiryResponseBody.jsonPath().get("order.status");
		
		//Print order status
		System.out.println("order status "+orderStatus);
		
		driver.close();
		
		
	}
}
