package com.codingdojo.dojoOverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojoOverflow.models.Answer;
import com.codingdojo.dojoOverflow.models.Question;
import com.codingdojo.dojoOverflow.repositories.QuestionRepository;

@Service
public class QuestionService {
	@Autowired
	private QuestionRepository queRepo;
	
	public List<Question> getAllQuestions(){
		return queRepo.findAll();
	}
	public Question getQuestionById(Long id) {
		Optional<Question> que = queRepo.findById(id);
		return que.orElseGet(() -> null);
	}
	public Question addQuestion(Question que) {
		return queRepo.save(que);
	}
	public Question updateQuestion(Question que) {
		return queRepo.save(que);
	}
	public Question addAnswer(Question question, Answer answer) {
		question.getAnswers().add(answer);
		return queRepo.save(question);
	}
}
