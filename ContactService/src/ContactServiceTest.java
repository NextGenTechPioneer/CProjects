package contact;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ContactServiceTest {
	
	private String contactID;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	


	//tests the add contact method
	@Test
	void testAddContactUsingID() 
	{
		ContactService service = new ContactService();
		List<Contact> Contacts = new ArrayList<>();
		//contact information
		contactID = "10";
		firstName = "test";
		lastName = "test";
		phoneNumber = "1234567890";
		address = "test";
		service.AddContactUsingID(contactID, firstName, lastName, phoneNumber, address, Contacts);
		
		//variable to determine if the contact id was added to the lists
      	boolean IDisPresent = false;
      	//search through list
      	for (Contact contact : Contacts)
			{	
      			//if the id is present set the boolean to true
				if(contact.getContactID().equals(contactID))
				{
					IDisPresent = true;
				}
			}
      	//asserts that the boolean value is true
  		assertTrue(IDisPresent);
	}
	
	
	//tests the add contact method
	@Test
	void testAddMultipleContactsUsingID() 
	{
		ContactService service = new ContactService();
		List<Contact> Contacts = new ArrayList<>();
		//contact information
		contactID = "10";
		firstName = "test";
		lastName = "test";
		phoneNumber = "1234567890";
		address = "test";
		service.AddContactUsingID(contactID, firstName, lastName, phoneNumber, address, Contacts);
		
		//variable to determine if the contact id was added to the lists
      	boolean IDisPresent = false;
      	//search through list
      	for (Contact contact : Contacts)
			{	
      			//if the id is present set the boolean to true
				if(contact.getContactID().equals(contactID))
				{
					IDisPresent = true;
				}
			}
      	//asserts that the boolean value is true
  		assertTrue(IDisPresent);
  		//reset boolean
  		IDisPresent = false;
		//contact information
		contactID = "11";
		firstName = "test";
		lastName = "test";
		phoneNumber = "1234567890";
		address = "test";
		service.AddContactUsingID(contactID, firstName, lastName, phoneNumber, address, Contacts);
      	for (Contact contact : Contacts)
			{	
      			//if the id is present set the boolean to true
				if(contact.getContactID().equals(contactID))
				{
					IDisPresent = true;
				}
			}
      	assertTrue(IDisPresent);
  		
	}
	
	
	@Test
	void testDeleteUsingID() 
	{
		ContactService service = new ContactService();
		List<Contact> Contacts = new ArrayList<>();
		
		//contact information
		contactID = "10";
		firstName = "test";
		lastName = "test";
		phoneNumber = "1234567890";
		address = "test";
		
		//add new contact
		Contacts.add(new Contact(contactID, firstName, lastName, phoneNumber, address));
		
		//variable to determine if the contact id was added to the lists
      	boolean IDisPresent = false;
      	service.DeleteUsingID(contactID, Contacts);
      	//search through list
      	for (Contact contact : Contacts)
			{	
      			//if the id is present set the boolean to true
				if(contact.getContactID().equals(contactID))
				{
					IDisPresent = true;
				}
			}
      	//asserts that the boolean value is false
  		assertFalse(IDisPresent);
	}
	
	@Test
	void testDeleteUsingIDMultipleContacts() 
	{
		ContactService service = new ContactService();
		List<Contact> Contacts = new ArrayList<>();
		
		//contact information
		contactID = "10";
		firstName = "test";
		lastName = "test";
		phoneNumber = "1234567890";
		address = "test";
		
		//add new contact
		Contacts.add(new Contact(contactID, firstName, lastName, phoneNumber, address));
		
		//variable to determine if the contact id was added to the lists
      	boolean IDisPresent = false;
	    //search through contacts list
	    for (Contact contact : Contacts)
			{	
	      		//if the id is present set the boolean to true
				if(contact.getContactID().equals(contactID))
				{
					IDisPresent = true;
				}
			}
	    assertTrue (IDisPresent);
	    //reset boolean 
	    IDisPresent = false;
      	service.DeleteUsingID(contactID, Contacts);
      	//search through list
      	for (Contact contact : Contacts)
			{	
      			//if the id is present set the boolean to true
				if(contact.getContactID().equals(contactID))
				{
					IDisPresent = true;
				}
			}
      	//asserts that the boolean value is false
  		assertFalse(IDisPresent);
  		//reset boolean 
  		IDisPresent = false;
		
  		
		//contact information
		contactID = "11";
		firstName = "test1";
		lastName = "test1";
		phoneNumber = "0234567890";
		address = "test1";
		
		//add new contact
		Contacts.add(new Contact(contactID, firstName, lastName, phoneNumber, address));
	    //search through contacts list
	    for (Contact contact : Contacts)
			{	
	      		//if the id is present set the boolean to true
				if(contact.getContactID().equals(contactID))
				{
					IDisPresent = true;
				}
			}
	    assertTrue (IDisPresent);
	    //reset boolean 
	    IDisPresent = false;
      	service.DeleteUsingID(contactID, Contacts);
      	//search through list
      	for (Contact contact : Contacts)
			{	
      			//if the id is present set the boolean to true
				if(contact.getContactID().equals(contactID))
				{
					IDisPresent = true;
				}
			}
      	//asserts that the boolean value is false
  		assertFalse(IDisPresent);
	}
	//tests the update contact method
	@Test
	void testUpdateContactUsingID() 
	{
		ContactService service = new ContactService();
		List<Contact> Contacts = new ArrayList<>();
	
		//contact information
		contactID = "10";
		firstName = "test";
		lastName = "test";
		phoneNumber = "1234567890";
		address = "test";
		
		//add new contact
		Contacts.add(new Contact(contactID, "123", "123", "1231231231", "123"));
		//use method
      	service.UpdateContactUsingID(contactID, firstName, lastName, phoneNumber, address, Contacts);
      	//search through list
      	for (Contact contact : Contacts)
			{	
      			//if the id is present 
				if(contact.getContactID().equals(contactID))
				{
					//check to make sure each aspect is equal to the info we updated
					assertEquals("test", contact.getFirstName());
					assertEquals("test", contact.getLastName());
					assertEquals("1234567890", contact.getPhoneNumber());
					assertEquals("test", contact.getAddress());
				}
			}
	}

	//asserts that when ID is already in the list error occurs when trying to add contact
	@Test 
	void testAddContactUsingIDWhenIDisPresent() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{
			ContactService service = new ContactService();
			List<Contact> Contacts = new ArrayList<>();
			//contact information
			contactID = "10";
			firstName = "test";
			lastName = "test";
			phoneNumber = "1234567890";
			address = "test";
			Contacts.add(new Contact("10", "test", "test", "1234567890", "test"));
			service.AddContactUsingID(contactID, firstName, lastName, phoneNumber, address, Contacts);
			
		});
	}

	//asserts that when ID is not in the list error occurs when trying to delete contact
	@Test 
	void testDeleteUsingIDWhenIDisNotPresent() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{
			//contact info
			contactID = "10";
			firstName = "test";
			lastName = "test";
			phoneNumber = "1234567890";
			address = "test";
			
			ContactService service = new ContactService();
			List<Contact> Contacts = new ArrayList<>();
			service.DeleteUsingID(contactID, Contacts);
			
		});
	}
	
	//asserts that when ID is not present error occurs when trying to update contact
	@Test 
	void testUpdateWhenIDisNotPresent() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{
			//contact info
			contactID = "10";
			firstName = "test";
			lastName = "test";
			phoneNumber = "1234567890";
			address = "test";
			
			ContactService service = new ContactService();
			List<Contact> Contacts = new ArrayList<>();
			service.UpdateContactUsingID(contactID, firstName, lastName, phoneNumber, address, Contacts);
		});
	}
	
	//verifies error occurs when trying to update a contact ID
	@Test 
	void testTryingToUpdateContactID() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{
			ContactService service = new ContactService();
			List<Contact> Contacts = new ArrayList<>();
			//creates contact with the ID of 11
			Contacts.add(new Contact("11", "test1", "test1", "2234567890", "test1"));
			
			//contact info trying to be entered with an ID of 10
			contactID = "10";
			firstName = "test";
			lastName = "test";
			phoneNumber = "1234567890";
			address = "test";
			

			//trying to use a new ID when updating
			service.UpdateContactUsingID(contactID, firstName, lastName, phoneNumber, address, Contacts);
		});
	}
}
