package com.exam.model;

import java.io.Serializable;

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
@Table(name = "question")
public class Question implements Serializable {

	private static final long serialVersionUID = 870943769304156912L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "question")
	private String question;

	@Column(name = "option_1")
	private String option1;

	@Column(name = "option_2")
	private String option2;

	@Column(name = "option_3")
	private String option3;

	@Column(name = "option_4")
	private String option4;

	@Column(name = "answer_option")
	@Enumerated(EnumType.STRING)
	private AnswerOption answerOption;

	@Column(name = "answer_description", length=4000)
	private String answerDescription;

	@Column(name = "question_type")
	@Enumerated(EnumType.STRING)
	private QuestionType questionType;

	@Column(name = "question_level")
	@Enumerated(EnumType.STRING)
	private QuestionLevel questionLevel;

	@Column(name = "ask_in_years")
	private String askInYears;

	protected Question() {
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * @param question
	 *            the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * @return the option1
	 */
	public String getOption1() {
		return option1;
	}

	/**
	 * @param option1
	 *            the option1 to set
	 */
	public void setOption1(String option1) {
		this.option1 = option1;
	}

	/**
	 * @return the option2
	 */
	public String getOption2() {
		return option2;
	}

	/**
	 * @param option2
	 *            the option2 to set
	 */
	public void setOption2(String option2) {
		this.option2 = option2;
	}

	/**
	 * @return the option3
	 */
	public String getOption3() {
		return option3;
	}

	/**
	 * @param option3
	 *            the option3 to set
	 */
	public void setOption3(String option3) {
		this.option3 = option3;
	}

	/**
	 * @return the option4
	 */
	public String getOption4() {
		return option4;
	}

	/**
	 * @param option4
	 *            the option4 to set
	 */
	public void setOption4(String option4) {
		this.option4 = option4;
	}

	/**
	 * @return the answerOption
	 */
	public AnswerOption getAnswerOption() {
		return answerOption;
	}

	/**
	 * @param answerOption
	 *            the answerOption to set
	 */
	public void setAnswerOption(AnswerOption answerOption) {
		this.answerOption = answerOption;
	}

	/**
	 * @return the answerDescription
	 */
	public String getAnswerDescription() {
		return answerDescription;
	}

	/**
	 * @param answerDescription
	 *            the answerDescription to set
	 */
	public void setAnswerDescription(String answerDescription) {
		this.answerDescription = answerDescription;
	}

	/**
	 * @return the questionType
	 */
	public QuestionType getQuestionType() {
		return questionType;
	}

	/**
	 * @param questionType
	 *            the questionType to set
	 */
	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}

	/**
	 * @return the questionLevel
	 */
	public QuestionLevel getQuestionLevel() {
		return questionLevel;
	}

	/**
	 * @param questionLevel
	 *            the questionLevel to set
	 */
	public void setQuestionLevel(QuestionLevel questionLevel) {
		this.questionLevel = questionLevel;
	}

	/**
	 * @return the askInYears
	 */
	public String getAskInYears() {
		return askInYears;
	}

	/**
	 * @param askInYears
	 *            the askInYears to set
	 */
	public void setAskInYears(String askInYears) {
		this.askInYears = askInYears;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Question [id=");
		builder.append(id);
		builder.append(", question=");
		builder.append(question);
		builder.append(", option1=");
		builder.append(option1);
		builder.append(", option2=");
		builder.append(option2);
		builder.append(", option3=");
		builder.append(option3);
		builder.append(", option4=");
		builder.append(option4);
		builder.append(", answerOption=");
		builder.append(answerOption);
		builder.append(", answerDescription=");
		builder.append(answerDescription);
		builder.append(", questionType=");
		builder.append(questionType);
		builder.append(", questionLevel=");
		builder.append(questionLevel);
		builder.append(", askInYears=");
		builder.append(askInYears);
		builder.append("]");
		return builder.toString();
	}

}