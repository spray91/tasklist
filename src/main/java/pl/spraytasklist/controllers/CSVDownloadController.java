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
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseBool;
import org.supercsv.cellprocessor.ParseDate;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.ParseLong;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.constraint.StrMinMax;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanReader;
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
	
	protected TaskListService takslistservice;
	@Autowired(required = true)
	@Qualifier(value = "TaskListService")
	public void setTaskListService(TaskListService tls) {
	    this.takslistservice = tls;
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
	
	/*protected CSVReadUtil csvreadutil;
	
	@Autowired
	@Qualifier(value = "CSVReadUtil")
	public void setCSVReadUtil(CSVReadUtil csvutil) {
	    this.csvreadutil = csvutil;
	}*/
	
	
    @RequestMapping(value = "/downloadCSV")
    public void downloadCSV(HttpServletResponse response) throws IOException {
 
        String csvFileName = "tasks.csv";
 
        response.setContentType("text/csv");

        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                csvFileName);
        response.setHeader(headerKey, headerValue);
 
        List<TaskList> tasklist = takslistservice.findAll();
 
        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
                CsvPreference.STANDARD_PREFERENCE);
 
        String[] header = { "id", "description", "title", "category", "creationDate",
                "dueDate", "priority", "isDone", "doneDate", "timeToDeadline"};
 
        csvWriter.writeHeader(header);
 
        for (TaskList task : tasklist) {
            csvWriter.write(task, header);
        }
 
        csvWriter.close();
    }
    

	@RequestMapping(value = "/readCSV")
    public void readCSV(Model model) throws FileNotFoundException, IOException {
    	
       	Resource resource = new ClassPathResource("tasks.csv");
    	
    	CSVParser csvParser = new CSVParserBuilder().withSeparator(',').withQuoteChar('"').build();
    	
    	CSVReader reader = new CSVReaderBuilder(new FileReader(resource.getFile()))
    			.withSkipLines(1)
    			.withCSVParser(csvParser)
    			.build();
    	
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");    
    	
        String [] nextLine;
        while ((nextLine = reader.readNext()) != null) {        
        	TaskList tasklist = new TaskList();
        	if((Integer.parseInt(nextLine[0])>0))
        		tasklist.setId(Integer.parseInt(nextLine[0]));
        	tasklist.setDescription(nextLine[1]);
        	tasklist.setTitle(nextLine[2]);
        	tasklist.setCategory(categoryservice.findByName(nextLine[3]));
        	tasklist.setCreationDate(LocalDateTime.parse(nextLine[4], formatter));
        	tasklist.setDueDate(LocalDateTime.parse(nextLine[5], formatter));        	
        	tasklist.setPriority(Integer.parseInt(nextLine[6]));
        	tasklist.setIsDone(Boolean.parseBoolean(nextLine[7]));
        	if(tasklist.getIsDone())
        		tasklist.setDoneDate(LocalDateTime.parse(nextLine[8], formatter));
        	takslistservice.saveTask(tasklist);
            System.out.println("Added task: "+tasklist.toString());
        }
    }
}