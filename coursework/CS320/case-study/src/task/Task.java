package task;

import java.io.*;
import java.util.*;

public class Task {
	
	private String taskID;
	private String name;
	private String description;
	
	public Task(String taskID, String name, String description) {
		if (taskID == null || taskID.length() > 10)
			throw new IllegalArgumentException("Invalid 'taskID'");
		this.taskID = taskID;
		
		if (name == null || name.length() > 20)
			throw new IllegalArgumentException("Invalid 'name'");
		this.name = name;
		
		if (description == null || description.length() > 50)
			throw new IllegalArgumentException("Invalid 'description'");
		this.description = description;
	}
	
	public String getTaskID() {
		return this.taskID;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		if (name == null || name.length() > 20)
			throw new IllegalArgumentException("Invalid 'name'");
		this.name = name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		if (description == null || description.length() > 50)
			throw new IllegalArgumentException("Invalid 'description'");
		this.description = description;
	}

}
