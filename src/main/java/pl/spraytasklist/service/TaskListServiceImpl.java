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
	
	public List<TaskList> findByDueDate(LocalDateTime dueDate) {
		return dao.findAllByDueDate(dueDate);
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
	
	public boolean existsById(int id) {
		return dao.existsById(id);
	}
	
	public List<TaskList> findAllByIsDone(boolean idDone){
		return dao.findAllByIsDone(idDone);
	}
	
	public List<TaskList> findAllByIsDoneOrderByDueDate(boolean idDone){
		return dao.findAllByIsDoneOrderByDueDate(idDone);
	}
	
	public List<TaskList> findAllByIsDoneOrderByPriority(boolean idDone){
		return dao.findAllByIsDoneOrderByPriority(idDone);
	}
	
	public boolean isDone(int id) {
		TaskList tasklist = dao.findById(id);
		if(tasklist.getIsDone()) 
			return true;
		else
			return false;		
	}
	
	public List<TaskList> findAllByTimeToDeadlineLessThanAndIsDoneOrderByTimeToDeadline(){
		return dao.findAllByTimeToDeadlineLessThanAndIsDoneOrderByTimeToDeadline((long) 604800, false);
	}
}