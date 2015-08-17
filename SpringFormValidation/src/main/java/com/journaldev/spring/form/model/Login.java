package com.journaldev.spring.form.model;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
 * @author asalest
 *
 */
public class Login {
	
	/**
	 * user
	 */
	private String user;
	/**
	 * password
	 */
	private String password;
	
	/**
	 * Constructor Login
	 */
	public Login(String user, String password){
		this.user=user;
		this.password=password;
	}
	/**
	 * Constructor Login vacio
	 */
	public Login(){
		/**
		 * Constructor Login vacio
		 */
	}

	/**
	 * getUser
	 * @return
	 */
	public String getUser() {
		return user;
	}

	/**
	 * setUser
	 * @param user
	 */
	public void setUser(final String user) {
		this.user = user;
	}

	/**
	 * getPassword
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * setPassword
	 * @param password
	 */
	public void setPassword(final String password) {
		this.password = password;
	}
	
	
	
	
	/*****************PRUEBAS JUNIT********************/
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
	 public String returnedHash(final String pass) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		
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
