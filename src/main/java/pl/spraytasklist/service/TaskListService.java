package pl.spraytasklist.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import pl.spraytasklist.model.Category;
import pl.spraytasklist.model.TaskList;

public interface TaskListService {
	
	TaskList findByCategory(Category category);
	
	TaskList findById(int id);
	
	void saveTask(TaskList tasklist);
	
	List<TaskList> findAll();
	
	List<TaskList> findAllByOrderByDueDate();
	
	List<TaskList> findAllByOrderByPriority();
	
	List<TaskList> findByDueDate(LocalDateTime dueDate);
	
	List<TaskList> findAllByIsDone(boolean idDone);

	List<TaskList> findAllByIsDoneOrderByDueDate(boolean idDone);
	
	List<TaskList> findAllByIsDoneOrderByPriority(boolean idDone);
	
	boolean isDone(int id);
	
	@Transactional
    void removeById(Integer id);
	
	boolean existsById(int id);
	
	List<TaskList> findAllByTimeToDeadlineLessThanAndIsDoneOrderByTimeToDeadline();
}