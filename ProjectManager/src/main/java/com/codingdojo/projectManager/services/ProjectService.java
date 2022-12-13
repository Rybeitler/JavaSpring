package com.codingdojo.projectManager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.projectManager.models.Project;
import com.codingdojo.projectManager.models.User;
import com.codingdojo.projectManager.repositories.ProjectRepository;

@Service
public class ProjectService {
	@Autowired
	private ProjectRepository projRepo;
	
	public Project createProject(Project proj) {
		return projRepo.save(proj);
	}
	
	public Project getProjById(Long id) {
		Optional<Project> proj = projRepo.findById(id); 
		return proj.orElseGet(()->null);
	}
	public Project updateProject(Project proj) {
		return projRepo.save(proj);
	}
	public List<Project>getAllAttachedProj(User user){
		return projRepo.findAllByUsers(user);
	}
	public List<Project>getAllNotAttacherdProj(User user){
		return projRepo.findAllByUsersNotContains(user);
	}
	public void deleteProject(Project project) {
		projRepo.delete(project);
	}
}
