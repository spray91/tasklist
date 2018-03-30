package pl.spraytasklist.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.spraytasklist.model.Category;


@Repository
public interface CategoryDao extends CrudRepository<Category, Integer> {
	
	Category findById(int id);
	
	void saveCategory(Category category);
}