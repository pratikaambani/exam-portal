package com.exam.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.exam.model.users.User;

/**
 * 
 * @author Tejas
 *
 */
@Entity
@Table(name = "user_exam")
public class UserExam implements Serializable {

	private static final long serialVersionUID = 309190045747627912L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "exam_id")
	private Exam exam;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "question_id")
	private Question question;

	@Column(name = "answer")
	@Enumerated(EnumType.STRING)
	private AnswerOption answerOption;
	
	@Column(name = "test_series")
	private int testSeries;
	
	protected UserExam() {
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the exam
	 */
	public Exam getExam() {
		return exam;
	}

	/**
	 * @param exam the exam to set
	 */
	public void setExam(Exam exam) {
		this.exam = exam;
	}

	/**
	 * @return the question
	 */
	public Question getQuestion() {
		return question;
	}

	/**
	 * @param question the question to set
	 */
	public void setQuestion(Question question) {
		this.question = question;
	}

	/**
	 * @return the answerOption
	 */
	public AnswerOption getAnswerOption() {
		return answerOption;
	}

	/**
	 * @param answerOption the answerOption to set
	 */
	public void setAnswerOption(AnswerOption answerOption) {
		this.answerOption = answerOption;
	}

	/**
	 * @return the testSeries
	 */
	public int getTestSeries() {
		return testSeries;
	}

	/**
	 * @param testSeries the testSeries to set
	 */
	public void setTestSeries(int testSeries) {
		this.testSeries = testSeries;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserExam [id=");
		builder.append(id);
		builder.append(", user=");
		builder.append(user);
		builder.append(", exam=");
		builder.append(exam);
		builder.append(", question=");
		builder.append(question);
		builder.append(", answerOption=");
		builder.append(answerOption);
		builder.append(", testSeries=");
		builder.append(testSeries);
		builder.append("]");
		return builder.toString();
	}

}