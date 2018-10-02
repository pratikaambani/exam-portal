package com.exam.dto.users;

import java.io.Serializable;

import javax.persistence.Column;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.exam.validation.constraint.FieldMatch;
import com.exam.validation.constraint.MobiletNumberConstraint;

/**
 * 
 * @author Tejas
 *
 */
@FieldMatch(first = "password", second = "confirmPassword", message = "The password fields must match")
public class UserDTO implements Serializable {

	private static final long serialVersionUID = 884639458661274420L;

	@Email(message = "*Please provide a valid Email")
	@NotEmpty(message = "*Please provide an email")
	private String email;

	@Length(min = 5, message = "Your password must have at least 5 characters")
	@NotEmpty(message = "*Please provide your password")
	private String password;

	@Length(min = 5, message = "Your password must have at least 5 characters")
	@NotEmpty(message = "*Please provide Confirm password")
	private String confirmPassword;

	@Column(name = "first_name")
	@NotEmpty(message = "*Please provide your first name")
	private String firstName;

	@Column(name = "last_name")
	@NotEmpty(message = "*Please provide your last name")
	private String lastName;

	@Length(min = 10, message = "Your mobile number must have 10 digit.")
	@NotEmpty(message = "*Please provide your mobile number.")
	@MobiletNumberConstraint(message = "Enter valid mobile number.")
	private String mobile;

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the confirmPassword
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}

	/**
	 * @param confirmPassword
	 *            the confirmPassword to set
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile
	 *            the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}