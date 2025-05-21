package contact;

public class Task {
	
	private String taskID;
	private String taskName;
	private String taskDescription;
	
	
	
	//creates task object 
		public Task(String taskID, String taskName, String taskDescription) 
		{
			//if id is null or greater then 10 characters throw exception
			if(taskID == null || taskID.length()>10)
			{
				throw new IllegalArgumentException("Invalid Task ID");
			}
			//if task name is null or greater then 20 characters throw exception
			if(taskName == null || taskName.length()>20)
			{
				throw new IllegalArgumentException("Invalid Task Name");
			}
			//if task description is null or greater then 50 characters throw exception
			if(taskDescription == null || taskDescription.length()>50)
			{
				throw new IllegalArgumentException("Invalid Description");
			}
			
			//else no exceptions have been thrown assign variables
			this.taskID = taskID;
			this.taskName = taskName; 
			this.taskDescription = taskDescription;
		}
	
		
		//getters
		public String getTaskID()
		{
			return taskID;
		}
		
		public String getTaskName()
		{
			return taskName;
		}
		
		public String getTaskDescription()
		{
			return taskDescription;
		}
		
		//setters
	
		public void setTaskName(String newTaskName)
		{
			this.taskName = newTaskName;
		}
		
		public void setTaskDescription(String newTaskDescription)
		{
			this.taskDescription = newTaskDescription;
		}
		
		
	
	

}
