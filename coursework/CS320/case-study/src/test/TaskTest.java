package test;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;

import task.Task;

class TaskTest {
	
	Task testTask;
	
	@BeforeEach
	void initialize() {
		testTask = new Task("1", "Get Laundry", "Go and get the laundry");
	}

	@Test
	void testNewTask() {
		assertTrue(testTask.getTaskID().equals("1"));
		assertTrue(testTask.getName().equals("Get Laundry"));
		assertTrue(testTask.getDescription().equals("Go and get the laundry"));
	}
	
	@Test
	void testTaskIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("11111111111111111111111111", "Get Laundry", "Go and get the laundry");
		});
	}
	
	@Test
	void testTaskIDIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "Get Laundry", "Go and get the laundry");
		});
	}
	
	@Test
	void testNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("1", "1234567890987654321234567890", "Go and get the laundry");
		});
	}
	
	@Test
	void testNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("1", null, "Go and get the laundry");
		});
	}
	
	@Test 
	void testDescriptionIsTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("1", "Get laundry", "12345678901234567801234567890123456789012345678901234567890");
		});
	}
	
	@Test
	void testDescriptionIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("1", "Get laundry", null);
		});
	}
	
	// Update Apr. 5, 2024: I realised that I should add test units for them "set*" methods:
	
	@Test
	void testSetName() {
		testTask.setName("Do cooking");
		assertTrue(testTask.getName().equals("Do cooking"));
	}
	
	@Test
	void testSetNameIsTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		    testTask.setName("123456789012345678901");
		});
	}
	
	@Test
	void testSetNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testTask.setName(null);
		});
	}
	
	@Test
	void testSetDescription() {
		testTask.setDescription("Be sure to use healthy stuff");
		assertTrue(testTask.getDescription().equals("Be sure to use healthy stuff"));
	}

	@Test
	void testSetDescriptionIsTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testTask.setDescription("1234567890123456789012345678901234567890123456789055");
		});
	}
	
	@Test
	void testSetDescriptionIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testTask.setDescription(null);
		});
	}
}

/*
 * End notes:
 * 1. Retrieved on Mar. 29, 2024 from: 
 *   https://www.baeldung.com/junit-before-beforeclass-beforeeach-beforeall
 */