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
@RequestMapping("/task")
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
	
	protected customDateServiceImpl customdateserviceimpl;
	
	@Autowired(required = true)
	@Qualifier(value = "customDateServiceImpl")
	public void setTaskListService(customDateServiceImpl cdsi) {
	    this.customdateserviceimpl = cdsi;
	}
	
	@GetMapping("/add") 
	 public String addTask(Model model, TaskList tasklist) {
		 model.addAttribute("TaskList",tasklist );
		 model.addAttribute("categories",categoryservice.findAll());
		 return "add"; 
	 }
	 
	 @PostMapping("/add") 
	 public String handleTask(@Valid @ModelAttribute("TaskList") TaskList tasklist, BindingResult result, Model model) { 
		 if (result.hasErrors()) {
			 model.addAttribute("result", result);
			 model.addAttribute("TaskList",tasklist );
			 model.addAttribute("categories",categoryservice.findAll());
			 return "add";			 
		 } else {
			tasklist.setCreationDate(LocalDateTime.now());
			tasklist.setIsDone(false);
			takslistservice.saveTask(tasklist);			 
			return "redirect:/task/list"; 
		 } 
	 }
	
	@RequestMapping("/list")
	public String showList(Model model, TaskList tasklist) {
		if(takslistservice.findAll().isEmpty())
			model.addAttribute("isEmpty", true);
		else
			model.addAttribute("isEmpty", false);
		
		customdateserviceimpl.checkDeadline();
		model.addAttribute("tasklist",takslistservice.findAllByOrderByPriority());
		model.addAttribute("dueDates",customdateserviceimpl.getAllDueDates());
		//TODO: pobrac wszystkie taski, zrobic tablice / liste ktora bedzie miala tylko czas miedzy due date a currentDate, i boolean czy data juz byla czy nie

		return "list";
	}
	
	@RequestMapping("/details/{id}")
	public String showDetails(@PathVariable("id") Integer taskId, Model model) {
		if(takslistservice.findById(taskId)==null)
			model.addAttribute("isEmpty", true);
		else
			model.addAttribute("isEmpty", false);
		
		customdateserviceimpl.checkDeadline();
		model.addAttribute("task",takslistservice.findById(taskId));
		model.addAttribute("nextRecord",customdateserviceimpl.nextRecord(taskId));
		model.addAttribute("previousRecord",customdateserviceimpl.previousRecord(taskId));
		
		return "details";
	}
	
	 @GetMapping("/delete/{id}") 
	 public String deleteTask(@PathVariable("id") Integer taskId) {
		 takslistservice.removeById(taskId);		 
		 
		 return "redirect:/task/list"; 
	 }
	 
	 @GetMapping("/done/{id}") 
	 public String finishTask(@PathVariable("id") Integer taskId) {
		 TaskList tasklist;
		 tasklist = takslistservice.findById(taskId);		 
		 tasklist.setIsDone(true);
		 takslistservice.saveTask(tasklist);		 
		 return "redirect:/task/details/"+taskId; 
	 }
	 
	 @GetMapping("/edit/{id}") 
	 public String editTask(@PathVariable("id") Integer taskId, Model model) {
		 if(!takslistservice.existsById(taskId)) {
			 model.addAttribute("id", taskId);
			 return "editerror";
		 } else {
			 model.addAttribute("TaskList",takslistservice.findById(taskId));
			 model.addAttribute("categories",categoryservice.findAll());
			 model.addAttribute("dueDateValue", customdateserviceimpl.convertDate(taskId));
			 return "edit"; 
		 }
	 }
	 
	 @PostMapping("/edit/{id}") 
	 public String postEditTask(@Valid @ModelAttribute("TaskList") TaskList tasklist, 
			 					@PathVariable("id") Integer taskId, 
			 					BindingResult result, 
			 					Model model) { 
		 
		 if (result.hasErrors()) {
			 model.addAttribute("result", result);
			 model.addAttribute("TaskList", tasklist);
			 model.addAttribute("categories",categoryservice.findAll());
			 model.addAttribute("dueDateValue", customdateserviceimpl.convertDate(taskId));
			 return "edit";			 
		 } else {
			takslistservice.saveTask(tasklist);			 
			return "redirect:/task/list"; 
		 } 
	 }
}
