package pl.spraytasklist.controllers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
import pl.spraytasklist.service.TaskListService;
import pl.spraytasklist.service.customDateServiceImpl;
import pl.spraytasklist.utils.CSVReadUtil;


@Controller
public class CSVDownloadController {
	
	protected TaskListService takslistservice;
	
	@Autowired(required = true)
	@Qualifier(value = "TaskListService")
	public void setTaskListService(TaskListService tls) {
	    this.takslistservice = tls;
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
    	
    	CSVReader reader = new CSVReaderBuilder(new FileReader(resource.getFile())).withCSVParser(csvParser).build();
        String [] nextLine;
        while ((nextLine = reader.readNext()) != null) {        	
            System.out.println(nextLine[0] + " - " + nextLine[1] + " - " + nextLine[2]);
            System.out.println();
        }
    }
}