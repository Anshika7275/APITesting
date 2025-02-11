package encryptionAndDecryption;

import org.testng.annotations.Test;

public class AESEncryptedDecryptedTest {
	
	@Test
	public void encryptDecryptSampleTest() throws Throwable
	{
		String privateKey= "Ac03tEam@j!tu_#1";
		String input = "Deepak";
		AESEncryptionDecryptionTechniqueUtility data = new AESEncryptionDecryptionTechniqueUtility();
		
		String encryptData = data.encrypt(input, privateKey);  //encryption of data
		System.out.println(encryptData);
		
		String decryptData = data.decrypt(encryptData, privateKey);  //decryption of data
		System.out.println(decryptData);
		
	}
	
	@Test
	public void encryptDecryptJsonValueTest() throws Throwable
	{
		String privateKey= "Ac03tEam@j!tu_#1";
		String input = "{\r\n"
				+ "  \"name\" : \"Anshi\"\r\n"
				+ "  \"id\" : \"TP_01\"\r\n"
				+ "}";
		
		AESEncryptionDecryptionTechniqueUtility data = new AESEncryptionDecryptionTechniqueUtility();
		
		String encryptData = data.encrypt(input, privateKey);  //encryption of data
		System.out.println(encryptData);
		
		String decryptData = data.decrypt(encryptData, privateKey);  //decryption of data
		System.out.println(decryptData);
	}
	
	

}
