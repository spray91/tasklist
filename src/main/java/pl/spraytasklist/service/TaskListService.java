package pl.spraytasklist.service;

import pl.spraytasklist.model.Category;
import pl.spraytasklist.model.TaskList;

public interface TaskListService {
	
	TaskList findByCategory(Category category);
	
	TaskList findById(int id);
	
	void saveTask(TaskList tasklist);
}
