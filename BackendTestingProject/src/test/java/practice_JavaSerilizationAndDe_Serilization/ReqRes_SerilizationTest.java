package practice_JavaSerilizationAndDe_Serilization;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class reqRes implements Serializable
{
	String name;
	String job;
	
	public reqRes(String name, String job) {
		super();
		this.name = name;
		this.job = job;
	}
	
}

public class ReqRes_SerilizationTest {

	public static void main(String[] args) throws Throwable {
		
		reqRes obj=new reqRes("morpheus", "leader");
		
		FileOutputStream fos=new FileOutputStream("./reqres.Txt");
		ObjectOutputStream objOut=new ObjectOutputStream(fos);
		
		objOut.writeObject(obj);
		
		System.out.println("===END===");
		

	}

}
