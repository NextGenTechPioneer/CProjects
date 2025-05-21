package contact;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskServiceTest {


	private String taskID;
	private String taskName;
	private String taskDescription;
	
	//tests the add task method
	@Test
	void testAddTaskUsingID() 
	{
		TaskService service = new TaskService();
		List<Task> tasks = new ArrayList<>();
		
		//task information
		taskID = "10";
		taskName = "test";
		taskDescription = "test";
		
		//use the add task method
		service.AddTaskUsingID(taskID, taskName, taskDescription, tasks);
		
		//variable to determine if the task id was added to the lists
      	boolean IDisPresent = false;
      	//search through tasks list
      	for (Task task : tasks)
			{	
      			//if the id is present set the boolean to true
				if(task.getTaskID().equals(taskID))
				{
					IDisPresent = true;
				}
			}
      	//asserts that the boolean value is true
  		assertTrue(IDisPresent);
	}
	
	
	//tests the add task method when adding in multiple tasks
	@Test
	void testAddTaskUsingIDMultipleTasks() 
	{
		TaskService service = new TaskService();
		List<Task> tasks = new ArrayList<>();
		
		//task information
		taskID = "10";
		taskName = "test";
		taskDescription = "test";
		
		//use the add task method
		service.AddTaskUsingID(taskID, taskName, taskDescription, tasks);
		
		//variable to determine if the task id was added to the lists
      	boolean IDisPresent = false;
      	//search through tasks list
      	for (Task task : tasks)
			{	
      			//if the id is present set the boolean to true
				if(task.getTaskID().equals(taskID))
				{
					IDisPresent = true;
				}
			}
      	//asserts that the boolean value is true
  		assertTrue(IDisPresent);
  		
		//new task information
		taskID = "11";
		taskName = "test";
		taskDescription = "test";
		
		//use the add task method
		service.AddTaskUsingID(taskID, taskName, taskDescription, tasks);
		
		//variable to determine if the task id was added to the lists
      	IDisPresent = false;
      	//search through tasks list
      	for (Task task : tasks)
			{	
      			//if the id is present set the boolean to true
				if(task.getTaskID().equals(taskID))
				{
					IDisPresent = true;
				}
			}
      	//asserts that the boolean value is true
  		assertTrue(IDisPresent);
	}
	
	//tests to make sure delete method deletes the task
	@Test
	void testDeleteTaskUsingID() 
	{
		TaskService service = new TaskService();
		List<Task> tasks = new ArrayList<>();
		
		//task information
		taskID = "10";
		taskName = "test";
		taskDescription = "test";
		
		service.AddTaskUsingID(taskID, taskName, taskDescription, tasks);
		//variable to determine if the task id was added to the lists
	    boolean IDisPresent = false;
	    //search through tasks list
	    for (Task task : tasks)
			{	
	      		//if the id is present set the boolean to true
				if(task.getTaskID().equals(taskID))
				{
					IDisPresent = true;
				}
			}
	      	//asserts that the boolean value is true
	  		assertTrue(IDisPresent);
	  		//Use delete task method
	  		service.DeleteTaskUsingID(taskID, tasks);
	  		
	  		//check to see if ID is present again, reset the boolean 
	  		IDisPresent = false;
		    for (Task task : tasks)
				{	
		      		//if the id is present set the boolean to true
					if(task.getTaskID().equals(taskID))
					{
						IDisPresent = true;
					}
				}
		      	//asserts that the boolean value is false
		  		assertFalse(IDisPresent);
	  		
	}
	
	@Test
	void testDeleteTaskUsingIDMultipleTasks() 
	{
		TaskService service = new TaskService();
		List<Task> tasks = new ArrayList<>();
		
		//task information
		taskID = "10";
		taskName = "test";
		taskDescription = "test";
		
		service.AddTaskUsingID(taskID, taskName, taskDescription, tasks);
		//variable to determine if the task id was added to the lists
	    boolean IDisPresent = false;
	    //search through tasks list
	    for (Task task : tasks)
			{	
	      		//if the id is present set the boolean to true
				if(task.getTaskID().equals(taskID))
				{
					IDisPresent = true;
				}
			}
	      	//asserts that the boolean value is true
	  		assertTrue(IDisPresent);
	  		//Use delete task method
	  		service.DeleteTaskUsingID(taskID, tasks);
	  		
	  		//check to see if ID is present again, reset the boolean 
	  		IDisPresent = false;
		    for (Task task : tasks)
				{	
		      		//if the id is present set the boolean to true
					if(task.getTaskID().equals(taskID))
					{
						IDisPresent = true;
					}
				}
		      	//asserts that the boolean value is false
		  		assertFalse(IDisPresent);
		  		//reset boolean 
		  		IDisPresent = false;
				//task information
				taskID = "11";
				taskName = "test1";
				taskDescription = "test1";
				
				service.AddTaskUsingID(taskID, taskName, taskDescription, tasks);
			    //search through tasks list
			    for (Task task : tasks)
					{	
			      		//if the id is present set the boolean to true
						if(task.getTaskID().equals(taskID))
						{
							IDisPresent = true;
						}
					}
			      	//asserts that the boolean value is true
			  		assertTrue(IDisPresent);
			  		//Use delete task method
			  		service.DeleteTaskUsingID(taskID, tasks);
			  		
			  		//check to see if ID is present again, reset the boolean 
			  		IDisPresent = false;
				    for (Task task : tasks)
						{	
				      		//if the id is present set the boolean to true
							if(task.getTaskID().equals(taskID))
							{
								IDisPresent = true;
							}
						}
				      	//asserts that the boolean value is false
				  		assertFalse(IDisPresent);
		  		
	  		
	}
	
	//tests the update task using ID method
	@Test
	void testUpdateTaskUsingID() 
	{
		TaskService service = new TaskService();
		List<Task> tasks = new ArrayList<>();
		
		//task information
		taskID = "10";
		taskName = "test";
		taskDescription = "test";
		
		//add new task
		tasks.add(new Task(taskID, "123", "123"));
		//use update task method
      	service.UpdateTaskUsingID(taskID, taskName, taskDescription, tasks);
      	//search through tasks list
      	for (Task task : tasks)
			{	
      			//if the id is present 
				if(task.getTaskID().equals(taskID))
				{
					//check to make sure each aspect is equal to the new info we added
					assertEquals("test", task.getTaskName());
					assertEquals("test", task.getTaskDescription());
				}
			}
	}
	
	//asserts that when ID is already in the list error occurs when trying to add task with the same ID
	@Test 
	void testAddTaskUsingIDWhenIDisPresent() 
	{
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{
			TaskService service = new TaskService();
			List<Task> tasks = new ArrayList<>();
			
			//our new task information
			taskID = "10";
			taskName = "test";
			taskDescription = "test";
			
			//add a task
			tasks.add(new Task("10", "test", "test"));
			//try to use method to add new tasks with the same id
			service.AddTaskUsingID(taskID, taskName, taskDescription, tasks);
		});
	}
	
	//asserts that when ID is not in the list error occurs when trying to delete that task
	@Test 
	void testDeleteTaskUsingIDWhenIDisNotPresent() 
	{
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{
			TaskService service = new TaskService();
			List<Task> tasks = new ArrayList<>();
			//add a task with the id of 15 so that is the only task present in the list
			tasks.add(new Task("15", "test", "test"));
			
			//the task id we are searching for 10 not 15
			taskID = "10";
			//use delete method
			service.DeleteTaskUsingID(taskID, tasks);
			
		});
	}
	
	//asserts that when ID is not present error occurs when trying to update task
	@Test 
	void testUpdateTaskUsingIDWhenIDisNotPresent() 
	{
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{
			TaskService service = new TaskService();
			List<Task> tasks = new ArrayList<>();
			//add a task with the id of 15 so that is the only task present in the list
			tasks.add(new Task("15", "test", "test"));
			
			//assign the task ID we are looking for to 10 not 15
			taskID = "10";
			//use update task method with the ID of 10
			service.UpdateTaskUsingID(taskID, taskName, taskDescription, tasks);
		});
	}
	
	//verifies error occurs when trying to update a task ID
	@Test 
	void testTryingToUpdateTaskID() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{
			TaskService service = new TaskService();
			List<Task> tasks = new ArrayList<>();
			//creates task with the ID of 11
			tasks.add(new Task("11", "test1", "test1"));
			
			//task info trying to be entered with an ID of 10
			taskID = "10";
			taskName = "test";
			taskDescription = "test";
			

			//trying to use a new ID when updating
			service.UpdateTaskUsingID(taskID, taskName, taskDescription, tasks);
		});
	}
}
