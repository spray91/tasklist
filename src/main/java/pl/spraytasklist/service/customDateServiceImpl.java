package pl.spraytasklist.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.spraytasklist.dao.TaskListDao;
import pl.spraytasklist.model.TaskList;

@Service("customDateServiceImpl")
public class customDateServiceImpl {

	
	@Autowired
	private TaskListDao dao;
	
	@Autowired
	private TaskListService tls;
	
	
	public List<String> getAllDueDates(){
		List<TaskList> taskList = new ArrayList<TaskList>();
		List<String> dates = new ArrayList<String>();
		taskList = dao.findAll();
		
		for(TaskList task : taskList){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime dateTime = task.getDueDate();
            String formattedDateTime = dateTime.format(formatter); // "1986-04-08 12:30"
            dates.add(formattedDateTime);
		}
		return dates;
	}
	
	public void checkDeadline() {
		List<TaskList> taskList = new ArrayList<TaskList>();
		taskList = dao.findAll();
		
		for(TaskList task : taskList){
			LocalDateTime dueDate = task.getDueDate();
			LocalDateTime currentTime = LocalDateTime.now();
            task.setTimeToDeadline( Duration.between(currentTime, dueDate).toSeconds() );

            tls.saveTask(task);
		}
	}
}