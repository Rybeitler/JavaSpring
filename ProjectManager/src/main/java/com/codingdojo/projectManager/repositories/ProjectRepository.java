package com.codingdojo.projectManager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.projectManager.models.Project;
import com.codingdojo.projectManager.models.User;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
	List<Project>findAllByUsers(User user);
	List<Project>findAllByUsersNotContains(User user);
}
