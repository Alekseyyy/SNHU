package com.snhu.sslserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.*;
import java.security.MessageDigest;

@SpringBootApplication
public class SslServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SslServerApplication.class, args);
	}

}

/*
 * Note that this class is taken from a previous
 *  assignment that I did (Module 5, Assignment 1; or 5-1)
 */
@RestController
class ServerController {
	
	public static String calculateChecksum(String plaintext) {
		
		StringBuffer finalHash = new StringBuffer();
		try {
			MessageDigest hashing = MessageDigest.getInstance("SHA-512/256");
			hashing.update(plaintext.getBytes());
			byte[] calculatedHash = hashing.digest();
			for (int i = 0; i < calculatedHash.length; i++)
				finalHash.append(Integer.toHexString(0xFF & calculatedHash[i]));
		}catch (NoSuchAlgorithmException ignoreIt) {}
		return finalHash.toString();
	}
	
	@RequestMapping("/hash")
	public String myHash() {
		String data = "A test string";
		String name = "Alexander Ahmann";
		String cipherInfo = "SHA-512/256 hashing algorithm: ";
		
		return "<p>data: " + name + " " + data + "<br />" 
		    + cipherInfo + " Checksum Value: " + calculateChecksum(name + data) + "</p>";
	}
}
