package pl.spraytasklist.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;



public class TaskListModel {

    @Size(min=2, max=30)
	private String description;
	
	//@Pattern(regexp = "[0-3][0-9]-[0-1][0-9]-[1-2][0-9]{3}")
	private String scheduledDate;
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setScheduledDate(String scheduledDate) {
		this.scheduledDate = scheduledDate;
	}
	
	public String getScheduledDate() {
		return this.scheduledDate;
	}
	
}
