package appointment;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Appointment {
	
	private String appointmentID;
	private Date appointmentDate;
	private String appointmentDescription;
	
	private Calendar cdCalendar;
	
	public Appointment(String appointmentID, Date appointmentDate, String appointmentDescription) {
		if (appointmentID == null || appointmentID.length() > 10)
			throw new IllegalArgumentException("appointmentID is invalid");
		this.appointmentID = appointmentID;
		
		if (appointmentDescription == null || appointmentDescription.length() > 50)
			throw new IllegalArgumentException("appointmentDescription is invalid");
		this.appointmentDescription = appointmentDescription;
		
		cdCalendar = Calendar.getInstance();
		cdCalendar.set(Calendar.MONTH, LocalDate.now().getMonthValue());
		cdCalendar.set(Calendar.DATE, LocalDate.now().getDayOfMonth());
		cdCalendar.set(Calendar.YEAR, LocalDate.now().getYear());
		Date currentDate = cdCalendar.getTime();
		
		if (appointmentDate == null || appointmentDate.before(currentDate))
			throw new IllegalArgumentException("appointmentDate is invalid");
		this.appointmentDate = appointmentDate;
	}
	
	public String getAppointmentID() {
		return this.appointmentID;
	}
	
	public Date getAppointmentDate() {
		return this.appointmentDate;
	}
	
	/* Update (Apr. 11, 2024): From past experience with coding, I know that functions *should* return a value,
	 * it does not have to, but it is recommended. To improve code coverage via "assert*" methods, I have modified
	 * set* methods from void to boolean, and to return a "true" value if execution completed.
	 */
	public boolean setAppointmentDate(Date appointmentDate) {
		Date currentDate = cdCalendar.getTime();
		if (appointmentDate == null || appointmentDate.before(currentDate))
			throw new IllegalArgumentException("appointmentDate is invalid");
		this.appointmentDate = appointmentDate;
		return true;
	}
	
	public String getAppointmentDescription() {
		return this.appointmentDescription;
	}
	
	public void setAppointmentDescription(String description) {
		if (description == null || description.length() > 50)
			throw new IllegalArgumentException("description is invalid");
		this.appointmentDescription = description;
	}
}

/*
 * End notes:
 * 1. Retrieved on Apr. 3, 2024 from:
 *   https://w3schools.com/java/java_date.asp
 * 2. Retrieved on Apr. 3, 2024 from:
 *   https://docs.oracle.com/javase/8/docs/api/java/util/Date.html
 * 3. Retrieved on Apr. 3, 2024 from:
 *   https://stackoverflow.com/questions/12067697/convert-current-date-to-integer
 * 4. Retrieved on Apr. 4, 2024 from:
 *   https://www.linkedin.com/pulse/how-get-current-system-date-time-javaselenium-while-testing-u%C3%A7ar
 */