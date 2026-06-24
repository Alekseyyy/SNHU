package contact;

import java.io.*;
import java.util.*;

public class ContactService {
	
	private static Hashtable<String, Contact> contactDatabase = new Hashtable<String, Contact>();
	/* Note that I initially wanted to use a Dictionary to store Contact object 
	 * information [1][2], but ended up deciding to use a "Hashtable" to manage
	 * the in-memory database of Contact objects.
	 */
	
	public void addContact(String contactID, String firstName,
		String lastName, String phone, String address) throws Exception {
		/* Note that I cited [5], [6], and [7] when researching more
		 * appropriate exceptions to throw as needed */
		if (contactDatabase.get(contactID) != null)
			throw new Exception("contactID already in contacts database");
		contactDatabase.put(contactID, new Contact(
			contactID, firstName, lastName, phone, address)
		);
	}
	
	public void deleteContact(String contactID) throws Exception {
		Contact currentContact = contactDatabase.get(contactID);
		if (currentContact == null)
			throw new Exception("contactID does not exist");
		contactDatabase.remove(contactID);
	}
	
	public void updateContact(String contactID, 
		int field, String data) throws Exception {
		
		Contact currentContact = contactDatabase.get(contactID);
		if (currentContact == null)
			throw new Exception("contactID does not exist");
		/* To update different fields in the contactDatabase, I figured
		 * that I could associate an integer with a particular field, and 
		 * then use a "switch" statement when updating the DB.
		 * I cited [3] and [4] when implementing the switch statement 
		 */
		switch(field) {
		case 1: // firstName
			currentContact.setFirstName(data);
			break;
		case 2: // lastName
			currentContact.setLastName(data);
			break;
		case 3: // phone
			currentContact.setPhone(data);
			break;
		case 4: // address
			currentContact.setAddress(data);
			break;
		default:
			break;
		}
	}
	
	public Contact getContact(String contactID) {
		return contactDatabase.get(contactID);
	}
}

/*
 * End notes:
 * 1. Retrieved c.a. Mar. 2024: 
 *   https://www.geeksforgeeks.org/java-util-dictionary-class-java/
 * 2. Retrieved c.a. Mar. 2024: 
 *   https://www.educative.io/answers/how-to-create-a-dictionary-in-java
 * 3. Retrieved c.a. Mar. 2024: 
 *   https://www.w3schools.com/java/java_switch.asp
 * 4. Retrieved c.a. Mar. 2024: 
 *   https://stackoverflow.com/questions/29045090/how-to-store-name-of-class-in-a-variable-in-java
 * 5. Retrieved c.a. Mar. 2024: 
 *   https://programming.guide/java/list-of-java-exceptions.html
 * 6. Retrieved c.a. Mar. 2024: 
 *   https://rollbar.com/guides/java/how-to-throw-exceptions-in-java/
 * 7. Retrieved c.a. Mar. 2024: 
 *   https://stackoverflow.com/questions/2305966/why-do-i-get-the-unhandled-exception-type-ioexception
 */