package test;

import java.io.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import contact.Contact;
import contact.ContactService;

class ContactServiceTest {
	
	ContactService contactService;
	
	@BeforeEach
	void initialize() {
		contactService = new ContactService();
	}

	@Test
	void testAddContact() throws Exception {
		contactService.addContact("2", "Aleksey", 
			"Ahmann", "5555555555", "1 Hacker Way");
		Contact testContact = contactService.getContact("2");
		assertTrue(testContact.getContactID().equals("2"));
		assertTrue(testContact.getFirstName().equals("Aleksey"));
		assertTrue(testContact.getLastName().equals("Ahmann"));
		assertTrue(testContact.getPhone().equals("5555555555"));
		assertTrue(testContact.getAddress().equals("1 Hacker Way"));
	}
	
	@Test
	void testAddContactIsDuplicate() throws Exception {
		contactService.addContact("78", "Aleksey", 
			"Ahmann", "5555555555", "1 Hacker Way");
		Assertions.assertThrows(Exception.class, () -> {
		contactService.addContact("78", "Aleksey", 
				"Ahmann", "5555555555", "1 Hacker Way");
		});
	}
	
	@Test
	void testDeleteContact() throws Exception {
		contactService.addContact("1", "Aleksey", 
			"Ahmann", "5555555555", "1 Hacker Way");
		Contact testContact = contactService.getContact("1");
		assertTrue(testContact.getContactID().equals("1"));
		assertTrue(testContact.getFirstName().equals("Aleksey"));
		assertTrue(testContact.getLastName().equals("Ahmann"));
		assertTrue(testContact.getPhone().equals("5555555555"));
		assertTrue(testContact.getAddress().equals("1 Hacker Way"));
		contactService.deleteContact("1");
		Contact testContactDelete = contactService.getContact("1");
		assertTrue(testContactDelete == null);
	}
	
	@Test
	void testDeleteContactIsNull() throws Exception {
		contactService.addContact("79", "Aleksey", "Ahmann", "5555555555", "1 Hacker Way");
		Assertions.assertThrows(Exception.class, () -> {
			contactService.addContact("79", "Aleksey", 
				"Ahmann", "5555555555", "1 Hacker Way");
		});
	}
	
	@Test
	void testDeleteContactNonExistent() throws Exception {
		Assertions.assertThrows(Exception.class, () -> {
			contactService.deleteContact("9001");
		});
	}
	
	@Test
	void testUpdateContact() throws Exception {
		contactService.addContact("1", "Aleksey", 
			"Ahmann", "5555555555", "1 Hacker Way");
		
		contactService.updateContact("1", 1, "John");
		Contact testContact = contactService.getContact("1");
		String firstName = testContact.getFirstName();
		assertTrue(firstName.equals("John"));
		
		contactService.updateContact("1", 2, "Doe");
		testContact = contactService.getContact("1");
		String lastName = testContact.getLastName();
		assertTrue(lastName.equals("Doe"));
		
		contactService.updateContact("1", 3, "6666666666");
		testContact = contactService.getContact("1");
		String phone = testContact.getPhone();
		assertTrue(phone.equals("6666666666"));
		
		contactService.updateContact("1", 4, "410 Terry Ave N");
		testContact = contactService.getContact("1");
		String address = testContact.getAddress();
		assertTrue(address.equals("410 Terry Ave N"));
	}

	@Test
	void testUpdateContactIsNonExistent() throws Exception {
		Assertions.assertThrows(Exception.class, () -> {
			contactService.updateContact("9001", 0, "Dataum");
		});
	}
}

/*
 * End notes: 
 * 1. I wrote test units using similar techniques and referenced the same material
 *   as when I was writing test units for ContactTest.java --- just with a few tw-
 *   -eaks here and there.
 */
