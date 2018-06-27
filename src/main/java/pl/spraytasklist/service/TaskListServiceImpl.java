package pl.spraytasklist.service;

import pl.spraytasklist.dao.TaskListDao;
import pl.spraytasklist.model.Category;
import pl.spraytasklist.model.TaskList;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("TaskListService")
@Transactional
public class TaskListServiceImpl implements TaskListService {
	
	@Autowired
	private TaskListDao dao;
	
	public TaskList findByCategory(Category category) {
		return dao.findByCategory(category);
	}
	
	public TaskList findById(int id) {
		return dao.findById(id);
	}
	
	public void saveTask(TaskList tasklist) {
		dao.save(tasklist);
	}
	
	public List<TaskList> findAll(){
		return dao.findAll();
	}
	
	public TaskList findByTitle(String title) {
		return dao.findByTitle(title);
	}

	public List<TaskList> findByDueDate(LocalDateTime dueDate) {
		return dao.findByDueDate(dueDate);
	}
	
	public void removeById(Integer id) {
		dao.removeById(id);
	}
	
	
	public List<TaskList> findAllByOrderByDueDate(){
		return dao.findAllByOrderByDueDate();
	}
	
	public List<TaskList> findAllByOrderByPriority(){
		return dao.findAllByOrderByPriority();
	}
}