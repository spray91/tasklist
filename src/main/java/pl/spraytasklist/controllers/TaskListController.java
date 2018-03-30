package pl.spraytasklist.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;

import pl.spraytasklist.model.Category;
import pl.spraytasklist.model.TaskList;
import pl.spraytasklist.service.CategoryService;
import pl.spraytasklist.service.TaskListService;


@Controller
public class TaskListController {
	
	@Autowired
	protected TaskListService takslistservice;
	
	@Autowired
	protected CategoryService categoryservice;
	
	@RequestMapping("/")
	public String mainPage(Model model) {
		categoryservice.saveCategory(new Category("asd","aa"));
		model.addAttribute("message", categoryservice.findById(1));
		return "main";
	}
	
	@GetMapping("/add") 
	 public String addTask(Model model, TaskList tasklist) {
		 model.addAttribute("TaskList",tasklist );
		 model.addAttribute("categories",categorydao.findAll());
		 return "add"; 
	 }
	 
	 @PostMapping("/add") 
	 public String handleTask(@ModelAttribute("TaskList") @Valid TaskList TaskList, BindingResult result, Model model) { 
		 if (result.hasErrors()) {
			 model.addAttribute("message", "error");
			 model.addAttribute("result", result);
			 return "add";			 
		 } else {
			 takslistservice.saveTask(TaskList);

			 
			 return "redirect:/"; 
		 } 
	 }
	
	@RequestMapping("/list")
	public String showList(Model model) {
		
		model.addAttribute("test", "test");
		return "list";
	}
	
	@RequestMapping("/details")
	public String showDetails() {
		return "details";
	}
	
	@GetMapping("/addcat") 
	 public String addCategory(Model model, Category category) {
		 model.addAttribute("Category",category );
		 return "addcat"; 
	 }
	 
	 @PostMapping("/addcat") 
	 public String handleCategory(@ModelAttribute("Category") @Valid Category category, BindingResult result, Model model) { 
		 if (result.hasErrors()) {
			 model.addAttribute("message", "error");
			 model.addAttribute("result", result);
			 return "addcat";			 
		 } else {
			 categoryservice.saveCategory(category);		 
			 return "redirect:/"; 
		 } 
	 }
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(
	            dateFormat, false));
	}
}
