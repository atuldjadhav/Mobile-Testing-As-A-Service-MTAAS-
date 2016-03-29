package com.student.pack.rest.status;

import java.io.IOException;


//import java.util.Base64;
import org.apache.commons.codec.*;
import org.apache.commons.codec.binary.Base64;

import java.util.StringTokenizer;

import com.student.pack.dao.Login;
import com.student.pack.rest.status.Accessmanger;

public class AuthenticationService {
	public boolean authenticate(String authCredentials) {

		if (null == authCredentials)
			return false;
		
		// header value format will be "Basic encodedstring" for Basic
		// authentication. 
		
		final String encodedUserPassword = authCredentials.replaceFirst("Basic"
				+ " ", "");
		String usernameAndPassword = null;
		try {
			//byte[] decodedBytes = Base64.getDecoder().decode(
			//		encodedUserPassword);
			byte[] decodedBytes = Base64.decodeBase64(encodedUserPassword);
			
			usernameAndPassword = new String(decodedBytes, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		final StringTokenizer tokenizer = new StringTokenizer(
				usernameAndPassword, ":");
		final String username = tokenizer.nextToken();
		final String password = tokenizer.nextToken();
        Login obj = new Login();
		try {
		Accessmanger access = new Accessmanger();
		obj = access.fetchCredentials(username);
		
		} catch (Exception e) {
			System.out.println("Invalid credentials");
		}
		System.out.println(obj.getUname());
		System.out.println(obj.getPassword());
		
		boolean authenticationStatus = obj.getUname().equals(username) && obj.getPassword().equals(password);
		System.out.print(authenticationStatus);
		// we have fixed the userid and password as admin
		// call some UserService/LDAP here
		//boolean authenticationStatus = "admin".equals(username)
		//		&& "admin".equals(password);
		return authenticationStatus;
	}
}


