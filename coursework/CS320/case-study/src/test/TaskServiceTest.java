package test;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;

import task.Task;
import task.TaskService;

class TaskServiceTest {
	
	TaskService taskService;
	
	@BeforeEach
	void initialize() {
		taskService = new TaskService();
	}

	@Test
	void testAddTask() throws Exception {
		taskService.addTask("1", "Get Laundry", "Go and get the laundry.");
		Task testTask = taskService.getTask("1");
		assertTrue(testTask.getTaskID().equals("1"));
		assertTrue(testTask.getName().equals("Get Laundry"));
		assertTrue(testTask.getDescription().equals("Go and get the laundry."));
		taskService = null;
	}

	@Test
	void testDeleteTask() throws Exception {
		taskService.addTask("2", "Get Laundry", "Go and get the laundry.");
		Task testContact = taskService.getTask("2");
		assertTrue(testContact.getTaskID().equals("2"));
		assertTrue(testContact.getName().equals("Get Laundry"));
		assertTrue(testContact.getDescription().equals("Go and get the laundry."));
		taskService.deleteTask("2");
		
		Assertions.assertThrows(Exception.class, () -> {
			taskService.getTask("2");
		});
	}
	
	@Test
	void testDeleteNonExistentTask() throws Exception {
		Assertions.assertThrows(Exception.class, () -> {
			taskService.deleteTask("9001");
		});
	}
	
	@Test 
	void testUpdateTasks() throws Exception {
		taskService.addTask("4", "Update test", "Testing for updates");
		Task taskCurrentState = taskService.getTask("4");
		assertTrue(taskCurrentState.getTaskID().equals("4"));
		assertTrue(taskCurrentState.getName().equals("Update test"));
		assertTrue(taskCurrentState.getDescription().equals("Testing for updates"));
		taskService.updateTask("4", 1, "Update test 2");
		assertTrue(taskCurrentState.getName().equals("Update test 2"));
		taskService.updateTask("4", 2, "Trying to update again");
		assertTrue(taskCurrentState.getDescription().equals("Trying to update again"));
	}
}

/* End notes:
 * 1. Retrieved on Mar. 28, 2024 from: https://www.educative.io/answers/what-is-the-before-annotation-in-junit-testing
 */

