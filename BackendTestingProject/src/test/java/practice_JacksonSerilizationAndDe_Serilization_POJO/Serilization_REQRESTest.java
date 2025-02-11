package practice_JacksonSerilizationAndDe_Serilization_POJO;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

class reqRes                           //POJO class
{
	private String name;
	private String job;
	
	public reqRes(String name, String job) {
		super();
		this.name = name;
		this.job = job;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}	
	
	public reqRes()
	{
		//for deserilization
	}
}

public class Serilization_REQRESTest {

	public static void main(String[] args) throws Throwable, DatabindException, IOException {
		reqRes pObj=new reqRes("morpheus", "leader");
		
		ObjectMapper objMap = new ObjectMapper();
		objMap.writeValue(new File("./reqres.json"), pObj);
		
		System.out.println("===END===");

	}

}
