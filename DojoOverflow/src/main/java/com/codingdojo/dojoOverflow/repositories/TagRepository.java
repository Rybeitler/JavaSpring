package com.codingdojo.dojoOverflow.repositories;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dojoOverflow.models.Question;
import com.codingdojo.dojoOverflow.models.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {
	Tag findBySubjectIs(String tag);
	List<Tag>findAll();
	List<Tag>findAllByQuestions(Question question);
}
