package pl.spraytasklist.dao;


import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.spraytasklist.model.Category;


@Repository
public interface CategoryDao extends CrudRepository<Category, Integer> {
	
	Category findById(int id);
	
	List<Category> findAll();
	
	Category findByName(String name);
	
	@Transactional
    void removeById(Integer id);
}