package com.lti.insurance.beans;

public class LoginStatus {

	String userStatus;
	int userId;
	String userName;
	String  userEmail;
	String  adminEmail;
	String adminStatus;
	int adminId;
	public LoginStatus() {
		super();
	}
	public LoginStatus(String userStatus, int userId, String userName, String userEmail, String adminEmail,
			String adminStatus, int adminId) {
		super();
		this.userStatus = userStatus;
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.adminEmail = adminEmail;
		this.adminStatus = adminStatus;
		this.adminId = adminId;
	}
	@Override
	public String toString() {
		return "LoginStatus [userStatus=" + userStatus + ", userId=" + userId + ", userName=" + userName
				+ ", userEmail=" + userEmail + ", adminEmail=" + adminEmail + ", adminStatus=" + adminStatus
				+ ", adminId=" + adminId + "]";
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
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
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public String getAdminStatus() {
		return adminStatus;
	}
	public void setAdminStatus(String adminStatus) {
		this.adminStatus = adminStatus;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
}
