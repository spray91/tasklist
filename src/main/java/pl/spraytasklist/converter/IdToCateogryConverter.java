package pl.spraytasklist.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.spraytasklist.model.Category;
import pl.spraytasklist.service.CategoryService;

@Component
public class IdToCateogryConverter implements Converter<String, Category>{
	
	    @Autowired
	    CategoryService categoryservice;

	    public Category convert(String name) {
	        return categoryservice.findByName(name);
	    }

}
