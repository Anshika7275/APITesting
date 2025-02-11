package convertComplexJSON_POJOClass;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

class Project1 {

	private String projectname;
	private String projectstatus;
	List<String> teamMemeber;
	List<Projectmanager> listProjectManager;

	// constructor

	public Project1(String projectname, String projectstatus, List<String> teamMemeber,
			List<listProjectManager> list) {
		super();
		this.projectname = projectname;
		this.projectstatus = projectstatus;
		this.teamMemeber = teamMemeber;
		this.listProjectManager = listProjectManager;
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

	public List<Projectmanager> getListProjectManager() {
		return listProjectManager;
	}

	public void setListProjectManager(List<Projectmanager> listProjectManager) {
		this.listProjectManager = listProjectManager;
	}
}

class listProjectManager {

	private String name;
	private String id;
	
	//constructor
	public listProjectManager(String name, String id) {
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

public class ConversionJSONFileToPOJO2Test {
	
	public static void main(String[] args) throws Throwable, DatabindException, IOException {
		List<String> prolist=new ArrayList<String>();
		prolist.add("john");
		prolist.add("devid");
		prolist.add("steave");
		
		//object of project manager class
		List<listProjectManager> list=new ArrayList<listProjectManager>();
		listProjectManager l1 = new listProjectManager("devid","tp01");
		listProjectManager l2 = new listProjectManager("johm","tp02");
		list.add(l1);
		list.add(l2);
		

		//object of project class
		Project1 pobj=new Project1("Anshii", "Created", prolist, list);
		
		//convert back to json file
		
		ObjectMapper objMap=new ObjectMapper();
		objMap.writeValue(new File("./POJOToJSON.json"), pobj);
		
		System.out.println("===END===");
	}

}
