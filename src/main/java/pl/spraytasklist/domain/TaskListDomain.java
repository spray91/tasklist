package pl.pl.spraytasklist.domain;

import java.util.Date;
import org.springframework.stereotype.Repository;

@Repository
public class TaskListDomain {
	
	private String description;
	private Integer id;
	private String scheduledDate;
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setScheduledDate(String scheduledDate) {
		this.scheduledDate = scheduledDate;
	}
	
	public String getScheduledDate() {
		return this.scheduledDate;
	}
}
