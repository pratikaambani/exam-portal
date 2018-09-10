/**
 * 
 */
package com.exam.service;

import java.util.List;

import com.exam.model.Question;

/**
 * @author Tejas
 *
 */
public interface ExamService {

	List<Question> getQuestions(long userId, long examId);
}
