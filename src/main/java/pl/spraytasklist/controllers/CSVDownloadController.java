package pl.spraytasklist.controllers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
 
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import pl.spraytasklist.model.TaskList;
import pl.spraytasklist.service.CategoryService;
import pl.spraytasklist.service.TaskListService;
import pl.spraytasklist.service.customDateServiceImpl;

@Controller
public class CSVDownloadController {
	
	protected TaskListService taksklistservice;
	@Autowired(required = true)
	@Qualifier(value = "TaskListService")
	public void setTaskListService(TaskListService tls) {
	    this.taksklistservice = tls;
	}
	
	protected CategoryService categoryservice;
	@Autowired(required = true)
	@Qualifier(value = "CategoryService")
	public void setCategoryService(CategoryService cs) {
	    this.categoryservice = cs;
	}
	
	protected customDateServiceImpl customdateserviceimpl;	
	@Autowired(required = true)
	@Qualifier(value = "customDateServiceImpl")
	public void setTaskListService(customDateServiceImpl cdsi) {
	    this.customdateserviceimpl = cdsi;
	}
	
	
    @RequestMapping(value = "/downloadCSV")
    public void downloadCSV(HttpServletResponse response) throws IOException {
 
        String csvFileName = "tasks.csv";
 
        response.setContentType("text/csv");

        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                csvFileName);
        response.setHeader(headerKey, headerValue);
 
        List<TaskList> tasklist = taksklistservice.findAll();
 
        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
                CsvPreference.STANDARD_PREFERENCE);
 
        String[] header = {"description", "title", "category", "creationDate",
                "dueDate", "priority", "isDone", "doneDate"};
 
        csvWriter.writeHeader(header);
 
        for (TaskList task : tasklist) {
            csvWriter.write(task, header);
        }
 
        csvWriter.close();
    }
    

	@RequestMapping(value = "/readCSV")
    public String readCSV(Model model) throws FileNotFoundException, IOException {
    	
       	Resource resource = new ClassPathResource("tasks.csv");
    	
    	CSVParser csvParser = new CSVParserBuilder().withSeparator(',').withQuoteChar('"').build();
    	
    	CSVReader reader = new CSVReaderBuilder(new FileReader(resource.getFile()))
    			.withSkipLines(1)
    			.withCSVParser(csvParser)
    			.build();
    	
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");    
    	
    	List<TaskList> taskListToModel = new ArrayList<TaskList>();
    	
    	
        String [] nextLine;
        while ((nextLine = reader.readNext()) != null) {       
        	
	        	TaskList tasklist = new TaskList();
	        	/*if((Integer.parseInt(nextLine[0])>0))
	        		tasklist.setId(Integer.parseInt(nextLine[0]));*/
	        	tasklist.setDescription(nextLine[0]);
	        	tasklist.setTitle(nextLine[1]);
	        	tasklist.setCategory(categoryservice.findByName(nextLine[2]));
	        	tasklist.setCreationDate(LocalDateTime.parse(nextLine[3], formatter));
	        	tasklist.setDueDate(LocalDateTime.parse(nextLine[4], formatter));        	
	        	tasklist.setPriority(Integer.parseInt(nextLine[5]));
	        	tasklist.setIsDone(Boolean.parseBoolean(nextLine[6]));
	        	if(Boolean.parseBoolean(nextLine[6]))
	        		tasklist.setDoneDate(LocalDateTime.parse(nextLine[7], formatter));
	        	taksklistservice.saveTask(tasklist);
	            System.out.println("Added task: "+tasklist.toString());
	            taskListToModel.add(tasklist);        	
        }
        
        model.addAttribute("tasklist",taskListToModel);
        
        return "csvlist";
    }
}