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
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.projectManager.models.Project;
import com.codingdojo.projectManager.models.Task;
import com.codingdojo.projectManager.models.User;
import com.codingdojo.projectManager.services.ProjectService;
import com.codingdojo.projectManager.services.TaskService;
import com.codingdojo.projectManager.services.UserService;

@Controller
public class ProjectController {
	@Autowired
	private UserService userServ;
	@Autowired
	private ProjectService projServ;
	@Autowired
	private TaskService taskServ;
	
	@GetMapping("/dashboard")
	public String dashboard(Model model, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/logout";
		}
		User thisUser = userServ.getUserById((Long)session.getAttribute("userId"));
		model.addAttribute("user", thisUser);
		model.addAttribute("myProjects", projServ.getAllAttachedProj(thisUser));
		model.addAttribute("projects", projServ.getAllNotAttacherdProj(thisUser));
		return "/dashboard.jsp";
	}
	@GetMapping("/projects/new")
	public String newProject(@ModelAttribute("newProject")Project project, HttpSession session, Model model) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/logout";
		}
		User thisUser = userServ.getUserById((Long)session.getAttribute("userId"));
		model.addAttribute("user", thisUser);
		return "addProject.jsp";
	}
	@GetMapping("/projects/join/{id}")
	public String joinProject(@PathVariable Long id, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/logout";
		}
		User thisUser = userServ.getUserById((Long)session.getAttribute("userId"));
		Project thisProject = projServ.getProjById(id);
		thisUser.getProjects().add(thisProject);
		userServ.updateUser(thisUser);
		return "redirect:/dashboard";
	}
	@GetMapping("/projects/leave/{id}")
	public String leaveProject(@PathVariable Long id, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/logout";
		}
		User thisUser = userServ.getUserById((Long)session.getAttribute("userId"));
		Project thisProject = projServ.getProjById(id);
		thisUser.getProjects().remove(thisProject);
		userServ.updateUser(thisUser);
		return "redirect:/dashboard";
	}
	@GetMapping("/projects/edit/{id}")
	public String newProject(@PathVariable Long id, HttpSession session, Model model) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/logout";
		}
		User thisUser = userServ.getUserById((Long)session.getAttribute("userId"));
		model.addAttribute("user", thisUser);
		model.addAttribute("project", projServ.getProjById(id));
		System.out.println(projServ.getProjById(id).getDescription());
		return "editProject.jsp";
	}
	@GetMapping("/projects/{id}")
	public String showProject(@PathVariable Long id, HttpSession session, Model model) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/logout";
		}
		User thisUser = userServ.getUserById((Long)session.getAttribute("userId"));
		model.addAttribute("user", thisUser);
		model.addAttribute("project", projServ.getProjById(id));
		return "showProject.jsp";
	}
	@GetMapping("/projects/{id}/delete")
	public String deleteProject(@PathVariable Long id, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/logout";
		}
		User thisUser = userServ.getUserById((Long)session.getAttribute("userId"));
		Project thisProj = projServ.getProjById(id);
		for(Task task:taskServ.tasksByProjId(id)) {
			taskServ.deleteTask(task);
		}
		projServ.deleteProject(thisProj);
		return "redirect:/dashboard";
	}
	
	
	
	@PostMapping("/projects/new")
	public String addProject(@Valid @ModelAttribute("newProject")Project project, BindingResult result,
			HttpSession session, Model model) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/logout";
		}
		User thisUser = userServ.getUserById((Long)session.getAttribute("userId"));
		if(result.hasErrors()) {
			model.addAttribute("user", thisUser);
			return "addProject.jsp";
		}
		Project newProject = new Project(project.getTitle(), project.getDescription(), project.getDueDate(),
				project.getLead());
		newProject.setLead(thisUser);
		projServ.createProject(newProject);
		thisUser.getProjects().add(newProject);
		userServ.updateUser(thisUser);
		return "redirect:/dashboard";
	}
	@PutMapping("/projects/edit/{id}")
	public String updateProject(@PathVariable Long id, @Valid @ModelAttribute("editProject")Project project,
			BindingResult result, HttpSession session, Model model) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/logout";
		}
		User thisUser = userServ.getUserById((Long)session.getAttribute("userId"));
		if(result.hasErrors()) {
			model.addAttribute("project", projServ.getProjById(id));
			return "editProject.jsp";
		}
		Project thisProject = projServ.getProjById(id);
		project.setUsers(thisProject.getUsers());
		project.setLead(thisUser);
		projServ.updateProject(project);
		return "redirect:/dashboard";
	}
	
}
