package pl.spraytasklist.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.supercsv.cellprocessor.*;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.constraint.StrMinMax;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import pl.spraytasklist.model.TaskList;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


//@Component
//@Scope("prototype")
public class CSVReadUtil {
	
	//@Bean
    public List<TaskList> readCsv() throws IOException {

		Resource resource = new ClassPathResource("tasks.csv");
		
		List<TaskList> tasksList = new ArrayList<TaskList>();
		
        ICsvBeanReader beanReader = null;
        try {
            beanReader = new CsvBeanReader(new FileReader(resource.getFile()), CsvPreference.STANDARD_PREFERENCE);

            final String[] header = beanReader.getHeader(true);
            final CellProcessor[] processors = getProcessors();

            TaskList tasklist;
            while ((tasklist = beanReader.read(TaskList.class, header, processors)) != null) {
            	tasksList.add(tasklist);
                System.out.println(tasklist);
            }
        } finally {
            if (beanReader != null) {
                beanReader.close();
            }
        }
        return tasksList;
    }

	//@Bean
    private static CellProcessor[] getProcessors(){
        return new CellProcessor[] {
                new Optional(new ParseInt()),
                new NotNull(new StrMinMax(0,200)),
                new NotNull(new StrMinMax(2,50)),
                new NotNull(),
                new NotNull(new ParseDate("yyyy-MM-dd HH:mm")),
                new NotNull(new ParseDate("yyyy-MM-dd HH:mm")),
                new NotNull(new ParseInt()),
                new Optional(new ParseBool()),
                new NotNull(new ParseDate("yyyy-MM-dd HH:mm")),
                new NotNull(new ParseLong())};
    }
}