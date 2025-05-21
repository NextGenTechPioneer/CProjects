package contact;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContactService 
{

	//creates contacts list
	public List<Contact> Contacts = new ArrayList<>();
  
  
	//method to add contact
	public void AddContactUsingID(String ContactID,String firstName, String lastName, String phoneNumber, String address, List<Contact> Contacts)
		{
			for (Contact contact : Contacts)
			{
				//if the contact id is already present throw exception
				if(contact.getContactID().equals(ContactID))
				{
				throw new IllegalArgumentException("Contact ID is already present");
				}
			}
			//if the contact id is not present add the new contact
			Contacts.add(new Contact(ContactID, firstName, lastName, phoneNumber, address));
		}
	
	//method to delete contact
	public void DeleteUsingID(String ContactID, List<Contact> Contacts) 
		{
		//variable to determine if the ID is present
		boolean IDisPresent = false;
		Iterator<Contact> iterator = Contacts.iterator();
		while(iterator.hasNext())
			{
				Contact contact = iterator.next();
				//if the contact id is present delete it
				if (contact.getContactID().equals(ContactID))
					{
						iterator.remove();
						IDisPresent = true;
					}
			}
				//if the contact id is not present throw exception
				if (IDisPresent == false)
					{
						throw new IllegalArgumentException("Contact ID is not present");
					}
		}
	

	//method to update existing contact
	public void UpdateContactUsingID(String ContactID,String firstName, String lastName, String phoneNumber, String address, List<Contact> Contacts)
		{
		//variable to determine if the ID is present
		boolean IDisPresent = false;
			for (Contact contact : Contacts)
				{
					//if the contact ID is present update first name, last name, phone number, and address
					if(contact.getContactID().equals(ContactID))
						{
							IDisPresent = true;
							contact.setFirstName(firstName);
							contact.setLastName(lastName);
							contact.setPhoneNumber(phoneNumber);
							contact.setAddress(address);
						}
				}
					//if the contact ID is not present throw exception
					if (IDisPresent == false)
					{
						throw new IllegalArgumentException("Invalid Contact ID");
					}
		}
}