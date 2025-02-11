package convertComplexJSON_POJOClass;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

class Project {

	private String projectname;
	private String projectstatus;
	List<String> teamMemeber;
	Projectmanager projectmanager;

	// constructor

	public Project(String projectname, String projectstatus, List<String> teamMemeber,
			Projectmanager projectmanager) {
		super();
		this.projectname = projectname;
		this.projectstatus = projectstatus;
		this.teamMemeber = teamMemeber;
		this.projectmanager = projectmanager;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectstatus(String projectstatus) {
		this.projectstatus = projectstatus;
	}

	public String getProjectstatus() {
		return projectstatus;
	}

	public void setTeamMemeber(List<String> teamMemeber) {
		this.teamMemeber = teamMemeber;
	}

	public List<String> getTeamMemeber() {
		return teamMemeber;
	}

	public void setProjectmanager(Projectmanager projectmanager) {	
		this.projectmanager = projectmanager;
	}

	public Projectmanager getProjectmanager() {
		return projectmanager;
	}

}

class Projectmanager {

	private String name;
	private String id;
	
	//constructor
	public Projectmanager(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
}

public class ConversionJSONFileToPOJOClass {
	
	public static void main(String[] args) throws Throwable, DatabindException, IOException {
		List<String> list=new ArrayList<String>();
		list.add("john");
		list.add("devid");
		list.add("steave");
		
		//object of project manager class
		Projectmanager pmObj=new Projectmanager("Sagar","tp01");
		
		//object of project class
		Project pobj=new Project("Anshii", "Created", list, pmObj);
		
		//convert back to json file
		
		ObjectMapper objMap=new ObjectMapper();
		objMap.writeValue(new File("./POJOToJSON.json"), pobj);
		
		System.out.println("===END===");
	}

}
