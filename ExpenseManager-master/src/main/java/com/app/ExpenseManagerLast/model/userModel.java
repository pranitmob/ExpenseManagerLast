
package com.app.ExpenseManagerLast.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "user")
public class userModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;

	@NotEmpty(message = "first name cannot be empty")
	private String firstName;

	@NotEmpty(message = "last name cannot be empty")
	private String lastName;

	@Email
	private String emailId;

	private String password;

	@Transient
	private String confirmPassword;

	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<ExpenseModel> expenses;

	public userModel() {
		// TODO Auto-generated constructor stub
	}

	public userModel(int userId, String firstName, String lastName, String emailId, String password,
			String confirmPassword, List<ExpenseModel> expenses) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.expenses = expenses;
	}

	public List<ExpenseModel> getExpenses() {
		return expenses;
	}

	public void setExpenses(List<ExpenseModel> expenses) {
		this.expenses = expenses;
	}

	@Column(name = "user_id")
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "first_name")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "email")
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Transient
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public String toString() {
		return "userModel [firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId + ", password="
				+ password + ", confirmPassword=" + confirmPassword + "]";
	}

	// convience methods
}
