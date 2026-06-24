package task;

import java.io.*;
import java.util.*;

public class TaskService {
	
	private static Hashtable<String, Task> taskDatabase = new Hashtable<String, Task>();
	
	public void addTask(String taskID, String name, String description) throws Exception {
		if (taskDatabase.get(taskID) != null)
			throw new Exception("taskID already in contacts database");
		taskDatabase.put(taskID, new Task(taskID, name, description));
	}
	
	public void updateTask(String taskID, int field, String data) throws Exception {
		Task currentTask = taskDatabase.get(taskID);
		if (currentTask == null)
			throw new Exception("taskID does not exist");
		switch (field) {
		case 1: // name
			currentTask.setName(data);
			break;
		case 2: // description
			currentTask.setDescription(data);
			break;
		default:
			break;
		}
	}
	
	public void deleteTask(String taskID) throws Exception {
		Task currentTask = taskDatabase.get(taskID);
		if (currentTask == null)
			throw new Exception("taskID does not exist");
		taskDatabase.remove(taskID);
	}
	
	public Task getTask(String taskID) throws Exception {
		Task currentTask = taskDatabase.get(taskID);
		if (currentTask == null)
			throw new Exception("taskID does not exist");
		return currentTask;
	}
}
