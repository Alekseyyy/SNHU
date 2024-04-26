package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import contact.Contact;

/*
 * When Implementing the "ContactTest" class, I based it on the tutorial [3]
 * to the best of my ability. Also, I ran into problems when importing JUnit
 * class for the purposes of assertions, and relied on [1] and [2] when imp-
 * -lementing solutions.
 */
class ContactTest {

	@Test
	void testContact() {
		Contact contactClass = new Contact("12345", "Aleksey", 
			"Ahmann", "5555555555", "1 Hacker Way");
		assertTrue(contactClass.getContactID().equals("12345"));
		assertTrue(contactClass.getFirstName().equals("Aleksey"));
		assertTrue(contactClass.getLastName().equals("Ahmann"));
		assertTrue(contactClass.getPhone().equals("5555555555"));
		assertTrue(contactClass.getAddress().equals("1 Hacker Way"));
	}
	
	@Test
	void testContactIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact ("1234567890987654321", "Aleksey", "Ahmann", 
				"5555555555", "1 Hacker Way");
		});
	}
	
	@Test
	void testContactIDIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact (null, "Aleksey", "Ahmann", "5555555555", "1 Hacker Way");
		});
	}
	
	@Test
	void testFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact ("12345", "FirstNameIsTooLong1234567890", 
				"Ahmann", "5555555555", "1 Hacker Way");
		});
	}
	
	@Test
	void testFirstNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact ("12345", null, "Ahmann", "5555555555", "1 Hacker Way");
		});
	}
	
	@Test
	void testLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact ("12345", "Aleksey", "LastNameIsTooLong1234567890", 
				"5555555555", "1 Hacker Way");
		});
	}
	
	@Test
	void testLastNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact ("12345", "Aleksey", null, "5555555555", "1 Hacker Way");
		});
	}
	
	@Test
	void testPhoneNumberNotEqual() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact ("12345", "Aleksey", "Ahmann", "123456789", "1 Hacker Way");
			new Contact ("12345", "Aleksey", "Ahmann", "12345678901", "1 Hacker Way");
		});
	}
	
	@Test
	void testPhoneNumberIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact ("12345", "Aleksey", "Ahmann", null, "1 Hacker Way");
		});
	}
	
	@Test
	void testAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact ("12345", "Aleksey", "Ahmann", "5555555555", 
				"ThisAddressIsWayTooLongLikeWayMoreThanThe30CharacterLimit");
		});
	}
	
	@Test
	void testAddressIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact ("12345", "Aleksey", "Ahmann", "5555555555", null);
		});
	}
	
	@Test
	void testSetFirstName() {
		Contact contactClass = new Contact("12345", "Aleksey", 
			"Ahmann", "5555555555", "1 Hacker Way");
		assertTrue(contactClass.setFirstName("Xander"));
		assertTrue(contactClass.getFirstName().equals("Xander"));
	}
	
	@Test
	void testSetFirstNameIsTooLong() {
		Contact contactClass = new Contact("12345", "Aleksey", 
			"Ahmann", "5555555555", "1 Hacker Way");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactClass.setFirstName("12345678901");
		});
	}
	
	@Test
	void testSetFirstNameIsNull() {
		Contact contactClass = new Contact("12345", "Aleksey", 
			"Ahmann", "5555555555", "1 Hacker Way");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactClass.setFirstName(null);
		});
	}
	
	@Test
	void testSetLastName() {
		Contact contactClass = new Contact("12345", "Aleksey", 
			"Ahmann", "5555555555", "1 Hacker Way");
		assertTrue(contactClass.setLastName("Mann"));
		assertTrue(contactClass.getLastName().equals("Mann"));
	}
	
	@Test
	void testSetLastNameIsTooLong() {
		Contact contactClass = new Contact("12345", "Aleksey", 
			"Ahmann", "5555555555", "1 Hacker Way");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactClass.setLastName("12345678901");
		});
	}
	
	@Test
	void testSetLastNameIsNull() {
		Contact contactClass = new Contact("12345", "Aleksey", 
			"Ahmann", "5555555555", "1 Hacker Way");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactClass.setLastName(null);
		});
	}
	
	@Test
	void testSetPhone() {
		Contact contactClass = new Contact("12345", "Aleksey", 
			"Ahmann", "5555555555", "1 Hacker Way");
		assertTrue(contactClass.setPhone("6666666666"));
		assertTrue(contactClass.getPhone().equals("6666666666"));
	}
	
	@Test
	void testSetPhoneIsTooShort() {
		Contact contactClass = new Contact("12345", "Aleksey", 
			"Ahmann", "5555555555", "1 Hacker Way");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactClass.setPhone("123456789");
		});
	}
	
	@Test
	void testSetPhoneIsTooLong() {
		Contact contactClass = new Contact("12345", "Aleksey", 
			"Ahmann", "5555555555", "1 Hacker Way");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactClass.setPhone("12345678901");
		});
	}
	
	@Test
	void testSetPhoneIsNull() {
		Contact contactClass = new Contact("12345", "Aleksey", 
			"Ahmann", "5555555555", "1 Hacker Way");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactClass.setPhone(null);
		});
	}
	
	@Test
	void testSetAddress() {
		Contact contactClass = new Contact("12345", "Aleksey", 
			"Ahmann", "5555555555", "1 Hacker Way");
		assertTrue(contactClass.setAddress("410 Terry Ave N"));
		assertTrue(contactClass.getAddress().equals("410 Terry Ave N"));
	}
	
	@Test
	void testSetAddressIsTooLong() {
		Contact contactClass = new Contact("12345", "Aleksey", 
			"Ahmann", "5555555555", "1 Hacker Way");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactClass.setAddress("1234567890123456789012345678901");
		});
	}
	
	@Test
	void testSetAddressIsNull() {
		Contact contactClass = new Contact("12345", "Aleksey", 
			"Ahmann", "5555555555", "1 Hacker Way");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactClass.setAddress(null);
		});
	}
}

/*
 * End notes:
 * 1. Retrieved c.a. Mar. 2024: 
 *   https://www.qualitestgroup.com/insights/technical-hub/how-to-set-up-junit-in-eclipse/
 * 2. Retrieved c.a. Mar. 2024: 
 *   https://stackoverflow.com/questions/15105556/the-import-org-junit-cannot-be-resolved
 * 3. Retrieved c.a. Mar. 2024: 
 *   https://www.youtube.com/watch?v=KbXhK9HUng4
 */
