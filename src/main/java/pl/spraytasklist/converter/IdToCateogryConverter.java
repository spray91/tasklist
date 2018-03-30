package pl.spraytasklist.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.spraytasklist.model.Category;
import pl.spraytasklist.service.CategoryService;

@Component
public class IdToCateogryConverter implements Converter<Object, Category>{
	
	    @Autowired
	    CategoryService categoryservice;

	    public Category convert(Object element) {
	    	System.out.println("debug");
	        if (element instanceof Category) {
	            return (Category)element;
	        }
	        else {
	            int id = Integer.parseInt((String)element);
	            Category category= categoryservice.findById(id);
	            System.out.println("Category : "+ category);
	            return category;
	        }

	    }

}
