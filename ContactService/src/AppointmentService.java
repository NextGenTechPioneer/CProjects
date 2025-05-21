package contact;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AppointmentService {
	
	//creates appointments list
	public List<Appointment> appointments = new ArrayList<>();
	
	//method to add appointments
	public void AddAppointmentUsingID(String appointmentID,String appointmentDate, String appointmentDescription, List<Appointment> appointments) throws ParseException
		{
			for (Appointment appointment : appointments)
			{
				//if the appointment id is already present throw exception
				if(appointment.getAppointmentID().equals(appointmentID))
				{
				throw new IllegalArgumentException("appointment ID is already present");
				}
			}
			//if the appointment id is not present add the appointment to the list
			appointments.add(new Appointment(appointmentID, appointmentDate, appointmentDescription));
		}
	
	//method to delete appointments
	public void DeleteAppointmentUsingID(String appointmentID, List<Appointment> appointments )
		{
		//variable to determine if the ID is present
		boolean IDisPresent = false;
		//to iterate through the appointments list
		Iterator<Appointment> iterator = appointments.iterator();
		while(iterator.hasNext())
			{
				Appointment appointment = iterator.next();
				//if the appointment id is present delete it and turn id is present to true
				if (appointment.getAppointmentID().equals(appointmentID))
					{
						iterator.remove();
						IDisPresent = true;
					}
			}
				//if the appointment id is not present throw exception
				if (IDisPresent == false)
					{
						throw new IllegalArgumentException("Appointment ID is not present");
					}
		}

}
