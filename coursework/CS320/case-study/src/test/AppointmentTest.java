package test;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;

import appointment.Appointment;

class AppointmentTest {
	
	private Date calculateAppointmentDate(int month, int date, int year) {
		Calendar apCalendar = Calendar.getInstance();
		apCalendar.set(Calendar.MONTH, month);
		apCalendar.set(Calendar.DATE, date);
		apCalendar.set(Calendar.YEAR, year);
		return apCalendar.getTime();
	}

	@Test
	void testNewAppointment() {
		Date appointmentDate = calculateAppointmentDate(1, 1, 2025); // This will work out to Jan. 1, 2025
		Appointment testAppointment = new Appointment("1", appointmentDate, "Dentist");
		assertTrue(testAppointment.getAppointmentID().equals("1"));
		assertTrue(testAppointment.getAppointmentDate().equals(appointmentDate)); // NOTE that this software was tested c.a. April 2024.
																				// The test appointment date may need to be readjusted in
		 																		// order for the test to return proper results.
		assertTrue(testAppointment.getAppointmentDescription().equals("Dentist"));
	}
	
	@Test
	void testIDIsTooLong() throws IllegalArgumentException {
		Date appointmentDate = calculateAppointmentDate(1, 1, 2025);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("123456789012", appointmentDate, "Dentist");
		});
	}
	
	@Test
	void testIDIsNull() {
		Date appointmentDate = calculateAppointmentDate(1, 1, 2025);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(null, appointmentDate, "Dentist");
		});
	}
	
	@Test 
	void testAppointmentDateIsTooEarly() {
		Date appointmentDate = calculateAppointmentDate(1, 1, 2020);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("2", appointmentDate, "Dentist");
		});
	}
	
	@Test
	void testAppointmentDateIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("3", null, "Dentist");
		});
	}
	
	@Test
	void testAppointmentDescriptionIsTooLong() {
		Date appointmentDate = calculateAppointmentDate(1, 1, 2025);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("123456789012", appointmentDate, "12345678901234567890123456789012345678901234567890");
		});
	}
	
	@Test
	void testAppointmentDescriptionIsNull() {
		Date appointmentDate = calculateAppointmentDate(1, 1, 2025);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("4", appointmentDate, null);
		});
	}
	
	@Test
	void testSetAppointmentDate() {
		Date appointmentDate = calculateAppointmentDate(1, 1, 2025); // This will work out to Jan. 1, 2025
		Date newAppointmentDate = calculateAppointmentDate(2, 2, 2025); // This will work out to Feb. 2, 2025
		Appointment testAppointment = new Appointment("5", appointmentDate, "Dentist");
		assertTrue(testAppointment.getAppointmentDate().equals(appointmentDate));
		assertTrue(testAppointment.setAppointmentDate(newAppointmentDate));
		assertTrue(testAppointment.getAppointmentDate().equals(newAppointmentDate));
	}
	
	@Test
	void testSetAppointmentDateIsTooEarly() {
		Date appointmentDate = calculateAppointmentDate(1, 1, 2025); // This will work out to Jan. 1, 2025
		Date newAppointmentDate = calculateAppointmentDate(1, 1, 2020); // This will work out to Jan. 1, 2020
		Appointment testAppointment = new Appointment("6", appointmentDate, "Dentist");
		assertTrue(testAppointment.getAppointmentDate().equals(appointmentDate));
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testAppointment.setAppointmentDate(newAppointmentDate);
		});
	}
	
	@Test 
	void testSetAppointmentDateIsNull() {
		Date appointmentDate = calculateAppointmentDate(1, 1, 2025); // This will work out to Jan. 1, 2025
		Appointment testAppointment = new Appointment("7", appointmentDate, "Dentist");
		assertTrue(testAppointment.getAppointmentDate().equals(appointmentDate));
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testAppointment.setAppointmentDate(null);
		});
	}
	
	@Test
	void testSetDescription() {
		Date appointmentDate = calculateAppointmentDate(1, 1, 2025); // This will work out to Jan. 1, 2025
		Appointment testAppointment = new Appointment("8", appointmentDate, "Dentist");
		assertTrue(testAppointment.getAppointmentDescription().equals("Dentist"));
		testAppointment.setAppointmentDescription("Doctors");
		assertTrue(testAppointment.getAppointmentDescription().equals("Doctors"));
	}
	
	@Test
	void testSetDescriptionIsTooLong() {
		Date appointmentDate = calculateAppointmentDate(1, 1, 2025); // This will work out to Jan. 1, 2025
		Appointment testAppointment = new Appointment("9", appointmentDate, "Dentist");
		assertTrue(testAppointment.getAppointmentDescription().equals("Dentist"));
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testAppointment.setAppointmentDescription("123456789012345678901234567890123456789012345678901");
		});
	}
	
	@Test 
	void testSetDescriptionIsNull() {
		Date appointmentDate = calculateAppointmentDate(1, 1, 2025); // This will work out to Jan. 1, 2025
		Appointment testAppointment = new Appointment("10", appointmentDate, "Dentist");
		assertTrue(testAppointment.getAppointmentDescription().equals("Dentist"));
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testAppointment.setAppointmentDescription(null);
		});
	}
  
}
