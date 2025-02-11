package encryptionAndDecryption;

import java.util.Base64;

import org.testng.annotations.Test;

public class BasicBase64_EncodingDecodingTest {
	
	@Test
	
	public void encodeAndDecodeTest()
	{
		//encode the data----> ABC
		
		String encodeData=new String(Base64.getEncoder().encode("ABC".getBytes()));
		System.out.println(encodeData);
		
		
		//Decode the data----> QUJD 
		
		String decodeData = new String(Base64.getDecoder().decode("QUJD".getBytes()));
		System.out.println(decodeData);
	}
	
	@Test
	public void encodedAndDecodeTest()
	{
		//encode the data UN:PSW---> rmgyantra:rmgy@9999
		
		String encodeData=new String(Base64.getEncoder().encode("rmgyantra:rmgy@9999".getBytes()));
		System.out.println(encodeData);
		
		
		//Decode the data----->same data
		
		String decodeData = new String(Base64.getDecoder().decode(encodeData.getBytes()));
		System.out.println(decodeData);
	}
	

}
