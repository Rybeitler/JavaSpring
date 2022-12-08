package com.codingdojo.dojoOverflow.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.dojoOverflow.models.Answer;
import com.codingdojo.dojoOverflow.models.Question;
import com.codingdojo.dojoOverflow.models.Tag;
import com.codingdojo.dojoOverflow.services.AnswerService;
import com.codingdojo.dojoOverflow.services.QuestionService;
import com.codingdojo.dojoOverflow.services.TagService;

@Controller
public class MainController {
	@Autowired
	private QuestionService queServ;
	@Autowired
	private AnswerService ansServ;
	@Autowired
	private TagService tagServ;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("questions", queServ.getAllQuestions());
		return "index.jsp";
	}
	@GetMapping("/questions/new")
	public String newQuestion(@ModelAttribute("newQuestion")Question question) {
		return "addQuestion.jsp";
	}
	@GetMapping("/answers/{id}")
	public String answersPage(@PathVariable Long id, @ModelAttribute("newAnswer")Answer answer, Model model) {
		model.addAttribute("question", queServ.getQuestionById(id));
		return "addAnswer.jsp";
	}
	
	@PostMapping("/questions/new")
	public String askQuestion(@Valid @ModelAttribute("newQuestion")Question question,
			Model model, BindingResult result,
			@RequestParam(value="theTags")String theTags) {
		if(result.hasErrors()) {
			return "newQuestion.jsp";
		}else {
			List<Tag> questionTags = tagServ.checkForTags(theTags);
			if(questionTags!=null) {
				Question theQuestion = new Question(question.getQuestionText());
				theQuestion.setTags(questionTags);
				queServ.addQuestion(theQuestion);
			}else {
				model.addAttribute("errorMsg","Max of 3 tags all lowercase, seperated by commas");
				return "addQuestion.jsp";
			}
		}
		return "redirect:/";
	}
	@PostMapping("/answers/{id}")
	public String addAnswer(@PathVariable Long id, @ModelAttribute("newAnswer")Answer answer, Model model,
			BindingResult result) {
		if(result.hasErrors()) {
			model.addAttribute("question", queServ.getQuestionById(id));
			return "addAnswer.jsp";
		}
		Answer newAnswer = new Answer(answer.getAnswerText());
		Question question = queServ.getQuestionById(id);
		newAnswer.setQuestion(question);
		ansServ.addAnswer(newAnswer);
		return "redirect:/answers/"+id;
	}
}
