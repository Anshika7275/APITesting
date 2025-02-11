package practice_JacksonSerilizationAndDe_Serilization_POJO;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class De_Serilization_REQRESTest {

	public static void main(String[] args) throws Throwable, DatabindException, IOException {


		ObjectMapper objMap=new ObjectMapper();
		reqRes oObj = objMap.readValue(new File("./reqres.json"), reqRes.class);
		
		System.out.println(oObj.getName());
		System.out.println(oObj.getJob());

	}

}
