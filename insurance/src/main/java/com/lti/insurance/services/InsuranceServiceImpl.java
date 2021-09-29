package com.lti.insurance.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.insurance.beans.Admin;
import com.lti.insurance.beans.Claims;
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
	public String login(int userId, String password) {
		// TODO Auto-generated method stub
		String msg=dao.login(userId, password);
		return msg;
	}

	@Override
	public void addOrUpdateVehicle(Vehicle v) {
		// TODO Auto-generated method stub
		System.out.println("Service layer!!");
		dao.addOrUpdateVehicle(v);

	}

	@Override
	public void addOrUpdatePolicy(Policy p) {
		// TODO Auto-generated method stub
		System.out.println("Service layer!!");
		dao.addOrUpdatePolicy(p);
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
	public void addTransaction(Transaction t) {
		// TODO Auto-generated method stub
		System.out.println("Service layer!!");
		dao.addTransaction(t);
	}

	@Override
	public void addOrUpdateCliam(Claims c) {
		// TODO Auto-generated method stub
		dao.addOrUpdateCliam(c);
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

}
