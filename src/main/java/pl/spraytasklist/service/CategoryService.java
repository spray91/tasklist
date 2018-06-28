package pl.spraytasklist.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import pl.spraytasklist.model.Category;

public interface CategoryService {

	Category findById(int id);
	
	List<Category> findAll();
	
	void saveCategory(Category category);
	
	Category findByName(String name);
	
	@Transactional
    void removeById(Integer id);
}
