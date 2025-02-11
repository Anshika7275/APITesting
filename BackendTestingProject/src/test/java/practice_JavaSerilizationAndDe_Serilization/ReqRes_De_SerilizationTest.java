package practice_JavaSerilizationAndDe_Serilization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ReqRes_De_SerilizationTest {
	
	public static void main(String[] args) throws Throwable {
		
		FileInputStream fis=new FileInputStream("./reqres.txt");
		ObjectInputStream objInp=new ObjectInputStream(fis);
		
		reqRes obj=(reqRes)objInp.readObject();
		
		System.out.println(obj.name);
		System.out.println(obj.job);
	}

}
