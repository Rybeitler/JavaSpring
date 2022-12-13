package com.codingdojo.projectManager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.projectManager.models.Project;
import com.codingdojo.projectManager.models.Task;
import com.codingdojo.projectManager.repositories.TaskRepository;

@Service
public class TaskService {
	@Autowired
	private TaskRepository taskRepo;
	
	public Task createTask(Task task) {
		return taskRepo.save(task);
	}
	public List<Task> tasksByProjId(Long id){
		return taskRepo.findByProjectIdIs(id);
	}
	public void deleteTask(Task task) {
		taskRepo.delete(task);
	}
	
}
