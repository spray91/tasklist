package pl.spraytasklist.dao;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.spraytasklist.model.Category;


@Repository
public interface CategoryDao extends CrudRepository<Category, Integer> {
	
	Optional<Category> findById(Integer id);
	
}