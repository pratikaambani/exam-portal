package com.exam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Tejas
 *
 */
@Entity
@Table(name= "exam")
public class Exam {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "exam_type")
	@Enumerated(EnumType.STRING)
	private ExamType examType;

	@Column(name = "is_mock_exam")
	private boolean mockExam;
	
	@Column(name = "number_of_questions")
	private int numberOfQuestions;

	//This time is in Minutes
	@Column(name = "total_time")
	private int totalTime;

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
	 * @return the examType
	 */
	public ExamType getExamType() {
		return examType;
	}

	/**
	 * @param examType the examType to set
	 */
	public void setExamType(ExamType examType) {
		this.examType = examType;
	}

	/**
	 * @return the numberOfQuestions
	 */
	public int getNumberOfQuestions() {
		return numberOfQuestions;
	}

	/**
	 * @param numberOfQuestions the numberOfQuestions to set
	 */
	public void setNumberOfQuestions(int numberOfQuestions) {
		this.numberOfQuestions = numberOfQuestions;
	}

	/**
	 * @return the totalTime
	 */
	public int getTotalTime() {
		return totalTime;
	}

	/**
	 * @param totalTime the totalTime to set
	 */
	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Exam [id=");
		builder.append(id);
		builder.append(", examType=");
		builder.append(examType);
		builder.append(", numberOfQuestions=");
		builder.append(numberOfQuestions);
		builder.append(", totalTime=");
		builder.append(totalTime);
		builder.append("]");
		return builder.toString();
	}
	
	
}
