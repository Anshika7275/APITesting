package practice_JavaSerilizationAndDe_Serilization;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class NFSGame implements Serializable
{
	String name;
	int level;
	long score;
	int life;
	
	public NFSGame(String name, int level, long score, int life) {
		super();
		this.name = name;
		this.level = level;
		this.score = score;
		this.life = life;
	}
}

public class NFSGame_SerilizationTest {

	public static void main(String[] args) throws Throwable 
	{
		NFSGame userObject=new NFSGame("Anshi",20,60000,1);
		
		//Java representation of physical file
		FileOutputStream fos=new FileOutputStream("./SerilizationFile.Txt");
		
		//Convert java object into Binary
		ObjectOutputStream objOut=new ObjectOutputStream(fos);
		
		//write java object back to binary
		objOut.writeObject(userObject);
		System.out.println("===END===");
				

	}

}
