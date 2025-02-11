package jacksonAnnotationPractice;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;


class project                        //POJO class
{
	private String projectName;
	
	@JsonProperty(value="created By")    //map the key between json and java
	
	private String createdBy;
	private int teamSize;
	private String status;

	//Serilization
	public project(String projectName, String createdBy, int teamSize, String status) {
		super();
		this.projectName = projectName;
		this.createdBy = createdBy;
		this.teamSize = teamSize;
		this.status = status;
	}
	
	//deserialization
	private project() {	
	}

	//Getters methods
	
	public String getProjectName() {
		return projectName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public String getStatus() {
		return status;
	}
	
	//setters method
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}

public class JSonPropertyAnnotation 
{

	public static void main(String[] args) throws Throwable, DatabindException, IOException {
		
		//java object for the project class
		project proObj= new project("TP_20", "Anshi", 0, "Created");
		
		//Use ObjectMapper to contvert into json file
		ObjectMapper objMap = new ObjectMapper();
		
		//call method writeValue to pass the path of the file
		objMap.writeValue(new File("./JSonPropertyAnnotation.json"), proObj);
		
		System.out.println("===END===");
		
	}

}
