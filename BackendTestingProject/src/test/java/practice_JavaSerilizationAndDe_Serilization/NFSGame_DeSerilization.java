package practice_JavaSerilizationAndDe_Serilization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class NFSGame_DeSerilization {

	public static void main(String[] args) throws Throwable {
		
		//get the java representation of file
		FileInputStream fis=new FileInputStream("./SerilizationFile.Txt");
		
		//Convert binary into java object
		ObjectInputStream objInp=new ObjectInputStream(fis);
		
		//read the java object
		NFSGame userObject = (NFSGame)objInp.readObject();    //return object of NFS game so we do down-casting
		
		//print all java object
		System.out.println(userObject.name);
		System.out.println(userObject.level);
		System.out.println(userObject.score);
		System.out.println(userObject.life);
	}

}
