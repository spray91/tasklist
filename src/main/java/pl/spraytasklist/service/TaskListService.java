package pl.spraytasklist.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import pl.spraytasklist.model.Category;
import pl.spraytasklist.model.TaskList;

public interface TaskListService {
	
	TaskList findByCategory(Category category);
	
	TaskList findById(int id);
	
	TaskList findByTitle(String title);
	
	void saveTask(TaskList tasklist);
	
	List<TaskList> findAll();
	
	List<TaskList> findAllByOrderByDueDate();
	
	List<TaskList> findAllByOrderByPriority();
	
	List<TaskList> findByDueDate(LocalDateTime dueDate);
	
	@Transactional
    void removeById(Integer id);
}