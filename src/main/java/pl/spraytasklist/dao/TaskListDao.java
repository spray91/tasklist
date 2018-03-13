package pl.spraytasklist.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import pl.pl.spraytasklist.domain.TaskListDomain;


@Repository
public class TaskListDao {
	
	List<TaskListDomain> tasklists = new ArrayList<TaskListDomain>();
	
	public void addEntry(TaskListDomain tasklist) {
		tasklists.add(tasklist);
	}
	
	public List<TaskListDomain> getLists(){
		return tasklists;
	}
	
	public TaskListDomain getListById(Integer id) {
		if(id<tasklists.size()) {
			return tasklists.get(id);
		} else {
			return null;
		}
	}
	
	public Integer getNextId() {
		return tasklists.size();
	}
}
//http://dominoc925.blogspot.com/2015/11/an-example-of-using-sqlite-database-in.html