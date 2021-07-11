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
	public static boolean stringInBounds (String plainText) {
		//System.out.println("   stringInBounds  In");
		for(int i = 0; i<plainText.length(); i++)
		{
			String plainTextSub = plainText.substring(i, i+1);
			if(plainTextSub.compareTo(Character.toString(LOWER_BOUND))<0 || plainTextSub.compareTo(Character.toString(UPPER_BOUND))>0)
			{
				//System.out.println("   stringInBounds  Out False");
				return false;
			}
		}
		//System.out.println("   stringInBounds  Out True");
		return true;
		//throw new RuntimeException("method not implemented");
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		byte[] bytes = plainText.getBytes(StandardCharsets.US_ASCII);
		for(int i = 0; i<plainText.length(); i++)
		{
			/*
			System.out.println("bytes[i] In: " + bytes[i]);
			System.out.println("keys[i % keys.length] In: " +key);
			System.out.println("bytes[i] + key1: " + (bytes[i] + key));
			System.out.println("bytes[i] + key2: " + ((bytes[i] + key - (int)(LOWER_BOUND))));
			System.out.println("bytes[i] + key3: " + (((bytes[i] + key - (int)(LOWER_BOUND)) % RANGE)));
			System.out.println("bytes[i] + key4: " + (((bytes[i] + key - (int)(LOWER_BOUND)) % RANGE) + (int)(LOWER_BOUND)));
			*/
			bytes[i] = (byte)((((bytes[i] + key - (int)(LOWER_BOUND))) % RANGE) + (int)(LOWER_BOUND));
			//System.out.println("bytes[i] Out: " + bytes[i]);
		}
		return new String(bytes, StandardCharsets.US_ASCII);
		//throw new RuntimeException("method not implemented");
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
		byte[] keys = bellasoStr.getBytes(StandardCharsets.US_ASCII);
		for(int i = 0; i<plainText.length(); i++)
		{
			/*
			System.out.println("bytes[i] In: " + bytes[i]);
			System.out.println("keys[i % keys.length] In: " + keys[i % keys.length]);
			System.out.println("bytes[i] + key1: " + (bytes[i] + keys[i % keys.length]));
			System.out.println("bytes[i] + key2: " + ((bytes[i] + keys[i % keys.length] - (int)(LOWER_BOUND))));
			System.out.println("bytes[i] + key3: " + (((bytes[i] + keys[i % keys.length] - (int)(LOWER_BOUND)) % RANGE)));
			System.out.println("bytes[i] + key4: " + (((bytes[i] + keys[i % keys.length] - (int)(LOWER_BOUND)) % RANGE) + (int)(LOWER_BOUND)));
			*/
			bytes[i] = (byte)(((bytes[i] + keys[i % keys.length] - (int)(LOWER_BOUND)) % RANGE) + (int)(LOWER_BOUND));
		}
		return new String(bytes, StandardCharsets.US_ASCII);
		//throw new RuntimeException("method not implemented");
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
		byte[] bytes = encryptedText.getBytes(StandardCharsets.US_ASCII);
		for(int i = 0; i<encryptedText.length(); i++)
		{
			/*
			System.out.println("bytes[i] In: " + bytes[i]);
			System.out.println("keys[i % keys.length] In: " + key);
			System.out.println("bytes[i] + key1: " + (bytes[i] - key + RANGE));
			System.out.println("bytes[i] + key2: " + ((bytes[i] - key  + RANGE + (int)(LOWER_BOUND))));
			System.out.println("bytes[i] + key3: " + (((bytes[i] - key  + RANGE + (int)(LOWER_BOUND)) % RANGE)));
			System.out.println("bytes[i] + key4: " + (((bytes[i] - key  + RANGE + (int)(LOWER_BOUND)) % RANGE) + (int)(LOWER_BOUND)));
			*/
			int modVal = ((bytes[i] - key + (int)(LOWER_BOUND)) % RANGE);
			if(modVal < 0)
			{
				modVal = (modVal + RANGE) % RANGE;
			}
			bytes[i] = (byte)(modVal + (int)(LOWER_BOUND));
			//bytes[i] = (byte)(((bytes[i] - key + (int)(LOWER_BOUND)) % RANGE) + (int)(LOWER_BOUND));
		}
		return  new String(bytes, StandardCharsets.US_ASCII);
		//throw new RuntimeException("method not implemented");
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
		byte[] keys = bellasoStr.getBytes(StandardCharsets.US_ASCII);
		for(int i = 0; i<encryptedText.length(); i++)
		{
			/*
			System.out.println("bytes[i] In: " + bytes[i]);
			System.out.println("keys[i % keys.length] In: " + keys[i % keys.length]);
			System.out.println("bytes[i] + key1: " + (bytes[i] - keys[i % keys.length] + RANGE));
			System.out.println("bytes[i] + key2: " + ((bytes[i] - keys[i % keys.length]  + RANGE + (int)(LOWER_BOUND))));
			System.out.println("bytes[i] + key3: " + (((bytes[i] - keys[i % keys.length]  + RANGE + (int)(LOWER_BOUND)) % RANGE)));
			System.out.println("bytes[i] + key4: " + (((bytes[i] - keys[i % keys.length]  + RANGE + (int)(LOWER_BOUND)) % RANGE) + (int)(LOWER_BOUND)));
			*/
			int modVal = ((bytes[i] - keys[i % keys.length] + (int)(LOWER_BOUND)) % RANGE);
			if(modVal < 0)
			{
				modVal = (modVal + RANGE) % RANGE;
			}
			bytes[i] = (byte)(modVal + (int)(LOWER_BOUND));
			//bytes[i] = (byte)(((bytes[i] - keys[i % keys.length] + RANGE + (int)(LOWER_BOUND)) % RANGE) + (int)(LOWER_BOUND));
		}
		return new String(bytes, StandardCharsets.US_ASCII);
		//throw new RuntimeException("method not implemented");
	}
}
