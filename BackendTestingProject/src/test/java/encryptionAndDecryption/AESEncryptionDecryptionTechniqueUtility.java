package encryptionAndDecryption;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/*
 * private key : Ac03tEam@j!tu_#1
 */

public class AESEncryptionDecryptionTechniqueUtility {
	
	public String encrypt(String input, String secretKey) throws Throwable, Throwable
	{
		//Encyption of data using AES 
		
		SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "AES");
		IvParameterSpec ivparameterSpec = new IvParameterSpec("4234567890123456".getBytes());
		
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		
		cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivparameterSpec);
		byte[] encrypted = cipher.doFinal(input.getBytes());
		
		return Base64.getEncoder().encodeToString(encrypted);
	}
	
	public String decrypt(String input, String secretKey) throws Throwable, Throwable
	{
		//Decryption of data using AES
		
		SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "AES");
		IvParameterSpec ivparameterSpec = new IvParameterSpec("4234567890123456".getBytes());
		
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		
		cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivparameterSpec);
		byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(input));
		return new String(decrypted);
	}

}
