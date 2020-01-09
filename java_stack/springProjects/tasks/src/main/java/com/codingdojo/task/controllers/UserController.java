package com.codingdojo.task.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.task.models.Task;
import com.codingdojo.task.models.User;
import com.codingdojo.task.services.TaskService;
import com.codingdojo.task.services.UserService;
import com.codingdojo.task.validator.UserValidator;




@Controller
public class UserController {
 private final UserService userService;
 private final UserValidator userValidator;
 private final TaskService taskService;
 
 public UserController(UserService userService , UserValidator userValidator , TaskService taskService) {
     this.userService = userService;
     this.userValidator = userValidator;
     this.taskService = taskService;
 }
 
 @RequestMapping("/")
 public String registerForm(@ModelAttribute("user") User user) {
     return "/task/registrationPage.jsp";
 }
 
 @RequestMapping(value="/registration", method=RequestMethod.POST)
 public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
     // if result has errors, return the registration page (don't worry about validations just now)
     // else, save the user in the database, save the user id in session, and redirect them to the /home route
	 userValidator.validate(user, result);
	 if (result.hasErrors()) {
		 return "/task/registrationPage.jsp";
	 }else {
		 User u = userService.registerUser(user);
		 session.setAttribute("user_id", u.getId());
		 return "redirect:/tasks";
	 }
 }
 
 @RequestMapping(value="/login", method=RequestMethod.POST)
 public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session,@ModelAttribute("user") User usermodel) {
     // if the user is authenticated, save their user id in session
     // else, add error messages and return the login page
	 User user = userService.findByEmail(email);
	 if (user == null) {
		 model.addAttribute("error","No such User");
	 }else if (!userService.authenticateUser(email, password)) {
		 model.addAttribute("error","Invalid Password");
	 }else {
		 session.setAttribute("user_id", user.getId());
		 return "redirect:/tasks";
	 }
	 return "/task/registrationPage.jsp";
 }
 
 @RequestMapping("/tasks")
 public String home(HttpSession session, Model model) {
     // get user from session, save them in the model and return the home page
	 if(session.getAttribute("user_id")!= null) {
		 Long userId = (Long) session.getAttribute("user_id");
		 User u = userService.findUserById(userId);
		 model.addAttribute("user", u);
		 // get all tasks and list them 
		 List<Task> tasklist = taskService.allTasks();
		 model.addAttribute("tasks", tasklist);
		 return "/task/homepage.jsp";
	 }else {
		 return "redirect:/";
	 }
	 
 }
 
 @RequestMapping("/tasks/new")
 public String display(@ModelAttribute("task") Task task , Model model , HttpSession session) {
	 if (session.getAttribute("user_id")!= null) {
		 List<User> allusers = userService.findAll();
		 model.addAttribute("users" , allusers);
		 Long userId = (Long) session.getAttribute("user_id");
		 User u =userService.findUserById(userId);
		 model.addAttribute("currentUser", u);
		 return "/task/task.jsp";
		 
	 }else {
		 return "redirect:/";
	 }
 }
 
 @RequestMapping(value ="tasks/new" , method=RequestMethod.POST)
 public String createNewTask(@Valid @ModelAttribute("task") Task task , BindingResult result, Model model, HttpSession session , RedirectAttributes limitError) {
	 Long userId = (Long)session.getAttribute("user_id");
	 User u = userService.findUserById(userId);
	 model.addAttribute("user" , u);
	 
	 if(result.hasErrors()) {
		 System.out.println("result has errors");
		 List<User> allusers = userService.findAll();
		 model.addAttribute("users", allusers);
		 return "task.jsp";
	 }else {
		 
		Long tid = (Long) task.getAssignee().getId();
		User myAssignee = userService.findUserById(tid);
		List<Task> myList = myAssignee.getAssigned_tasks();
		
		if(myList.size()>=3) {
			List<User> allusers = userService.findAll();
			model.addAttribute("users",allusers);
			return "redirect:/tasks";
		}else {
			Task newTask = taskService.createTask(task);
			newTask.setCreator(u);
			taskService.updateTask(newTask);
			return "redirect:/tasks";
		}
		
		
		
	 }
	 
 }
 
 @RequestMapping("/tasks/{id}")
 public String displayTask(Model model, HttpSession session, @PathVariable("id") Long taskId) {
	 //find task by Id
	 Task thisTask = taskService.getTask(taskId);
	 model.addAttribute("task", thisTask);
	 
	 // find logged in user 
	 Long userId = (Long) session.getAttribute("user_id");
	 User u = userService.findUserById(userId);
	 model.addAttribute("currentUserId",u.getId());
	 return "/task/showtask.jsp";
	 
 }
 
 @RequestMapping("/tasks/{id}/edit")
 public String editTask(Model model, @ModelAttribute("edittask") Task myTask, @PathVariable("id") Long taskId,HttpSession session) {
	 
	Long userId = (Long) session.getAttribute("user_id");
	User u = userService.findUserById(userId);
	Task editingTask = taskService.getTask(taskId);
	
	if (u.getId() == editingTask.getCreator().getId()) {
		List<User> allUsers = userService.findAll();
		model.addAttribute("creator", editingTask.getCreator());
		model.addAttribute("edittask", editingTask);
		model.addAttribute("users", allUsers);
		model.addAttribute("id", editingTask.getId());
		return "/task/edit.jsp";
	}else {
		return "redirect:/tasks";
	}
	
 }
 
 @RequestMapping(value ="/tasks/{id}/edit" , method = RequestMethod.POST)
 public String updateTask(Model model , @Valid @ModelAttribute("edittask") Task myTask , BindingResult result , @PathVariable("id") Long taskId) {
	 if (result.hasErrors()) {
		 List<User> allusers = userService.findAll();
		 model.addAttribute("users", allusers);
		 return "edittask.jsp";
	 }else {
		 taskService.createTask(myTask);
		 return "redirect:/tasks";
	 }
 }
 
 @RequestMapping("/tasks/{id}/delete")
 public String deleteTask(@PathVariable("id") Long myId) {
	 Task deltask = taskService.getTask(myId);
	 if (deltask!= null){
		 taskService.deleteTask(myId);
		 return "redirect:/tasks";
	 }else {
		 return "redirect:/tasks";
	 }
 }
 
 
 
 
 
 @RequestMapping("/logout")
 public String logout(HttpSession session) {
     // invalidate session
     // redirect to login page
	 session.invalidate();
	 return "redirect:/";
 }
}
