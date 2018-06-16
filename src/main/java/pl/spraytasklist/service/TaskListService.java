package pl.spraytasklist.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import pl.spraytasklist.model.Category;
import pl.spraytasklist.model.TaskList;

public interface TaskListService {
	
	TaskList findByCategory(Category category);
	
	TaskList findById(int id);
	
	TaskList findByTitle(String title);
	
	void saveTask(TaskList tasklist);
	
	List<TaskList> findAll();
	
	List<TaskList> findByDueDate(LocalDateTime dueDate);
	
}
