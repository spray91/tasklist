package pl.spraytasklist.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.repository.Query;
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
	
	List<TaskList> findByDueDate(LocalDateTime dueDate);
	
	TaskList findByTitle(String title);
	
	@Transactional
    void removeById(Integer id);
}