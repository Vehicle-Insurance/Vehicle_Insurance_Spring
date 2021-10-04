package com.lti.insurance.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.insurance.beans.Admin;
import com.lti.insurance.beans.Claims;
import com.lti.insurance.beans.LoginStatus;
import com.lti.insurance.beans.Policy;
import com.lti.insurance.beans.PolicyTickets;
import com.lti.insurance.beans.Transaction;
import com.lti.insurance.beans.Users;
import com.lti.insurance.beans.Vehicle;
import com.lti.insurance.daos.InsuranceDao;

@Service("insuranceService")
public class InsuranceServiceImpl implements InsuranceService {

	@Autowired
	private InsuranceDao dao;
	
	@Autowired
	private EmailServices emailService;
	
	public InsuranceDao getDao() {
		return dao;
	}

	public void setDao(InsuranceDao dao) {
		this.dao = dao;
	}

	@Override
	public Users addOrUpdateUser(Users u) {
		// TODO Auto-generated method stub
		System.out.println("Service layer!!");
		Users u1=dao.addOrUpdateUser(u);
		if(u1.getUserId()>0) {
			String subject="Registration Confirmation";
            String text="Hi "+u1.getUserName()+" You have succcessfully registered";
            emailService.sendEmailForNewRegistration(u1.getUserEmail(),text,subject);
            return u1;
		}
		return null;
	}

	@Override
	public void addOrUpdateAdmin(Admin a) {
		// TODO Auto-generated method stub
		System.out.println("Service layer!!");
		dao.addOrUpdateAdmin(a);
	}


	@Override
	public Vehicle addOrUpdateVehicle(Vehicle v) {
		// TODO Auto-generated method stub
		System.out.println("Service layer!!");
		return dao.addOrUpdateVehicle(v);

	}

	@Override
	public Policy addOrUpdatePolicy(Policy p) {
		// TODO Auto-generated method stub
		System.out.println("Service layer!!");
		return dao.addOrUpdatePolicy(p);
	}

	@Override
	public void addOrUpdatePolicyTickets(PolicyTickets pt) {
		// TODO Auto-generated method stub
		System.out.println("Service layer!!");
		dao.addOrUpdatePolicyTickets(pt);
	}

	@Override
	public Policy renewPolicy(Policy p) {
		// TODO Auto-generated method stub
		System.out.println("Service layer!!");
		return dao.renewPolicy(p);
	}

	@Override
	public Transaction addTransaction(Transaction t) {
		// TODO Auto-generated method stub
		System.out.println("Service layer!!");
		return dao.addTransaction(t);
	}

	@Override
	public Claims addOrUpdateCliam(Claims c) {
		// TODO Auto-generated method stub
		return dao.addOrUpdateCliam(c);
	}

	@Override
	public List<Policy> getPolicies(int userId) {
		// TODO Auto-generated method stub
		System.out.println("Service layer!!");
		return dao.getPolicies(userId);
	}

	@Override
	public List<Claims> getPendingCliams() {
		// TODO Auto-generated method stub
		System.out.println("Service layer!!");
		return dao.getPendingCliams();
	}

	@Override
	public List<PolicyTickets> getPendingPolicyTickets() {
		// TODO Auto-generated method stub
		return dao.getPendingPolicyTickets();
	}

	@Override
	public List<Claims> getCliamsByUser(int id) {
		// TODO Auto-generated method stub
		System.out.println("Service layer!!");
		return dao.getCliamsByUser(id);
	}

	@Override
	public List<Vehicle> getVehiclesByUser(int id) {
		// TODO Auto-generated method stub
		System.out.println("Service layer!!");
		return dao.getVehiclesByUser(id);
	}

	@Override
	public void removePolicy(Policy p) {
		// TODO Auto-generated method stub
		System.out.println("Service layer!!");
		dao.removePolicy(p);
	}

	@Override
	public void removeClaim(Claims c) {
		// TODO Auto-generated method stub
		System.out.println("Service layer!!");
		dao.removeClaim(c);

	}

	@Override
	public void removePolicyById(int id) {
		// TODO Auto-generated method stub
		System.out.println("Service layer!!");
		dao.removePolicyById(id);

	}

	@Override
	public void removeClaimById(int id) {
		// TODO Auto-generated method stub
		System.out.println("Service layer!!");
		dao.removeClaimById(id);

	}

	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return dao.getAllUsers();
	}

	@Override
	public LoginStatus loginUser(String userId, String pass) {
		// TODO Auto-generated method stub
		return dao.loginUser(userId,pass);
	}

	@Override
	public Users getUserById(int id) {
		// TODO Auto-generated method stub
		return dao.getUserById(id);
	}

	@Override
	public Vehicle getVehicle(int id) {
		// TODO Auto-generated method stub
		return dao.getVehicle(id);
	}

	@Override
	public Transaction getTransaction(int tId) {
		// TODO Auto-generated method stub
		return dao.getTransaction(tId);
	}

	@Override
	public Policy getPolicyByClaim(int id) {
		// TODO Auto-generated method stub
		return dao.getPolicyByClaim(id);
	}

	@Override
	public Policy getPolicy(int id) {
		// TODO Auto-generated method stub
		return dao.getPolicy(id);
	}
	
	public int Generateotp(String userEmail) {
        Users u=dao.getUserByEmail(userEmail);
        int otp =dao.Generateotp();
        String subject="OTP";
        String text="Hi "+" "+ u.getUserName()+" this is your generated otp "+otp;
        emailService.sendEmailForNewRegistration(u.getUserEmail(),text,subject);
        System.out.println("Mail sent");
        return otp;
    }

	@Override
	public int setPass(String mail, String pass) {
		// TODO Auto-generated method stub
		Users u=dao.getUserByEmail(mail);
		return dao.setPass(u,pass);
		
	}

}
