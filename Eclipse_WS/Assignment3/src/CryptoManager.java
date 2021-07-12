/*
 * Class: CMSC203 47729
 * Instructor: Pro. Grigoriy Grinberg
 * Description: Use Caesar Cipher and Bellaso Cipher to encrypt and decrypt a string.
 * Due: 7/12/2021
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: YingShuan Lin
   
   pseudo-code
   1. start
   2. declare variables
   3. First, determine whether the string is within the allowable range of ASCII code
   4. In stringInBounds method, use for loop to complete the method
   5. 	integer i < the length of plainText, i+1
   6. 	According to the LOWER_BOUND and UPPER_BOUND characters, if plainTextSub < LOWER_BOUND or plainTextSub > UPPER_BOUND, return false
   7. According to the Caesar Cipher, the integer key specifies an offset
   8. In encryptCaesar method, use byte to encrypt the string
   8. 	use for loop to compare the integer i and the length of plainText, integer i < the length of plainText, i+1
   9. return the encrypted string
   10. According the Bellaso Cipher to encrypt the string
   11. In encryptBellaso method, use byte to make plainText be encrypted and bellasoStr specify the offsets
   12. return the encrypted string
   13. use for loop, integer i < the length of plainText, i+1
   14. 	key specifies the offset of each character
   15. return the encrypted string
   16. According to the Caesar Cipher, decrypts a string
   17. In decryptCaesar method, use byte to decrypt
   18. use for loop to compare the integer i and the length of encryptedText, integer i < the length of plainText, i+1
   19. declare modVal, modVal is encrypted the string
   20. if modVal < 0, modVal = (modVal + RANGE) % RANGE
   21. 	use byte to make modVal + LOWER_BOUND
   22. return encrypted string
   23. According the Bellaso Cipher to decrypt the string
   24. In decryptBellaso method, use byte to make encryptedText decrypt and bellasoStr specify the offsets
   25. use for loop to compare the integer i and the length of encryptedText, integer i < the length of plainText, i+1
   26. declare modVal = ((bytes[i] - keys[i % keys.length] + (int)(LOWER_BOUND)) % RANGE)
   27. if modVal < 0, modVal = (modVal + RANGE) % RANGE
   28. use byte to make modVal + LOWER_BOUND
   29. return the decrypted string
   30. end
*/



import java.nio.charset.StandardCharsets;
//HOW MUCH WOOD CAN A WOODCHUCK IF A WOOD CHUCK COULD CHUCK
public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) { //determine whether the string is within the allowable range of ASCII code
		
		for(int i = 0; i<plainText.length(); i++)
		{
			String plainTextSub = plainText.substring(i, i+1);
			if(plainTextSub.compareTo(Character.toString(LOWER_BOUND))<0 || plainTextSub.compareTo(Character.toString(UPPER_BOUND))>0) //without the allowable bounds, return false
			{
				
				return false;
			}
		}
		
		return true; //within the allowable bounds, return true
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		byte[] bytes = plainText.getBytes(StandardCharsets.US_ASCII); //According to the Caesar Cipher to encrypt the string
		for(int i = 0; i<plainText.length(); i++)
		{
		
			bytes[i] = (byte)((((bytes[i] + key - (int)(LOWER_BOUND))) % RANGE) + (int)(LOWER_BOUND)); // encrypt the string
		}
		return new String(bytes, StandardCharsets.US_ASCII); //return encrypted string
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		byte[] bytes = plainText.getBytes(StandardCharsets.US_ASCII);
		byte[] keys = bellasoStr.getBytes(StandardCharsets.US_ASCII); //According the Bellaso Cipher to encrypt a string
		for(int i = 0; i<plainText.length(); i++)
		{
			bytes[i] = (byte)(((bytes[i] + keys[i % keys.length] - (int)(LOWER_BOUND)) % RANGE) + (int)(LOWER_BOUND)); //encrypts the string
		}
		return new String(bytes, StandardCharsets.US_ASCII); //return the encrypted string
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		byte[] bytes = encryptedText.getBytes(StandardCharsets.US_ASCII); //According to the Caesar Cipher to decrypt the string
		for(int i = 0; i<encryptedText.length(); i++)
		{
			int modVal = ((bytes[i] - key + (int)(LOWER_BOUND)) % RANGE); //decrypts the string
			if(modVal < 0)
			{
				modVal = (modVal + RANGE) % RANGE; //decrypts the string
			}
			bytes[i] = (byte)(modVal + (int)(LOWER_BOUND)); //decrypts the string
		}
		return  new String(bytes, StandardCharsets.US_ASCII); //return the plain text string
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		byte[] bytes = encryptedText.getBytes(StandardCharsets.US_ASCII);
		byte[] keys = bellasoStr.getBytes(StandardCharsets.US_ASCII); //According the Bellaso Cipher to decrypt the string
		for(int i = 0; i<encryptedText.length(); i++)
		{
			int modVal = ((bytes[i] - keys[i % keys.length] + (int)(LOWER_BOUND)) % RANGE); //decrypts the string
			if(modVal < 0)
			{
				modVal = (modVal + RANGE) % RANGE; //decrypts the string
			}
			bytes[i] = (byte)(modVal + (int)(LOWER_BOUND)); //decrypts the string
		}
		return new String(bytes, StandardCharsets.US_ASCII); //return the decrypted string
		
	}
	
}
