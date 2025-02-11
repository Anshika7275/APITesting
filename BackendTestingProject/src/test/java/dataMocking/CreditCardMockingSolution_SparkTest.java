package dataMocking;

import org.apache.commons.lang3.StringUtils;

import com.jayway.jsonpath.JsonPath;

import spark.Spark;

public class CreditCardMockingSolution_SparkTest {
	
	public static void main(String[] args) {
		
		Spark.port(8889);
		Spark.post("/credit-card", (req,res)->{
			String response="";
			String card= JsonPath.read(req.body().toString(), "$.creditcard");
			
			if(StringUtils.equalsAny(card, "1234567891234", "123412345678"))
			{
				response="{status: Payment success}";
				res.status(200);
			}
			else
			{
				response="{status: Payment unsuccess}";
				res.status(404);
			}

			res.type("application/json");
			return response;

		});
		
		System.out.println("=======running...............==========");
	}

}
