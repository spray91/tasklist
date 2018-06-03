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
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import pl.spraytasklist.model.Category;
import pl.spraytasklist.model.TaskList;
import pl.spraytasklist.service.CategoryService;
import pl.spraytasklist.service.TaskListService;


@Controller
public class TaskListController {
	
	protected TaskListService takslistservice;
	
	@Autowired(required = true)
	@Qualifier(value = "TaskListService")
	public void setTaskListService(TaskListService tls) {
	    this.takslistservice = tls;
	}
	
	protected CategoryService categoryservice;
	
	@Autowired(required = true)
	@Qualifier(value = "CategoryService")
	public void setCategoryService(CategoryService cs) {
	    this.categoryservice = cs;
	}
	
	
	
	@RequestMapping("/")
	public String mainPage(Model model) {
		if(categoryservice.findAll().isEmpty()) {
			categoryservice.saveCategory(new Category("Birthday","Birthday"));
			categoryservice.saveCategory(new Category("Exam","Exam"));
			categoryservice.saveCategory(new Category("Event","Event"));
		}
		return "main";
	}
	
	@GetMapping("/add") 
	 public String addTask(Model model, TaskList tasklist) {
		 model.addAttribute("TaskList",tasklist );
		 model.addAttribute("categories",categoryservice.findAll());
		 return "add2"; 
	 }
	 
	 @PostMapping("/add") 
	 public String handleTask(@ModelAttribute("TaskList") @Valid TaskList tasklist, BindingResult result, Model model) { 
		 if (result.hasErrors()) {
			 model.addAttribute("message", "error");
			 model.addAttribute("result", result);
			 model.addAttribute("TaskList",tasklist );
			 model.addAttribute("categories",categoryservice.findAll());
			 return "add2";			 
		 } else {
			tasklist.setCreationDate(new Date());
			tasklist.setIsDeleted(false);
			tasklist.setIsDone(false);
			takslistservice.saveTask(tasklist);			 
			return "redirect:/"; 
		 } 
	 }
	
	@RequestMapping("/list")
	public String showList(Model model, TaskList tasklist) {
		if(takslistservice.findAll().isEmpty()) {
			model.addAttribute("isEmpty", true);
		} else{
			model.addAttribute("isEmpty", false);
		}
		model.addAttribute("tasklist",takslistservice.findAll());
		//TODO: pobrac wszystkie taski, zrobic tablice / liste ktora bedzie miala tylko czas miedzy due date a currentDate, i boolean czy data juz byla czy nie
		
		//TODO: zapis do pliku csv
		return "list";
	}
	
	@RequestMapping("/details")
	public String showDetails() {
		//TODO: menu z title i przechodzenie task by task
		return "details";
	}
	
	@GetMapping("/addcat") 
	 public String addCategory(Model model, Category category) {
		 model.addAttribute("Category",category );
		 return "addcatbs"; 
	 }
	 
	 @PostMapping("/addcat") 
	 public String handleCategory(@Valid @ModelAttribute("Category") Category category, BindingResult result, Model model) { 
		 if (result.hasErrors()) {
			 model.addAttribute("message", "error");
			 model.addAttribute("result", result);
			 return "addcatbs";			 
		 } else {
			 categoryservice.saveCategory(category);		 
			 return "redirect:/"; 
		 } 
	 }
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(
	            dateFormat, false));
	}
}
