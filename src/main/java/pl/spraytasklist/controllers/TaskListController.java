package pl.spraytasklist.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import pl.spraytasklist.model.TaskListModel;
import pl.spraytasklist.dao.TaskListDao;
import pl.spraytasklist.domain.TaskListDomain;


@Controller
public class TaskListController {
	
	@Autowired
	private TaskListDao tasklistdao;
	
	@Autowired
	private TaskListDomain tasklist;
	
	@RequestMapping("/")
	public String mainPage(Model model) {
		model.addAttribute("message", "Welcome to my world");
		return "main";
	}
	
	@GetMapping("/add") 
	 public String addEntry(@ModelAttribute("TaskListModel") TaskListModel TaskListModel) { 
		 return "add"; 
	 }
	 
	 @PostMapping("/add") 
	 public String handleAdd(@ModelAttribute("TaskListModel") @Valid TaskListModel TaskListModel, BindingResult result, Model model) { 
		 if (result.hasErrors()) {
			 model.addAttribute("message", TaskListModel.getDescription());
			 model.addAttribute("result", result);
			 return "add";			 
		 } else {
			 this.tasklist.setDescription(TaskListModel.getDescription());
			 this.tasklist.setScheduledDate(TaskListModel.getScheduledDate());
			 this.tasklistdao.addEntry(tasklist);
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
	
}
