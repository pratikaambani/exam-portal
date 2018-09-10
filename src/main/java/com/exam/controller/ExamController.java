package com.exam.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.exam.model.Question;
import com.exam.model.User;
import com.exam.service.ExamService;
import com.exam.service.UserService;

/**
 * 
 * @author Tejas
 *
 */
@RestController
public class ExamController {

	@Autowired
	private ExamService examService;

	@Autowired
	private UserService userService;

	@GetMapping(value="/questions/{examId}/{userId}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Question> getQuestion(@PathVariable long examId, @PathVariable long userId){
		List<Question> questions = examService.getQuestions(examId, userId);
		return questions;
		//return null;
	}
	
	@RequestMapping(value="/admin/questions/{examId}", method = RequestMethod.GET)
	public ModelAndView home(@PathVariable(value = "examId") long examId){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		User user = userService.findUserByEmail(auth.getName());
		List<Question> questions = examService.getQuestions(examId, user.getId());
		
		modelAndView.addObject("userName", "Welcome " + user.getFirstName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		System.out.println(questions);
		modelAndView.addObject("questions", questions);
		modelAndView.setViewName("admin/questions");
		return modelAndView;
	}
	
	
}
