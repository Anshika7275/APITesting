package practice_JacksonSerilizationAndDe_Serilization_POJO;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class De_SerilizationTest {

	public static void main(String[] args) throws Throwable, DatabindException, IOException {
		
		//convert json file into java object
		ObjectMapper objMap=new ObjectMapper();
		
		//pass the file location and class name
		project pojoObj = objMap.readValue(new File("./jacksonSerilization.json"), project.class);
		
		//get all the java object
		System.out.println(pojoObj.getProjectName());
		System.out.println(pojoObj.getCreatedBy());
		System.out.println(pojoObj.getTeamSize());
		System.out.println(pojoObj.getStatus());

	}

}
