package com.lti.insurance.daos;

import java.util.List;

import com.lti.insurance.beans.Admin;
import com.lti.insurance.beans.Claims;
import com.lti.insurance.beans.LoginStatus;
import com.lti.insurance.beans.Policy;
import com.lti.insurance.beans.PolicyTickets;
import com.lti.insurance.beans.Transaction;
import com.lti.insurance.beans.Users;
import com.lti.insurance.beans.Vehicle;



public interface InsuranceDao {

	public abstract void addOrUpdateUser(Users u);
	public abstract void addOrUpdateAdmin(Admin a);
	public abstract String login(int userId,String password);
	public abstract void addOrUpdateVehicle(Vehicle v);
	public abstract void addOrUpdatePolicy(Policy p);
	public abstract void addOrUpdatePolicyTickets(PolicyTickets pt);
	public abstract void renewPolicy(Policy p);
	public abstract void addTransaction(Transaction t);
	public abstract void addOrUpdateCliam(Claims c);
	public abstract List<Policy> getPolicies(int userId);
	public abstract List<Claims> getPendingCliams(); 
	public abstract List<PolicyTickets> getPendingPolicyTickets();
	public abstract List<Claims> getCliamsByUser(int id);
	public abstract List<Vehicle> getVehiclesByUser(int id);
	public abstract void removePolicy(Policy p);
	public abstract void removeClaim(Claims c);
	public abstract void removePolicyById(int id);
	public abstract void removeClaimById(int id);
	public abstract List<Users> getAllUsers();
	public abstract LoginStatus loginUser(int userId, String pass);
}
