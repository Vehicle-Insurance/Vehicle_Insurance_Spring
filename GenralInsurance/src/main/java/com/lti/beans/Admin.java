package com.lti.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ADMIN")
public class Admin {

	@Id
	@Column(name="ADMIN_ID")
	private int admin_id;
	
	@Column(name="ADMIN_NAME")
	private String admin_name;
	
	@Column(name="ADMIN_EMAIL")
	private String admin_email;
	
	@Column(name="ADMIN_PASSWORD")
	private String admin_password;
	
	@Column(name="ADMIN_PHONE")
	private String admin_phone;

	public Admin(int admin_id, String admin_name, String admin_email, String admin_password, String admin_phone) {
		super();
		this.admin_id = admin_id;
		this.admin_name = admin_name;
		this.admin_email = admin_email;
		this.admin_password = admin_password;
		this.admin_phone = admin_phone;
	}

	public Admin() {
		super();
	}

	public int getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

	public String getAdmin_email() {
		return admin_email;
	}

	public void setAdmin_email(String admin_email) {
		this.admin_email = admin_email;
	}

	public String getAdmin_password() {
		return admin_password;
	}

	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}

	public String getAdmin_phone() {
		return admin_phone;
	}

	public void setAdmin_phone(String admin_phone) {
		this.admin_phone = admin_phone;
	}

	@Override
	public String toString() {
		return "Admin [admin_id=" + admin_id + ", admin_name=" + admin_name + ", admin_email=" + admin_email
				+ ", admin_password=" + admin_password + ", admin_phone=" + admin_phone + "]";
	}
	
	
}
