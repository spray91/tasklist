package pl.spraytasklist.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.spraytasklist.model.Category;
import pl.spraytasklist.model.TaskList;


@Repository
public interface TaskListDao extends CrudRepository<TaskList, Integer> {
	
	TaskList findByCategory(Category category);
	
	TaskList findById(int id);
	
	//void saveTask(TaskList tasklist);
}