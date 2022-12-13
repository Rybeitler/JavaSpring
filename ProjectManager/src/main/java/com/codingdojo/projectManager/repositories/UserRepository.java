package com.codingdojo.projectManager.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.projectManager.models.Project;
import com.codingdojo.projectManager.models.Task;
import com.codingdojo.projectManager.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	Optional<User> findByEmail(String email);
	
	List<User>findAllByProjects(Project project);
	List<User>findAllByProjectsNotContains(Project project);
	List<User>findAllByTasks(Task task);
}