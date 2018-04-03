package pl.spraytasklist.model;

import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
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
	
    @Size(min=3, max=50)
	private String description;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
	
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
	private Date dueDate;
    
    @NotNull
    @Min(1)
    @Max(4)
    private Integer priority;
    
    private boolean isDone;
    
    private boolean isDeleted;
    
    protected TaskList() {}
    
    public TaskList(String description, Category category, Date scheduledDate) {
    	this.description = description;
    	this.creationDate = scheduledDate;
    	this.category = category;
    }
    
    @Override
    public String toString() {
    	return String.format(
    			"Task[ID=%d, Description=%s, category=%s, Scheduled Date=%tD]",
    			id, description, category, creationDate);
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
	
	public Date getCreationDate() {
		return this.creationDate;
	}
	
	public void setCreationDate(Date scheduledDate) {
		this.creationDate = scheduledDate;
	}
	
	public Date getDueDate() {
		return this.dueDate;
	}
	
	public void setDueDate(Date dueDate) {
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

	public boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
}
