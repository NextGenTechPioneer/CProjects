package contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactTest {
	//Verifies that contact works
	@Test
	void testContact() 
	{
		Contact contact = new Contact("TestID","TestName","TestName","0123456789","Test Address");
		assertTrue(contact.getContactID().equals("TestID"));
		assertTrue(contact.getFirstName().equals("TestName"));
		assertTrue(contact.getLastName().equals("TestName"));
		assertTrue(contact.getPhoneNumber().equals("0123456789"));
		assertTrue(contact.getAddress().equals("Test Address"));
	}
	
	
	//Verifies When a contact ID over 10 characters is entered throw occurs
	@Test 
	void testContactIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{
			new Contact("TestID12345","TestName","TestName","0123456789","Test Address");
		}); 
		}
	//Verifies When a contact First Name over 10 characters is entered throw occurs	
	@Test 
	void testContactFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{
			new Contact("TestID","TestName123","TestName","0123456789","Test Address");
		}); 
		}
	//Verifies When a contact Last Name over 10 characters is entered throw occurs	
	@Test 
	void testContactLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{
			new Contact("TestID","TestName","TestName123","0123456789","Test Address");
		}); 
		}
	//Verifies that when a phone number not equal to 10 is entered throw occurs
	@Test 
	void testContactPhoneNumberNot10() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{
			new Contact("TestID","TestName","TestName","0","Test Address");
		}); 
		}
	//Verifies that when a contact address is entered that is longer than 30 characters exception is thrown
	@Test 
	void testContactAdressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{
			new Contact("TestID","TestName","TestName","0123456789","Test AddressTest AddressTest Ad");
		}); 
		}
	
	
	
	//Verifies that when null is entered for contact ID exception is thrown 
	@Test 
	void testContactIDNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{
			new Contact(null,"TestName","TestName","0123456789","Test Address");
		}); 
		}
	//Verifies that when null is entered for contact first name exception is thrown
	@Test 
	void testContactFirstNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{
			new Contact("TestID",null,"TestName","0123456789","Test Address");
		}); 
		}
	//Verifies that when null is entered for contact last name exception is thrown
	@Test 
	void testContactLastNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{
			new Contact("TestID","TestName",null,"0123456789","Test Address");
		}); 
		}
	//Verifies that when null is entered for contact phone number  exception is thrown
	@Test 
	void testContactPhoneNumberNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{
			new Contact("TestID","TestName","TestName",null,"Test Address");
		}); 
		}
	//Verifies that when null is entered for contact address exception is thrown
	@Test 
	void testContactAdressNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{
			new Contact("TestID","TestName","TestName","0123456789",null);
		}); 
		}

	//Tests Setters
	@Test
	void testSetContactFirstName() {
		Contact contact = new Contact("TestID","TestName","TestName","0123456789","Test Address");
		String firstName = "TestName1";
		contact.setFirstName(firstName);
		assertTrue(contact.getFirstName().equals("TestName1"));
	}

	@Test
	void testSetContactLastName() {
		Contact contact = new Contact("TestID","TestName","TestName","0123456789","Test Address");
		String lastName = "TestName1";
		contact.setLastName(lastName);
		assertTrue(contact.getLastName().equals("TestName1"));
	}
	@Test
	void testSetContactPhoneNumber() {
		Contact contact = new Contact("TestID","TestName","TestName","0123456789","Test Address");
		String phoneNumber = "1123456789";
		contact.setPhoneNumber(phoneNumber);
		assertTrue(contact.getPhoneNumber().equals("1123456789"));
	}
	@Test
	void testSetContactAddress() {
		Contact contact = new Contact("TestID","TestName","TestName","0123456789","Test Address");
		String address = "Test Address1";
		contact.setAddress(address);
		assertTrue(contact.getAddress().equals("Test Address1"));	
	}
	
	//Tests Getters
	@Test
	void testGetContactFirstName() {
		Contact contact = new Contact("TestID","TestName","TestName","0123456789","Test Address");
		assertTrue(contact.getFirstName().equals("TestName"));
	}

	@Test
	void testGetContactLastName() {
		Contact contact = new Contact("TestID","TestName","TestName","0123456789","Test Address");
		assertTrue(contact.getLastName().equals("TestName"));
	}
	@Test
	void testGetContactPhoneNumber() {
		Contact contact = new Contact("TestID","TestName","TestName","0123456789","Test Address");
		assertTrue(contact.getPhoneNumber().equals("0123456789"));
	}
	@Test
	void testGetContactAddress() {
		Contact contact = new Contact("TestID","TestName","TestName","0123456789","Test Address");
		assertTrue(contact.getAddress().equals("Test Address"));	
	}
	
	//Tests When users enter in the max number of characters but not over in each field
	@Test
	void testMaxContactID() 
	{
		Contact contact = new Contact("TestID1234","TestName","TestName","0123456789","Test Address");
		assertTrue(contact.getContactID().equals("TestID1234"));
	}
	
	@Test
	void testMaxContactFirstName() 
	{
		Contact contact = new Contact("TestID","TestName12","TestName","0123456789","Test Address");
		assertTrue(contact.getFirstName().equals("TestName12"));
	}
	
	@Test
	void testMaxContactLastName() 
	{
		Contact contact = new Contact("TestID","TestName","TestName12","0123456789","Test Address");
		assertTrue(contact.getLastName().equals("TestName12"));
	}
	
	@Test
	void testMaxPhoneNumber() 
	{
		Contact contact = new Contact("TestID","TestName","TestName","0123456789","Test Address");
		assertTrue(contact.getPhoneNumber().equals("0123456789"));
	}
	@Test
	void testMaxAddress() 
	{
		Contact contact = new Contact("TestID","TestName","TestName","0123456789","012345678901234567890123456789");
		assertTrue(contact.getAddress().equals("012345678901234567890123456789"));
	}
	
	//Tests When users enter the min number of characters but not below in each field
	@Test
	void testMinContactID() 
	{
		Contact contact = new Contact("1","TestName","TestName","0123456789","Test Address");
		assertTrue(contact.getContactID().equals("1"));
	}
	
	@Test
	void testMinContactFirstName() 
	{
		Contact contact = new Contact("TestID","1","TestName","0123456789","Test Address");
		assertTrue(contact.getFirstName().equals("1"));
	}
	
	@Test
	void testMinContactLastName() 
	{
		Contact contact = new Contact("TestID","TestName","1","0123456789","Test Address");
		assertTrue(contact.getLastName().equals("1"));
	}
	
	@Test
	void testMinPhoneNumber() 
	{
		Contact contact = new Contact("TestID","TestName","TestName","0123456789","Test Address");
		assertTrue(contact.getPhoneNumber().equals("0123456789"));
	}
	@Test
	void testMinAddress() 
	{
		Contact contact = new Contact("TestID","TestName","TestName","0123456789","1");
		assertTrue(contact.getAddress().equals("1"));
	}
	
}
