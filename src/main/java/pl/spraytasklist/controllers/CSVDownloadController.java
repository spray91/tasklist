package pl.spraytasklist.controllers;

import java.io.IOException;
import java.util.List;
 
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import pl.spraytasklist.model.TaskList;
import pl.spraytasklist.service.TaskListService;


@Controller
public class CSVDownloadController {
	
	protected TaskListService takslistservice;
	
	@Autowired(required = true)
	@Qualifier(value = "TaskListService")
	public void setTaskListService(TaskListService tls) {
	    this.takslistservice = tls;
	}
	
	
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
 
        String[] header = { "description", "title", "category", "creationDate",
                "dueDate", "priority", "isDone", "isDeleted"};
 
        csvWriter.writeHeader(header);
 
        for (TaskList task : tasklist) {
            csvWriter.write(task, header);
        }
 
        csvWriter.close();
    }
}