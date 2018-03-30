package pl.spraytasklist.service;

import pl.spraytasklist.model.Category;

public interface CategoryService {

	Category findById(int id);
	
	void saveCategory(Category category);
}
