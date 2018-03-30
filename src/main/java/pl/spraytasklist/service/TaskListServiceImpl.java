package pl.spraytasklist.service;


import pl.spraytasklist.dao.TaskListDao;
import pl.spraytasklist.model.Category;
import pl.spraytasklist.model.TaskList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("TaskListservice")
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
		dao.saveTask(tasklist);
	}
}
