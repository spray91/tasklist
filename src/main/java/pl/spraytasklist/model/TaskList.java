package pl.spraytasklist.model;

import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.NotNull;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="tasks")
public class TaskList {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
    @Size(min=2, max=30)
	private String description;
	
    @NotNull
    @DateTimeFormat(pattern = "dd-mm-yyyy")
	private Date scheduledDate;
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setScheduledDate(Date scheduledDate) {
		this.scheduledDate = scheduledDate;
	}
	
	public Date getScheduledDate() {
		return this.scheduledDate;
	}
	
}
