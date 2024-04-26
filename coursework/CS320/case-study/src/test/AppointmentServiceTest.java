package test;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;

import appointment.Appointment;
import appointment.AppointmentService;

class AppointmentServiceTest {
	
	private Date calculateAppointmentDate(int month, int date, int year) {
		Calendar apCalendar = Calendar.getInstance();
		apCalendar.set(Calendar.MONTH, month);
		apCalendar.set(Calendar.DATE, date);
		apCalendar.set(Calendar.YEAR, year);
		return apCalendar.getTime();
	}
	
	AppointmentService appointmentService;
	
	@BeforeEach
	void initialize() {
		appointmentService = new AppointmentService();
	}

	@Test
	void testAddAppointment() throws Exception {
		Date appointmentDate = calculateAppointmentDate(1, 1, 2025);
		appointmentService.addAppointment("1", appointmentDate, "Dentist");
		Appointment testAppointment = appointmentService.getAppointment("1");
		assertTrue(testAppointment.getAppointmentID().equals("1"));
		assertTrue(testAppointment.getAppointmentDate().equals(appointmentDate));
		assertTrue(testAppointment.getAppointmentDescription().equals("Dentist"));
	}
	
	@Test
	void testAddAppointmentIsIDDuplicate() throws Exception {
		Date appointmentDate = calculateAppointmentDate(1, 1, 2025);
		appointmentService.addAppointment("2", appointmentDate, "Dentist");
		Appointment testAppointment = appointmentService.getAppointment("2");
		assertTrue(testAppointment.getAppointmentID().equals("2"));
		assertTrue(testAppointment.getAppointmentDate().equals(appointmentDate));
		assertTrue(testAppointment.getAppointmentDescription().equals("Dentist"));
		
		Assertions.assertThrows(Exception.class, () -> {
			appointmentService.addAppointment("2", appointmentDate, "Dentist");
		});
	}
	
	@Test
	void testDeleteAppointment() throws Exception {
		Date appointmentDate = calculateAppointmentDate(1, 1, 2025);
		appointmentService.addAppointment("3", appointmentDate, "More Dentists");
		appointmentService.deleteAppointment("3");
	}

	@Test
	void testDeleteAppointmentIsIDNotExistant() throws Exception {
		Assertions.assertThrows(Exception.class, () -> {
			appointmentService.deleteAppointment("9001");
		});
	}
	
	@Test
	void testGetAppointmentIsReturnNull() throws Exception {
		Assertions.assertThrows(Exception.class, () -> {
			appointmentService.getAppointment("9002");
		});
	}
}
