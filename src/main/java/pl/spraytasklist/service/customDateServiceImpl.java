package pl.spraytasklist.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
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
	
	public String convertDate(int id){
		TaskList taskList = dao.findById(id);
		
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = taskList.getDueDate();
        String formattedDateTime = dateTime.format(formatter); // "1986-04-08 12:30"
        
        return formattedDateTime;
	}
	
	public void checkDeadline() {
		List<TaskList> taskList = new ArrayList<TaskList>();
		taskList = dao.findAll();
		
		for(TaskList task : taskList){
			if(!task.getIsDone())
				task.setTimeToDeadline( Duration.between(LocalDateTime.now(), task.getDueDate()).toSeconds() );
			else
				task.setTimeToDeadline((long) 0);

            tls.saveTask(task);
		}
	}
	
	public Integer nextRecord(Integer taskId) {
		List<TaskList> taskList = new ArrayList<TaskList>();
		taskList = dao.findAll();
		boolean next = false;
		for(TaskList task : taskList){
			if(next)
				return task.getId();
			if(task.getId()==taskId)
				next = true;            
		}	
		return null;
	}
	
	public Integer previousRecord(Integer taskId) {
		List<TaskList> taskList = new ArrayList<TaskList>();
		taskList = dao.findAll();
		boolean prev = false;
		for(int i=taskList.size()-1 ; i>=0 ; i--) {
			TaskList record = taskList.get(i);
			if(prev) 
				return record.getId();
			if(record.getId()==taskId)
				prev = true;
		}		
		return null;
	}
}
