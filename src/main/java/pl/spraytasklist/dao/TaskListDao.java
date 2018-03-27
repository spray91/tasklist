package pl.spraytasklist.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.spraytasklist.model.TaskList;


@Repository
public interface TaskListDao extends CrudRepository<TaskList, Integer> {
	
	List<TaskList> findByCategory(String category);
	
	//public Optional<TaskList> findById(Integer Id);
	
	
	/*List<TaskListDomain> tasklists = new ArrayList<TaskListDomain>();
	
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
	}*/
}