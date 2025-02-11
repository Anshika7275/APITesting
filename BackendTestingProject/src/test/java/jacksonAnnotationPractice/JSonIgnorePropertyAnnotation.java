package jacksonAnnotationPractice;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;


@JsonIgnoreProperties(                            //control data to be exposed via json
		value = {"job"}, allowSetters = true
		
		)

class reqres // POJO class
{
	private String name;
	private String job;

	public reqres(String name, String job) {
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

	public reqres() {
		// for deserilization
	}
}

public class JSonIgnorePropertyAnnotation {

	public static void main(String[] args) throws Throwable, DatabindException, IOException {
		reqres pObj = new reqres("morpheus", "leader");

		ObjectMapper objMap = new ObjectMapper();
		objMap.writeValue(new File("./jsonIgnorePropertyAnnotation.json"), pObj);

		System.out.println("===END===");

	}

}
