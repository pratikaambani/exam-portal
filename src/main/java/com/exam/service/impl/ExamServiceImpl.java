/**
 * 
 */
package com.exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.model.Question;
import com.exam.repo.QuestionRepository;
import com.exam.service.ExamService;

/**
 * @author Tejas
 *
 */
@Service
public class ExamServiceImpl implements ExamService {

	@Autowired
	private QuestionRepository questionRepo;
	
	@Override
	public List<Question> getQuestions(long userId, long examId){
		List<Question> questions = questionRepo.getQuestions(userId, examId);
		return questions;
	}
}
