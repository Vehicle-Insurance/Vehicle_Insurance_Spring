package com.lti.insurance.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

import com.lti.insurance.beans.Admin;
import com.lti.insurance.beans.Claims;
import com.lti.insurance.beans.Policy;
import com.lti.insurance.beans.PolicyTickets;
import com.lti.insurance.beans.Transaction;
import com.lti.insurance.beans.Users;
import com.lti.insurance.beans.Vehicle;

public class InsuranceDaoImpl implements InsuranceDao{

	@PersistenceContext
	EntityManager em;
	
	@Override
	@Transactional
	public void addOrUpdateUser(Users u) {
		
		System.out.println("Dao Layer");
		if(em.find(Users.class, u)==null) {
			em.persist(u);
		}
		else {
			em.merge(u);
		}
		
	}

	@Override
	public void addOrUpdateAdmin(Admin a) {
		
		System.out.println("Dao Layer");
		if(em.find(Users.class, a)==null) {
			em.persist(a);
		}
		else {
			em.merge(a);
		}
	}

	@Override
	public String login(int userId, String password) {
		
		System.out.println("Dao Layer");
		String qry="Select a from Admin a where a.adminId=:id and a.adminPassword=:pass";
		TypedQuery<Admin> tq=em.createQuery(qry,Admin.class);
		tq.setParameter("id",userId);
		tq.setParameter("pass", password);
		Admin a=tq.getSingleResult();
		if(a!=null) {
			return "Admin Exists";
		}
		String qry1="Select u from Users u where u.userId=:id and u.userPassword=:pass";
		TypedQuery<Users> tq1=em.createQuery(qry1,Users.class);
		tq1.setParameter("id",userId);
		tq1.setParameter("pass", password);
		Users u=tq1.getSingleResult();
		if(u!=null) {
			return "User Exists";
		}
		return "User Does Not Exixts";
	}

	@Override
	public void addOrUpdateVehicle(Vehicle v) {
		
		System.out.println("Dao Layer");
		if(em.find(Vehicle.class, v)==null) {
			em.persist(v);
		}
		else {
			em.merge(v);
		}
	}

	@Override
	public void addOrUpdatePolicy(Policy p) {
		
		System.out.println("Dao Layer");
		if(em.find(Policy.class, p)==null) {
			em.persist(p);
		}
		else {
			em.merge(p);
		}
	}

	@Override
	public void addOrUpdatePolicyTickets(PolicyTickets pt) {
		
		System.out.println("Dao Layer");
		if(em.find(PolicyTickets.class, pt)==null) {
			em.persist(pt);
		}
		else {
			em.merge(pt);
		}
	}

	@Override
	public void renewPolicy(Policy p) {
		
		System.out.println("Dao Layer");
		em.merge(p);
	}

	@Override
	public void addTransaction(Transaction t) {
		
		System.out.println("Dao Layer");
		em.persist(t);
	}

	@Override
	public void addOrUpdateCliam(Claims c) {
		
		System.out.println("Dao Layer");
		if(em.find(Claims.class, c)==null) {
			em.persist(c);
		}
		else {
			em.merge(c);
		}
	}

	@Override
	public List<Policy> getPolicies(int userId) {
		
		System.out.println("Dao Layer");
		String str="Select u.policyList from Users u where u.userId=:id";
		TypedQuery<Policy> tq=em.createQuery(str,Policy.class);
		tq.setParameter("id",userId);
		List<Policy> policyList=tq.getResultList();
		return policyList;
	}

	@Override
	public List<Claims> getPendingCliams() {
		
		System.out.println("Dao Layer");
		String str="Select c from Claims c where c.ClaimStatus=:status";
		TypedQuery<Claims> tq=em.createQuery(str,Claims.class);
		tq.setParameter("status", "PENDING");
		List<Claims> cliamsList=tq.getResultList();
		return cliamsList;
	}

	@Override
	public List<PolicyTickets> getPendingPolicyTickets() {
		
		System.out.println("Dao Layer");
		String str="Select pt from PolicyTickets pt where pt.status=:s";
		TypedQuery<PolicyTickets> tq=em.createQuery(str,PolicyTickets.class);
		tq.setParameter("s", "PENDING");
		List<PolicyTickets> ptList=tq.getResultList();
		return ptList;
	}

	@Override
	public List<Claims> getCliamsByUser(int id) {
		
		System.out.println("Dao Layer");
		String str="Select p.claimList from policy p where p.user.userId=:id";
		TypedQuery<Claims> tq=em.createQuery(str,Claims.class);
		tq.setParameter("id", id);
		List<Claims> cList=tq.getResultList();
		return cList;
	}

	@Override
	public List<Vehicle> getVehiclesByUser(int id) {
		
		System.out.println("Dao Layer");
		String str="Select u.vehicleList from Users u where u.userId=:id";
		TypedQuery<Vehicle> tq=em.createQuery(str,Vehicle.class);
		tq.setParameter("id", id);
		List<Vehicle> vList=tq.getResultList();
		return null;
	}

	@Override
	public void removePolicy(Policy p) {
		
		System.out.println("Dao Layer");
		em.remove(p);
		
	}

	@Override
	public void removeClaim(Claims c) {
		
		System.out.println("Dao Layer");
		em.remove(c);
	}

	@Override
	public void removePolicyById(int id) {
		// TODO Auto-generated method stub
		System.out.println("Dao Layer");
		Policy p=em.find(Policy.class, id);
		em.remove(p);
	}

	@Override
	public void removeClaimById(int id) {
		// TODO Auto-generated method stub
		System.out.println("Dao Layer");
		Claims c=em.find(Claims.class,id);
		em.remove(c);
		
	}

}
