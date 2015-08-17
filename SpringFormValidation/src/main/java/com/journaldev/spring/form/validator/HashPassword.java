package com.journaldev.spring.form.validator;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * 
 * @author asalest
 *
 */
public class HashPassword {

	/**
	 * Constructor Hash
	 */
	HashPassword(){
		/**
		 * Contructor Hash
		 */
	}
	 
	/**
	 * Encriptar contraseñas
	 * //NOT CONTROLLERS FUNCTIONS
	 * //Hash a string and return the hashed string
	 */
	/**
	 * @param pass
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	 public static String returnedHash(final String pass) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		
		 MessageDigest messageDigest;
		 byte[] bytesOfPass;
		 
		 messageDigest = MessageDigest.getInstance("MD5");
		 bytesOfPass = pass.getBytes("UTF-8");
		 messageDigest.reset();
		 messageDigest.update(bytesOfPass);
		 final byte[] thedigest = messageDigest.digest();
		 final BigInteger bigInt = new BigInteger(1,thedigest);
		 String hashtext = bigInt.toString(16);
		 while(hashtext.length() < 32){
			 hashtext = "0"+hashtext;
		 }
		 return hashtext;
	 }
	
}
