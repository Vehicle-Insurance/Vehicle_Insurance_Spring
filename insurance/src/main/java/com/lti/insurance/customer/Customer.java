package com.lti.insurance.customer;

import java.time.LocalDate;

import com.lti.insurance.beans.Users;
import com.lti.insurance.daos.InsuranceDao;
import com.lti.insurance.daos.InsuranceDaoImpl;

public class Customer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsuranceDao dao=new InsuranceDaoImpl();
		Users u=new Users(101,"User1","User1@gmail.com","9876598765","password1",LocalDate.parse("1999-01-10"),"176717271762");
		dao.addOrUpdateUser(u);
	}

}
