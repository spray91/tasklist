package pl.spraytasklist.model;

import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

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
	
    @Size(min=3, max=30)
	private String description;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
	
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
	private Date scheduledDate;
	
    protected TaskList() {}
    
    public TaskList(String description, Category category, Date scheduledDate) {
    	this.description = description;
    	this.scheduledDate = scheduledDate;
    	this.category = category;
    }
    
    @Override
    public String toString() {
    	return String.format(
    			"Task[ID=%d, Description=%s, category=%s, Scheduled Date=%tD",
    			id, description, category, scheduledDate);
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
	
	public Date getScheduledDate() {
		return this.scheduledDate;
	}
	
	public void setScheduledDate(Date scheduledDate) {
		this.scheduledDate = scheduledDate;
	}
}
