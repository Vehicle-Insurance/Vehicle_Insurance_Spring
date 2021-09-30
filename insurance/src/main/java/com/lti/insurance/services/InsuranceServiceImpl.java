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
	
	public InsuranceDao getDao() {
		return dao;
	}

	public void setDao(InsuranceDao dao) {
		this.dao = dao;
	}

	@Override
	public void addOrUpdateUser(Users u) {
		// TODO Auto-generated method stub
		System.out.println("Service layer!!");
		dao.addOrUpdateUser(u);
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
	public void renewPolicy(Policy p) {
		// TODO Auto-generated method stub
		System.out.println("Service layer!!");
		dao.renewPolicy(p);
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

}
