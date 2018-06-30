package pl.spraytasklist.model;

import javax.validation.constraints.Size;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

//import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="tasks")
public class TaskList {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
    @Size(max=200)
	private String description;
    
    @NotNull
    @Size(min=2, max=40)
	private String title;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
	
    //@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime creationDate;
	
    //@NotNull
    //@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime dueDate;
    
    //@NotNull
    @Min(1)
    @Max(4)
    private Integer priority;
    
    private boolean isDone;
    
    private LocalDateTime doneDate;
    
    private Long timeToDeadline;
    
    
    public TaskList() {}
    
    public TaskList(String description, Category category, LocalDateTime scheduledDate) {
    	this.description = description;
    	this.creationDate = scheduledDate;
    	this.category = category;
    }
    
    @Override
    public String toString() {
    	return String.format(
    			"Task[ID=%d, Description=%s, category=%s, Scheduled Date=%tD, Due Date=%tD], Is Done=%b",
    			this.id, this.description, this.category, this.creationDate, this.dueDate, this.isDone);
    }

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public LocalDateTime getCreationDate() {
		return this.creationDate;
	}
	
	public void setCreationDate(LocalDateTime scheduledDate) {
		this.creationDate = scheduledDate;
	}
	
	public LocalDateTime getDueDate() {
		return this.dueDate;
	}
	
	public void setDueDate(LocalDateTime dueDate) {
		this.dueDate = dueDate;
	}
	
	public Integer getPriority() {
		return this.priority;
	}
	
	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public boolean getIsDone() {
		return isDone;
	}

	public void setIsDone(boolean isDone) {
		this.isDone = isDone;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}

	public LocalDateTime getDoneDate() {
		return doneDate;
	}

	public void setDoneDate(LocalDateTime doneDate) {
		this.doneDate = doneDate;
	}

	public Long getTimeToDeadline() {
		return timeToDeadline;
	}

	public void setTimeToDeadline(Long timeToDeadline) {
		this.timeToDeadline = timeToDeadline;
	}
}
