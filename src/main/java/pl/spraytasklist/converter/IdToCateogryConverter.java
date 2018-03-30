package pl.spraytasklist.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.spraytasklist.model.Category;
import pl.spraytasklist.dao.CategoryDao;

@Component
public class IdToCateogryConverter implements Converter<Object, Category>{
	
	    @Autowired
	    CategoryDao categorydao;

	    public Category convert(Object element) {

	        if (element instanceof Category) {
	            return (Category)element;
	        }
	        else {
	            int id = Integer.parseInt((String)element);
	            Category category= categorydao.findById(id);
	            System.out.println("Category : "+ category);
	            return category;
	        }

	    }

}
