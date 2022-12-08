package com.codingdojo.dojoOverflow.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojoOverflow.models.Answer;
import com.codingdojo.dojoOverflow.repositories.AnswerRepository;

@Service
public class AnswerService {
	@Autowired
	private AnswerRepository ansRepo;
	
	public Answer addAnswer(Answer answer) {
		return ansRepo.save(answer);
	}
}
