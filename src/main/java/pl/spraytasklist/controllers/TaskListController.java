package pl.spraytasklist.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import pl.spraytasklist.model.TaskList;
import pl.spraytasklist.dao.TaskListDao;


@Controller
public class TaskListController {
	
	@Autowired
	private TaskListDao tasklistdao;
	
	@Autowired
	private DataSource dataSource;
	
	Connection conn = null;
	
	@RequestMapping("/")
	public String mainPage(Model model) {
		System.out.println("main.jsp");
		try {
			conn = dataSource.getConnection();
			System.out.println(conn);
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		model.addAttribute("message", "Welcome to my world");
		return "main";
	}
	
	@GetMapping("/add") 
	 public String addEntry(@ModelAttribute("TaskListModel") TaskList TaskListModel) { 
		 return "add"; 
	 }
	 
	 @PostMapping("/add") 
	 public String handleAdd(@ModelAttribute("TaskListModel") @Valid TaskList TaskListModel, BindingResult result, Model model) { 
		 if (result.hasErrors()) {
			 model.addAttribute("message", "error");
			 model.addAttribute("result", result);
			 return "add";			 
		 } else {
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
