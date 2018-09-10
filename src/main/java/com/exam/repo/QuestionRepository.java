/**
 * 
 */
package com.exam.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.exam.model.Question;

/**
 * @author Tejas
 *
 */
public interface QuestionRepository extends CrudRepository<Question, Long> {

	@Query(value="select * from question q where q.id in (select question_id from user_exam where user_id = :userId and exam_id = :examId)", 
			nativeQuery=true)
	List<Question> getQuestions(@Param("userId") long userId, @Param("examId") long examId);
}
