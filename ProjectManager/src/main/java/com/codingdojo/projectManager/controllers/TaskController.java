package com.codingdojo.projectManager.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.projectManager.models.Project;
import com.codingdojo.projectManager.models.Task;
import com.codingdojo.projectManager.models.User;
import com.codingdojo.projectManager.services.ProjectService;
import com.codingdojo.projectManager.services.TaskService;
import com.codingdojo.projectManager.services.UserService;

@Controller
public class TaskController {
	@Autowired
	private TaskService taskServ;
	@Autowired
	private ProjectService projServ;
	@Autowired
	private UserService userServ;
	
	@GetMapping("/projects/{id}/tasks")
	public String taskPage(@PathVariable Long id, @ModelAttribute("newTask")Task task, HttpSession session, Model model) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/logout";
		}
		User thisUser = userServ.getUserById((Long)session.getAttribute("userId"));
		model.addAttribute("project", projServ.getProjById(id));
		return "tasks.jsp";
	}
	
	@PostMapping("/projects/{id}/tasks")
	public String addTask(@PathVariable Long id, @Valid @ModelAttribute("newTask")Task task, BindingResult result,
			HttpSession session, Model model) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/logout";
		}
		User thisUser = userServ.getUserById((Long)session.getAttribute("userId"));
		Project thisProj = projServ.getProjById(id);
		if(result.hasErrors()) {
			model.addAttribute("project", thisProj);
			return "tasks.jsp";
		}
		Task newTask = new Task(task.getText(), task.getUser(), task.getProject());
		newTask.setUser(thisUser);
		newTask.setProject(thisProj);
		taskServ.createTask(newTask);
		thisProj.getTasks().add(newTask);
		projServ.updateProject(thisProj);
		thisUser.getTasks().add(newTask);
		userServ.updateUser(thisUser);
		return "redirect:/projects/"+id+"/tasks";
	}
}
