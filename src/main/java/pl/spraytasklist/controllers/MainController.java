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

import pl.spraytasklist.components.DeadLineComponent;
import pl.spraytasklist.model.Category;
import pl.spraytasklist.model.TaskList;
import pl.spraytasklist.service.CategoryService;
import pl.spraytasklist.service.TaskListService;
import pl.spraytasklist.service.customDateServiceImpl;


@Controller
public class MainController {
	
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
	
	protected customDateServiceImpl customdateserviceimpl;
	
	@Autowired(required = true)
	@Qualifier(value = "customDateServiceImpl")
	public void setTaskListService(customDateServiceImpl cdsi) {
	    this.customdateserviceimpl = cdsi;
	}
	
	@Autowired
	DeadLineComponent dlc;
	
	@RequestMapping("/")
	public String mainPage(Model model) {
		if(categoryservice.findAll().isEmpty()) {
			categoryservice.saveCategory(new Category("Birthday","Birthday"));
			categoryservice.saveCategory(new Category("Exam","Exam"));
			categoryservice.saveCategory(new Category("Event","Event"));
			categoryservice.saveCategory(new Category("Category","Category"));
			categoryservice.saveCategory(new Category("Test","Test"));
		}
		
		System.out.println(dlc.convertToString());
		
		customdateserviceimpl.checkDeadline();
		model.addAttribute("deadline",takslistservice.findAllByTimeToDeadlineLessThanAndIsDoneOrderByTimeToDeadline());

		return "main";
	}
}
