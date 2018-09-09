package com.exam.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author Tejas
 *
 */
@Entity
@Table(name = "user_question")
public class UserQuestion implements Serializable {

	private static final long serialVersionUID = 309190045747627912L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "attempt")
	private int attempt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "question_id")
	private Question question;

	protected UserQuestion() {
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
	 * @return the attempt
	 */
	public int getAttempt() {
		return attempt;
	}

	/**
	 * @param attempt
	 *            the attempt to set
	 */
	public void setAttempt(int attempt) {
		this.attempt = attempt;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the question
	 */
	public Question getQuestion() {
		return question;
	}

	/**
	 * @param question
	 *            the question to set
	 */
	public void setQuestion(Question question) {
		this.question = question;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserQuestion [id=");
		builder.append(id);
		builder.append(", attempt=");
		builder.append(attempt);
		builder.append(", user=");
		builder.append(user);
		builder.append(", question=");
		builder.append(question);
		builder.append("]");
		return builder.toString();
	}

}