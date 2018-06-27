package pl.spraytasklist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.spraytasklist.dao.CategoryDao;
import pl.spraytasklist.model.Category;

@Service("CategoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDao dao;
	
	public Category findById(int id) {
		return dao.findById(id);
	}
	
	public void saveCategory(Category category) {
		dao.save(category);
	}
	
	public List<Category> findAll(){
		return dao.findAll();
	}
	
	public Category findByName(String name) {
		return dao.findByName(name);
	}
}
