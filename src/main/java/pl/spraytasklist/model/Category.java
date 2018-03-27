package pl.spraytasklist.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="category")
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@NotNull
	private String name;
	
	private String description;

    protected Category() {}
    
    public Category(String name, String description) {
    	this.name = name;
    	this.description = description;
    }
    
    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
    private List<TaskList> tasklist;
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public String getName() {
    	return this.name;
    }
    
    public void setDescription(String description) {
    	this.description = description;
    }
    
    public String getDescription() {
    	return this.description;
    }
    
    public void setTaskList(List<TaskList> tasklist) {
    	this.tasklist = tasklist;
    }
    
    public List<TaskList> getTaskList() {
    	return this.tasklist;
    }
    
    @Override
    public String toString() {
    	return String.format(
    			"Category[ID=%d, Name=%s, Desc=%s",
    			id, name, description);
    }

}
