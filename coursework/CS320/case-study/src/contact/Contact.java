package contact;

import java.io.*;
import java.util.*;

public class Contact {
	
	private String contactID;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	public Contact(String contactID, String firstName,
		String lastName, String phone, String address){
		
		/* NOTE that I initially used an "assert" statement when implementing
		 * this class, but ended up not using them in the final submission as
		 * to be in accordance with the requirements.
		 */
		if (contactID == null || contactID.length() > 10)
			throw new IllegalArgumentException("Invalid 'contactID'");
		this.contactID = contactID;
		
		if (firstName == null || firstName.length() > 10)
			throw new IllegalArgumentException("Invalid 'firstName'");
		this.firstName = firstName;
		
		if (lastName == null || lastName.length() > 10)
			throw new IllegalArgumentException("Invalid 'lastName'");
		this.lastName = lastName;
		
		if (phone == null || phone.length() != 10)
			throw new IllegalArgumentException("Invalid 'phone'");
		this.phone = phone;
		
		if (address == null || address.length() > 30)
			throw new IllegalArgumentException("Invalid 'address'");
		this.address = address;
	}
	
	public String getContactID() {
		return this.contactID;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public boolean setFirstName(String firstName) {
		if (firstName == null || firstName.length() > 10)
			throw new IllegalArgumentException("Invalid 'firstName'");
		this.firstName = firstName;
		return true;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public boolean setLastName(String lastName) {
		if (lastName == null || lastName.length() > 10)
			throw new IllegalArgumentException("Invalid 'lastName'");
		this.lastName = lastName;
		return true;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public boolean setPhone(String phone) {
		if (phone == null || phone.length() != 10)
			throw new IllegalArgumentException("Invalid 'phone'");
		this.phone = phone;
		return true;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public boolean setAddress(String address) {
		if (address == null || address.length() > 30)
			throw new IllegalArgumentException("Invalid 'address'");
		this.address = address;
		return true;
	}

}

/*
 * End notes:
 * 1. Retrieved c.a. Mar. 2024: 
 *   https://www.baeldung.com/java-assert
 */

