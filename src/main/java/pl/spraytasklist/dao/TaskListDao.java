package pl.spraytasklist.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.spraytasklist.model.Category;
import pl.spraytasklist.model.TaskList;


@Repository
public interface TaskListDao extends CrudRepository<TaskList, Integer> {
	
	TaskList findByCategory(Category category);
	
	TaskList findById(int id);
	
	List<TaskList> findAll();
	
	List<TaskList> findAllByIsDone(boolean idDone);

	List<TaskList> findAllByOrderByDueDate();
	
	List<TaskList> findAllByIsDoneOrderByDueDate(boolean idDone);
	
	List<TaskList> findAllByOrderByPriority();
	
	List<TaskList> findAllByIsDoneOrderByPriority(boolean idDone);
	
	List<TaskList> findAllByDueDate(LocalDateTime dueDate);
	
	List<TaskList> findAllByTimeToDeadlineLessThanAndIsDoneOrderByTimeToDeadline(Long timeToDeadline, boolean isDone);
	
	@Transactional
    void removeById(Integer id);
	
}