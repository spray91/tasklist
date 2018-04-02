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
	    	System.out.println("converter");
	    	System.out.println(name);
	    	//System.out.println(categoryservice.findAll());
	        //Category category= categoryservice.findByName(name);
	        System.out.println("conv-end");
	        //System.out.println(category);
	        return categoryservice.findByName(name);
	    }

}
