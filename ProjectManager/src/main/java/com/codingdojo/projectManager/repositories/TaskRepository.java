package com.codingdojo.projectManager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.projectManager.models.Project;
import com.codingdojo.projectManager.models.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
	List<Task>findByProjectIdIs(Long id);
}
