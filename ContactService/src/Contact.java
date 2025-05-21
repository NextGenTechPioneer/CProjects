package contact;

public class Contact {
	

	//defines required variables
	private String contactID;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	//creates contact object 
	public Contact(String contactID, String firstName, String lastName, String phoneNumber, String address) 
	{
		//if id is null or greater then 10 characters throw exception
	
		if(contactID == null || contactID.length()>10)
		{
			throw new IllegalArgumentException("Invalid Contact ID");
		}
		//if first name is null or greater then 10 characters throw exception
		if(firstName == null || firstName.length()>10)
		{
			throw new IllegalArgumentException("Invalid First Name");
		}
		//if last name is null or greater then 10 characters throw exception
		if(lastName == null || lastName.length()>10)
		{
			throw new IllegalArgumentException("Invalid Last Name");
		}
		//if phone number is null or not 10 characters throw exception
		if(phoneNumber == null || phoneNumber.length()!=10)
		{
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		//if address is null or greater then 30 characters throw exception
		if(address == null || address.length()>30)
		{
			throw new IllegalArgumentException("Invalid Adress");
		}
		
		//else no exceptions have been thrown assign variable
		this.contactID = contactID;
		this.firstName = firstName; 
		this.lastName = lastName;
		this.phoneNumber = phoneNumber; 
		this.address = address;
		
	}
	
	//getters
	public String getContactID() 
	{
		return contactID;
	}
	
	public String getFirstName() 
	{
		return firstName;
	}
	
	
	public String getLastName() 
	{
		return lastName;
	}
	
	
	public String getPhoneNumber() 
	{
		return phoneNumber;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	
  	//setters
  
	public void setFirstName(String newFirstName)
    {
      this.firstName = newFirstName;
    }
  
  	public void setLastName(String newLastName)
    {
      this.lastName = newLastName;
    }
  	
  	public void setPhoneNumber(String newPhoneNumber)
    {
      this.phoneNumber = newPhoneNumber;
    }
  	
  	public void setAddress(String newAddress)
    {
      this.address = newAddress;
    }
  
	

}
