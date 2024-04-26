package appointment;

import java.io.*;
import java.util.*;

import appointment.Appointment;

public class AppointmentService {
	
	private static Hashtable<String, Appointment> appointmentDatabase = new Hashtable<String, Appointment>();
	
	public void addAppointment(String appointmentID, Date appointmentDate, 
		String appointmentDescription) throws Exception {
		if (appointmentDatabase.get(appointmentID) != null)
			throw new Exception("appointmentID already in database");
		appointmentDatabase.put(appointmentID, new Appointment(appointmentID, 
			appointmentDate, appointmentDescription));
		
	}
	
	public void deleteAppointment(String appointmentID) throws Exception {
		Appointment toReturn = appointmentDatabase.get(appointmentID);
		if (toReturn == null)
			throw new Exception("appointmentID does not exist");
		appointmentDatabase.remove(appointmentID);
	}
	
	public Appointment getAppointment(String appointmentID) throws Exception {
		Appointment toReturn = appointmentDatabase.get(appointmentID);
		if (toReturn == null)
			throw new Exception("appointmentID does not exist");
		return toReturn;
	}

}
