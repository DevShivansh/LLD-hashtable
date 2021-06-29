package hash.table.app.util;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import hash.table.app.Constants;

public class HashUtil<K> {
	
	static MessageDigest md = null;
	
	public HashUtil() throws NoSuchAlgorithmException {
		md = MessageDigest.getInstance("SHA-256"); 
	}
	
	public Integer hashFunction(K key) {
		
		String encodedString = toHexString(key);
		char[] chars = encodedString.toCharArray();
		int sum = 0;
		for(Character c : chars)
			sum += c;
		return sum % Constants.SIZE;
	}
	
	public String toHexString(K key)
    {	
		String address = key.toString();
		
		byte[] hash = md.digest(address.getBytes(StandardCharsets.UTF_8));
        // Convert byte array into signum representation 
        BigInteger number = new BigInteger(1, hash); 
  
        // Convert message digest into hex value 
        StringBuilder hexString = new StringBuilder(number.toString(16)); 
  
        // Pad with leading zeros
        while (hexString.length() < 32) 
        { 
            hexString.insert(0, '0'); 
        } 
  
        return hexString.toString(); 
    }

}
