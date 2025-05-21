package contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskTest {

	//Verifies that task gets created as intended
	@Test
	void testTask() 
	{
		Task task = new Task("TestID","TestName","TestDescription");
		assertTrue(task.getTaskID().equals("TestID"));
		assertTrue(task.getTaskName().equals("TestName"));
		assertTrue(task.getTaskDescription().equals("TestDescription"));
	}
	
	//Verifies When a task ID over 10 characters is entered throw occurs
	@Test 
	void testTaskIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{
			new Task("TestID12345","TestName","TestDescription");
		}); 
		}
	//Verifies When a task name over 20 characters is entered throw occurs	
	@Test 
	void testTaskNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{
			new Task("TestID","TestName1234567890123","TestDescription");
		}); 
		}
	//Verifies When a task description over 50 characters is entered throw occurs	
	@Test 
	void testTaskDescriptionTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{
			new Task("TestID","TestName","TestDescriptionTestDescriptionTestDescription123456");
		}); 
		}
	
	//Verifies When a task ID is null and entered throw occurs
	@Test 
	void testTaskIDNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{
			new Task(null,"TestName","TestDescription");
		}); 
		}
	//Verifies When a task name is null and entered throw occurs	
	@Test 
	void testTaskNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{
			new Task("TestID",null,"TestDescription");
		}); 
		}
	//Verifies When a task description is null and entered throw occurs	
	@Test 
	void testTaskDescriptionNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{
			new Task("TestID","TestName",null);
		}); 
		}
	
	//Test setters
	@Test
	void testSetTaskName(){
		Task task = new Task("TestID","TestName","TestDescription");
		String name = "TestName1";
		task.setTaskName(name);
		assertTrue(task.getTaskName().equals("TestName1"));
	}
	
	@Test
	void testSetTaskDescription(){
		Task task = new Task("TestID","TestName","TestDescription");
		String description = "TestDescription1";
		task.setTaskDescription(description);
		assertTrue(task.getTaskDescription().equals("TestDescription1"));	
	}
	
	//Test Getters
	@Test
	void testGetTaskID(){
		Task task = new Task("TestID","TestName","TestDescription");
		assertTrue(task.getTaskID().equals("TestID"));
	}

	@Test
	void testGetTaskName(){
		Task task = new Task("TestID","TestName","TestDescription");
		assertTrue(task.getTaskName().equals("TestName"));
	}
	
	@Test
	void testGetTaskDescription(){
		Task task = new Task("TestID","TestName","TestDescription");
		assertTrue(task.getTaskDescription().equals("TestDescription"));
	}
	
	//Tests When users enter in the max number of characters but not over in each field
	@Test
	void testMaxTaskID(){
		Task task = new Task("0123456789","TestName","TestDescription");
		assertTrue(task.getTaskID().equals("0123456789"));
	}
	
	@Test
	void testMaxTaskName(){
		Task task = new Task("TestID","01234567890123456789","TestDescription");
		assertTrue(task.getTaskName().equals("01234567890123456789"));
	}
	
	@Test
	void testMaxTaskDescription(){
		Task task = new Task("TestID","TestName","01234567890123456789012345678901234567890123456789");
		assertTrue(task.getTaskDescription().equals("01234567890123456789012345678901234567890123456789"));
	}
	
	//Tests When users enter in the min number of characters but not under in each field
	@Test
	void testMinTaskID(){
		Task task = new Task("1","TestName","TestDescription");
		assertTrue(task.getTaskID().equals("1"));
	}
	
	@Test
	void testMinTaskName(){
		Task task = new Task("TestID","1","TestDescription");
		assertTrue(task.getTaskName().equals("1"));
	}
	
	@Test
	void testMinTaskDescription(){
		Task task = new Task("TestID","TestName","1");
		assertTrue(task.getTaskDescription().equals("1"));
	}

}
