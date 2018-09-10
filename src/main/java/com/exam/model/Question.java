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
 * This is master table of all the question.  
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

	@Column(name = "A")
	private String optionA;

	@Column(name = "B")
	private String optionB;

	@Column(name = "C")
	private String optionC;

	@Column(name = "D")
	private String optionD;

	@Column(name = "answer")
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
	 * @param id the id to set
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
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * @return the optionA
	 */
	public String getOptionA() {
		return optionA;
	}

	/**
	 * @param optionA the optionA to set
	 */
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	/**
	 * @return the optionB
	 */
	public String getOptionB() {
		return optionB;
	}

	/**
	 * @param optionB the optionB to set
	 */
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	/**
	 * @return the optionC
	 */
	public String getOptionC() {
		return optionC;
	}

	/**
	 * @param optionC the optionC to set
	 */
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	/**
	 * @return the optionD
	 */
	public String getOptionD() {
		return optionD;
	}

	/**
	 * @param optionD the optionD to set
	 */
	public void setOptionD(String optionD) {
		this.optionD = optionD;
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
	 * @return the answerDescription
	 */
	public String getAnswerDescription() {
		return answerDescription;
	}

	/**
	 * @param answerDescription the answerDescription to set
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
	 * @param questionType the questionType to set
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
	 * @param questionLevel the questionLevel to set
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
	 * @param askInYears the askInYears to set
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
		builder.append(", optionA=");
		builder.append(optionA);
		builder.append(", optionB=");
		builder.append(optionB);
		builder.append(", optionC=");
		builder.append(optionC);
		builder.append(", optionD=");
		builder.append(optionD);
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