package pl.spraytasklist.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import pl.spraytasklist.model.Category;
import pl.spraytasklist.model.TaskList;
import pl.spraytasklist.service.CategoryService;
import pl.spraytasklist.service.TaskListService;
import pl.spraytasklist.service.customDateServiceImpl;


@Controller
@RequestMapping("/category")
public class CategoryController {

	protected CategoryService categoryservice;
	
	@Autowired(required = true)
	@Qualifier(value = "CategoryService")
	public void setCategoryService(CategoryService cs) {
	    this.categoryservice = cs;
	}

	@RequestMapping("/list")
	public String showList(Model model, TaskList tasklist) {
		if(categoryservice.findAll().isEmpty()) {
			model.addAttribute("isEmpty", true);
		} else{
			model.addAttribute("isEmpty", false);
		}
		model.addAttribute("categories",categoryservice.findAll());
		
		return "catlist";
	}
	
	@GetMapping("/add") 
	 public String addCategory(Model model, Category category) {
		 model.addAttribute("Category",category );
		 return "addcat"; 
	 }
	 
	 @PostMapping("/add") 
	 public String handleCategory(@Valid @ModelAttribute("Category") Category category, BindingResult result, Model model) { 
		 if (result.hasErrors()) {
			 model.addAttribute("message", "error");
			 model.addAttribute("result", result);
			 return "addcat";			 
		 } else {
			 categoryservice.saveCategory(category);		 
			 return "redirect:/category/list"; 
		 } 
	 }
	 
	 @GetMapping("/delete/{id}") 
	 public String deleteCategory(@PathVariable("id") Integer catId) {
		 categoryservice.removeById(catId);
		 return "redirect:/category/list"; 
	 }
}
