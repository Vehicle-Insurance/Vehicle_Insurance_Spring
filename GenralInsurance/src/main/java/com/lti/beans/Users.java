package com.lti.beans;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class Users {
	
	@Id
	@Column(name="USER_ID")
	private int userId;
	
	@Column(name="USER_NAME")
	private String userName;
	
	@Column(name="USER_EMAIL")
	private String userEmail;
	
	@Column(name="USER_PHONE")
	private String userPhone;

	@Column(name="USER_PASSWORD")
	private String userPassword;
	
	@Column(name="USER_DATEOFBIRTH")
	private LocalDate userDateOfBirth;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public LocalDate getUserDateOfBirth() {
		return userDateOfBirth;
	}

	public void setUserDateOfBirth(LocalDate userDateOfBirth) {
		this.userDateOfBirth = userDateOfBirth;
	}

	public Users(int userId, String userName, String userEmail, String userPhone, String userPassword,
			LocalDate userDateOfBirth) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.userPassword = userPassword;
		this.userDateOfBirth = userDateOfBirth;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userPhone="
				+ userPhone + ", userPassword=" + userPassword + ", userDateOfBirth=" + userDateOfBirth + "]";
	}

	public Users() {
		super();
	}
	
	

}
