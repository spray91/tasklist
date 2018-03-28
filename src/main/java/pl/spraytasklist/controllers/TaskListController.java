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

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import javax.sql.DataSource;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;

import pl.spraytasklist.model.Category;
import pl.spraytasklist.model.TaskList;
import pl.spraytasklist.dao.CategoryDao;
import pl.spraytasklist.dao.TaskListDao;


@Controller
public class TaskListController {
	
	@Autowired
	protected TaskListDao takslistdao;
	
	@Autowired
	protected CategoryDao categorydao;
	/*@Autowired
	private DataSource dataSource;
	
	Connection conn = null;*/
	
	@RequestMapping("/")
	public String mainPage(Model model) {
		categorydao.save(new Category("asd","aa"));
		/*Date test = new Date();
		Pattern datePattern = Pattern.compile("[0-3][0-9]-[0-1][0-9]-[1-2][0-9]{3}");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        if (datePattern.matcher("11-11-1991").matches()) {
            try {
           		test = sdf.parse("11-11-1991");
           	} catch (ParseException pe) {
           		System.out.println("It is something wrong with date.");
           	}
        }
		takslistdao.save(new TaskList("Desc","Cat",test));
		/*System.out.println("main.jsp");
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
		}*/
		
		model.addAttribute("message", categorydao.findById(1));
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
			 /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			 Date schDatee = new Date();
	            try {
	            	schDatee = sdf.parse(schDate);
	            } catch (Exception ex) {
	                System.out.println(ex);
			 }*/
			 takslistdao.save(TaskList);

			 
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
			 categorydao.save(category);		 
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
