package contact;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AppointmentServiceTest {

	private String appointmentID;
	private String appointmentDate;
	private String appointmentDescription;
	
	//tests the add appointment method
	@Test
	void testAddAppointmentUsingID() throws ParseException 
	{
		AppointmentService service = new AppointmentService();
		List<Appointment> appointments = new ArrayList<>();
		
		//appointment information
		appointmentID = "10";
		appointmentDate = "10/20/24 08:00 PM";
		appointmentDescription = "test description";
		
		//use the add appointment method
		service.AddAppointmentUsingID(appointmentID, appointmentDate, appointmentDescription, appointments);
		
		//variable to determine if the appointment id was added to the lists
      	boolean IDisPresent = false;
      	//search through appointments list
      	for (Appointment appointment : appointments)
			{	
      			//if the id is present set the boolean to true
				if(appointment.getAppointmentID().equals(appointmentID))
				{
					IDisPresent = true;
				}
			}
      	//asserts that the boolean value is true
  		assertTrue(IDisPresent);
	}

	
	//tests the add appointment method when adding multiple appointments
	@Test
	void testAddAppointmentUsingIDMultipleAppointments() throws ParseException 
	{
		AppointmentService service = new AppointmentService();
		List<Appointment> appointments = new ArrayList<>();
		
		//appointment information
		appointmentID = "10";
		appointmentDate = "10/20/24 08:00 PM";
		appointmentDescription = "test description";
		
		//use the add appointment method
		service.AddAppointmentUsingID(appointmentID, appointmentDate, appointmentDescription, appointments);
		
		//variable to determine if the appointment id was added to the lists
      	boolean IDisPresent = false;
      	//search through appointments list
      	for (Appointment appointment : appointments)
			{	
      			//if the id is present set the boolean to true
				if(appointment.getAppointmentID().equals(appointmentID))
				{
					IDisPresent = true;
				}
			}
      	//asserts that the boolean value is true
  		assertTrue(IDisPresent);
  		
		//new appointment information
		appointmentID = "11";
		appointmentDate = "10/20/24 09:00 PM";
		appointmentDescription = "test description";
		
		//use the add appointment method
		service.AddAppointmentUsingID(appointmentID, appointmentDate, appointmentDescription, appointments);
		
		//variable to determine if the appointment id was added to the lists, needs to be reset
      	IDisPresent = false;
      	//search through appointments list
      	for (Appointment appointment : appointments)
			{	
      			//if the id is present set the boolean to true
				if(appointment.getAppointmentID().equals(appointmentID))
				{
					IDisPresent = true;
				}
			}
      	//asserts that the boolean value is true
  		assertTrue(IDisPresent);
	}
	
	//tests to make sure delete appointment using ID method deletes the appointment
	@Test
	void testDeleteAppointmentUsingID() throws ParseException 
	{
		AppointmentService service = new AppointmentService();
		List<Appointment> appointments = new ArrayList<>();
		
		//appointment information
		appointmentID = "10";
		appointmentDate = "10/20/24 08:00 PM";
		appointmentDescription = "test description";
		
		//use the add appointment method
		service.AddAppointmentUsingID(appointmentID, appointmentDate, appointmentDescription, appointments);
		
		//variable to determine if the appointment id was added to the lists
      	boolean IDisPresent = false;
      	//search through appointments list
      	for (Appointment appointment : appointments)
			{	
      			//if the id is present set the boolean to true
				if(appointment.getAppointmentID().equals(appointmentID))
				{
					IDisPresent = true;
				}
			}
      	//asserts that the boolean value is true makes sure the appointment was added to the list
  		assertTrue(IDisPresent);
  		
	  	//Use delete appointment method
	  	service.DeleteAppointmentUsingID(appointmentID, appointments);
	  		
	  	//check to see if ID is present again, reset the boolean 
	  	IDisPresent = false;
		   for (Appointment appointment : appointments)
			{	
		      	//if the id is present set the boolean to true
				if(appointment.getAppointmentID().equals(appointmentID))
				{
					IDisPresent = true;
				}
			}
		    //asserts that the boolean value is false
		  	assertFalse(IDisPresent);
	  		
	}

	//tests to make sure delete appointment using ID method deletes the appointment
	@Test
	void testDeleteMultipleAppointmentUsingID() throws ParseException 
	{
		AppointmentService service = new AppointmentService();
		List<Appointment> appointments = new ArrayList<>();
		
		//appointment information
		appointmentID = "10";
		appointmentDate = "10/20/24 08:00 PM";
		appointmentDescription = "test description";
		
		//use the add appointment method
		service.AddAppointmentUsingID(appointmentID, appointmentDate, appointmentDescription, appointments);
		
		//variable to determine if the appointment id was added to the lists
      	boolean IDisPresent = false;
      	//search through appointments list
      	for (Appointment appointment : appointments)
			{	
      			//if the id is present set the boolean to true
				if(appointment.getAppointmentID().equals(appointmentID))
				{
					IDisPresent = true;
				}
			}
      	//check appointment is present
      	assertTrue(IDisPresent);
	  	//Use delete appointment method
	  	service.DeleteAppointmentUsingID(appointmentID, appointments);
	  		
	  	//check to see if ID is present again, reset the boolean 
	  	IDisPresent = false;
		   for (Appointment appointment : appointments)
			{	
		      	//if the id is present set the boolean to true
				if(appointment.getAppointmentID().equals(appointmentID))
				{
					IDisPresent = true;
				}
			}
		    //asserts that the boolean value is false
		  	assertFalse(IDisPresent);
	  		
			//appointment2 information
			appointmentID = "11";
			appointmentDate = "10/20/24 09:00 PM";
			appointmentDescription = "test description1";
			
			//use the add appointment method
			service.AddAppointmentUsingID(appointmentID, appointmentDate, appointmentDescription, appointments);
			
			//variable to determine if the appointment id was added to the lists
	      	IDisPresent = false;
	      	//search through appointments list
	      	for (Appointment appointment : appointments)
				{	
	      			//if the id is present set the boolean to true
					if(appointment.getAppointmentID().equals(appointmentID))
					{
						IDisPresent = true;
					}
				}
	      	//check appointment is present
	      	assertTrue(IDisPresent);
		  	//Use delete appointment method
		  	service.DeleteAppointmentUsingID(appointmentID, appointments);
		  		
		  	//check to see if ID is present again, reset the boolean 
		  	IDisPresent = false;
			   for (Appointment appointment : appointments)
				{	
			      	//if the id is present set the boolean to true
					if(appointment.getAppointmentID().equals(appointmentID))
					{
						IDisPresent = true;
					}
				}
			    //asserts that the boolean value is false
			  	assertFalse(IDisPresent);
		  		
	}
	
	//asserts that when ID is already in the list error occurs when trying to add appointment with the same ID
	@Test 
	void testAddAppointmentUsingIDWhenIDisPresent() 
	{
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{
			AppointmentService service = new AppointmentService();
			List<Appointment> appointments = new ArrayList<>();
			
			//our new appointment information
			appointmentID = "10";
			appointmentDate = "10/20/24 08:00 PM";
			appointmentDescription = "test description";
			
			//add an appointment
			appointments.add(new Appointment("10", "11/14/24 05:00 PM", "test"));
			//try to use method to add a new appointment with the same id
			service.AddAppointmentUsingID(appointmentID, appointmentDate, appointmentDescription, appointments);
		});
	}
	
	//asserts that when ID is not in the list error occurs when trying to delete that appointment
	@Test 
	void testDeleteAppointmentUsingIDWhenIDisNotPresent() 
	{
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{
			AppointmentService service = new AppointmentService();
			List<Appointment> appointments = new ArrayList<>();
			//add an appointment with the id of 15 so that is the only appointment present in the list
			appointments.add(new Appointment("15", "11/14/24 05:00 PM", "test"));
			
			//the appointment id we are searching for 10 not 15
			appointmentID = "10";
			//use delete method
			service.DeleteAppointmentUsingID(appointmentID, appointments);
			
		});
	}
	
	
	
}
