package contact;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AppointmentTest {

	//Verifies that Appointment works
	@Test
	void testAppointment() throws ParseException 
	{
		Appointment appointment = new Appointment("TestID", "10/20/24 08:00 PM" ,"TestDescription");
		assertTrue(appointment.getAppointmentID().equals("TestID"));
		assertTrue(appointment.getAppointmentDate().equals("10/20/24 08:00 PM"));
		assertTrue(appointment.getAppointmentDescription().equals("TestDescription"));
	}
	
	//Verifies When an Appointment ID over 10 characters is entered throw occurs
	@Test 
	void testAppointmentIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{
			new Appointment("TestID12345", "10/20/24 08:00 PM" ,"TestDescription");
		}); 
		}
	
	//Verifies When an Appointment Date before the current date is entered throw occurs
	@Test 
	void testAppointmentDateInThePast() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{
			new Appointment("TestID", "09/20/24 08:00 PM" ,"TestDescription");
		}); 
		}
	
	//Verifies When an Appointment Description over 50 characters is entered throw occurs
	@Test 
	void testAppointmentDescriptionTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{
			new Appointment("TestID", "10/20/24 08:00 PM" ,"TestDescriptionTestDescriptionTestDescription123456");
		}); 
		}
	
	//Verifies When a null Appointment ID is entered throw occurs
	@Test 
	void testAppointmentIDNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{
			new Appointment(null, "10/20/24 08:00 PM" ,"TestDescription");
		}); 
		}
	
	//Verifies When a null Appointment Date is entered throw occurs
	@Test 
	void testAppointmentDateNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{
			new Appointment("TestID", null ,"TestDescription");
		}); 
		}
	
	//Verifies When a null Appointment Description is entered throw occurs
	@Test 
	void testAppointmentDescriptionNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{
			new Appointment("TestID", "10/20/24 08:00 PM" ,null);
		}); 
		}
	
	//Tests for the setters
	@Test
	void testSetAppointmentDate() throws ParseException {
		Appointment appointment = new Appointment("TestID", "10/20/24 08:00 PM" ,"TestDescription");
		String appointmentDate = "10/20/24 09:00 PM";
		appointment.setAppointmentDate(appointmentDate);
		assertTrue(appointment.getAppointmentDate().equals("10/20/24 09:00 PM"));
	}
	
	@Test
	void testSetAppointmentDescription() throws ParseException {
		Appointment appointment = new Appointment("TestID", "10/20/24 08:00 PM" ,"TestDescription");
		String appointmentDescription = "TestDescription123";
		appointment.setAppointmentDescription(appointmentDescription);
		assertTrue(appointment.getAppointmentDescription().equals("TestDescription123"));

	}
	
	//Tests for Getters
	@Test
	void testGetAppointmentID() throws ParseException {
		Appointment appointment = new Appointment("TestID", "10/20/24 08:00 PM" ,"TestDescription");
		assertTrue(appointment.getAppointmentID().equals("TestID"));
	}
	
	@Test
	void testGetAppointmentDate() throws ParseException {
		Appointment appointment = new Appointment("TestID", "10/20/24 08:00 PM" ,"TestDescription");
		assertTrue(appointment.getAppointmentDate().equals("10/20/24 08:00 PM"));
	}
	
	@Test
	void testGetAppointmentDescription() throws ParseException {
		Appointment appointment = new Appointment("TestID", "10/20/24 08:00 PM" ,"TestDescription");
		assertTrue(appointment.getAppointmentDescription().equals("TestDescription"));
	}
	
	//Tests When users enter in the max number of characters but not over in appointment ID and Description
	@Test
	void testMaxAppointmentID() throws ParseException {
		Appointment appointment = new Appointment("0123456789", "10/20/24 08:00 PM" ,"TestDescription");
		assertTrue(appointment.getAppointmentID().equals("0123456789"));
	}
	
	@Test
	void testMaxAppointmentDescription() throws ParseException {
		Appointment appointment = new Appointment("TestID", "10/20/24 08:00 PM" ,"01234567890123456789012345678901234567890123456789");
		assertTrue(appointment.getAppointmentDescription().equals("01234567890123456789012345678901234567890123456789"));
	}
	
	//Tests When users enter in the min number of characters but not under in appointment ID and Description
	@Test
	void testMinAppointmentID() throws ParseException {
		Appointment appointment = new Appointment("1", "10/20/24 08:00 PM" ,"TestDescription");
		assertTrue(appointment.getAppointmentID().equals("1"));
	}
	
	@Test
	void testMinAppointmentDescription() throws ParseException {
		Appointment appointment = new Appointment("TestID", "10/20/24 08:00 PM" ,"1");
		assertTrue(appointment.getAppointmentDescription().equals("1"));
	}

}
