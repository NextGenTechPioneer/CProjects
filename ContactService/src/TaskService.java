package contact;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskService {
	
	//creates tasks list
	public List<Task> tasks = new ArrayList<>();
	
	//method to add task
	public void AddTaskUsingID(String taskID,String taskName, String taskDescription, List<Task> tasks)
		{
			for (Task task : tasks)
			{
				//if the task id is already present throw exception
				if(task.getTaskID().equals(taskID))
				{
				throw new IllegalArgumentException("task ID is already present");
				}
			}
			//if the task id is not present add the task to the list
			tasks.add(new Task(taskID, taskName, taskDescription));
		}
	
	
	
	//method to delete task
	public void DeleteTaskUsingID(String taskID, List<Task> tasks) 
		{
		//variable to determine if the ID is present
		boolean IDisPresent = false;
		//to iterate through the tasks list
		Iterator<Task> iterator = tasks.iterator();
		while(iterator.hasNext())
			{
				Task task = iterator.next();
				//if the task id is present delete it and turn id is present to true
				if (task.getTaskID().equals(taskID))
					{
						iterator.remove();
						IDisPresent = true;
					}
			}
				//if the task id is not present throw exception
				if (IDisPresent == false)
					{
						throw new IllegalArgumentException("Task ID is not present");
					}
		}
	
	//method to update existing task
	public void UpdateTaskUsingID(String taskID, String taskName, String taskDescription, List<Task> tasks)
		{
		//variable to determine if the ID is present
		boolean IDisPresent = false;
			//go through tasks list
			for (Task task : tasks)
				{
					//if the task ID is present update task name and description and assign task is present as true
					if(task.getTaskID().equals(taskID))
						{
							IDisPresent = true;
							task.setTaskName(taskName);
							task.setTaskDescription(taskDescription);
					}
				}
					//if the task ID is not present throw exception
					if (IDisPresent == false)
					{
						throw new IllegalArgumentException("Task ID is not present");
					}
		}

}
