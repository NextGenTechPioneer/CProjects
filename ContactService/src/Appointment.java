package contact;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Appointment {

	//defines required variables
	private String appointmentID;
	private String appointmentDate;
	private String AppointmentDescription;
	
	
	Date currentDate = new Date();

	//creates Appointment object 
	public Appointment(String appointmentID, String appointmentDate, String AppointmentDescription) throws ParseException 
	{

		//if id is null or greater then 10 characters throw exception
		if(appointmentID == null || appointmentID.length()>10)
		{
			throw new IllegalArgumentException("Invalid Appointment ID");
		}
		
		//if the appointment date is null throw error
		if(appointmentDate == null)
		{
			throw new IllegalArgumentException("Invalid Appointment Date");
		}
		
		//define the date format using month day year hours minutes am or pm
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy hh:mm a");
		//format the appointment date string entered
		Date formatedAppointmentDate = dateFormat.parse(appointmentDate);
		
		//if the appointment date is before the current date throw error
		if(formatedAppointmentDate.before(new Date()))
		{
			throw new IllegalArgumentException("Invalid Appointment Date");
		}
		
		//if the Appointment Description is null or greater then 50 characters throw exception
		if(AppointmentDescription == null || AppointmentDescription.length()>50)
		{
			throw new IllegalArgumentException("Invalid Description");
		}
		
		//else no exceptions have been thrown assign variable
		this.appointmentID = appointmentID;
		this.appointmentDate = appointmentDate; 
		this.AppointmentDescription = AppointmentDescription;
		
	}
	
	//getters
	public String getAppointmentID() 
	{
		return appointmentID;
	}
	
	public String getAppointmentDate() 
	{
		return appointmentDate;
	}
	
	
	public String getAppointmentDescription() 
	{
		return AppointmentDescription;
	}
	
	
  	//setters
  
	public void setAppointmentDate(String newAppointmentDate)
    {
      this.appointmentDate = newAppointmentDate;
    }
  
  	public void setAppointmentDescription(String newAppointmentDescription)
    {
      this.AppointmentDescription = newAppointmentDescription;
    }
  	
	
}
