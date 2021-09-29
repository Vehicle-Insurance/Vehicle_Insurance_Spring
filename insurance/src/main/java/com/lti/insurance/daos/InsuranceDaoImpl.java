package com.lti.insurance.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;


import com.lti.insurance.beans.Admin;
import com.lti.insurance.beans.Claims;
import com.lti.insurance.beans.Policy;
import com.lti.insurance.beans.PolicyTickets;
import com.lti.insurance.beans.Transaction;
import com.lti.insurance.beans.Users;
import com.lti.insurance.beans.Vehicle;

@Repository
public class InsuranceDaoImpl implements InsuranceDao{

	@PersistenceContext
	EntityManager em;
	
	@Override
	@Transactional
	public void addOrUpdateUser(Users u) {
		
		System.out.println("Dao Layer"+u);
		try {
			Users u1=em.find(Users.class, u.getUserId());
			em.merge(u);
		}
		catch(Exception e) {
			em.persist(u);
		}
		
	}

	@Override
	@Transactional
	public void addOrUpdateAdmin(Admin a) {
		
		System.out.println("Dao Layer");
		if(em.find(Users.class, a.getAdminId())==null) {
			em.persist(a);
		}
		else {
			em.merge(a);
		}
	}

	@Override
	@Transactional
	public String login(int userId, String password) {
		
		System.out.println("Dao Layer");
		if(em.find(Users.class,userId)==null) {
			if(em.find(Admin.class, userId)!=null) {
				Admin a=em.find(Admin.class, userId);
				if(a.getAdminPassword().equals(password))
				{
					return "Admin";
				}
			}
		}
		else {
			Users u=em.find(Users.class, userId);
			if(u.getUserPassword().equals(password))
				return "User";
		}
		return "User Does Not Exixts";
//		String qry="Select a from Admin a where a.adminId=:id and a.adminPassword=:pass";
//		TypedQuery<Admin> tq=em.createQuery(qry,Admin.class);
//		tq.setParameter("id",userId);
//		tq.setParameter("pass", password);
//		Admin a=tq.getSingleResult();
//		if(a!=null) {
//			return "Admin Exists";
//		}
//		String qry1="Select u from Users u where u.userId=:id and u.userPassword=:pass";
//		TypedQuery<Users> tq1=em.createQuery(qry1,Users.class);
//		tq1.setParameter("id",userId);
//		tq1.setParameter("pass", password);
//		Users u=tq1.getSingleResult();
//		if(u!=null) {
//			return "User Exists";
//		}
//		return "User Does Not Exixts";
	}

	@Override
	@Transactional
	public void addOrUpdateVehicle(Vehicle v) {
		
		System.out.println("Dao Layer");
		if(em.find(Vehicle.class, v.getVehicleId())==null) {
			em.persist(v);
		}
		else {
			em.merge(v);
		}
	}

	@Override
	@Transactional
	public void addOrUpdatePolicy(Policy p) {
		
		System.out.println("Dao Layer");
		if(em.find(Policy.class, p.getPolicyId())==null) {
			em.persist(p);
		}
		else {
			em.merge(p);
		}
	}

	@Override
	@Transactional
	public void addOrUpdatePolicyTickets(PolicyTickets pt) {
		
		System.out.println("Dao Layer");
		if(em.find(PolicyTickets.class, pt.getTicketId())==null) {
			em.persist(pt);
		}
		else {
			em.merge(pt);
		}
	}

	@Override
	@Transactional
	public void renewPolicy(Policy p) {
		
		System.out.println("Dao Layer");
		em.merge(p);
	}

	@Override
	@Transactional
	public void addTransaction(Transaction t) {
		
		System.out.println("Dao Layer");
		em.persist(t);
	}

	@Override
	@Transactional
	public void addOrUpdateCliam(Claims c) {
		
		System.out.println("Dao Layer");
		if(em.find(Claims.class, c.getClaimId())==null) {
			em.persist(c);
		}
		else {
			em.merge(c);
		}
	}

	@Override
	@Transactional
	public List<Policy> getPolicies(int userId) {
		
		System.out.println("Dao Layer");
		String str="Select u.policyList from Users u where u.userId=:id";
		TypedQuery<Policy> tq=em.createQuery(str,Policy.class);
		tq.setParameter("id",userId);
		List<Policy> policyList=tq.getResultList();
		return policyList;
	}

	@Override
	@Transactional
	public List<Claims> getPendingCliams() {
		
		System.out.println("Dao Layer");
		String str="Select c from Claims c where c.ClaimStatus=:status";
		TypedQuery<Claims> tq=em.createQuery(str,Claims.class);
		tq.setParameter("status", "PENDING");
		List<Claims> cliamsList=tq.getResultList();
		return cliamsList;
	}

	@Override
	@Transactional
	public List<PolicyTickets> getPendingPolicyTickets() {
		
		System.out.println("Dao Layer");
		String str="Select pt from PolicyTickets pt where pt.status=:s";
		TypedQuery<PolicyTickets> tq=em.createQuery(str,PolicyTickets.class);
		tq.setParameter("s", "PENDING");
		List<PolicyTickets> ptList=tq.getResultList();
		return ptList;
	}

	@Override
	@Transactional
	public List<Claims> getCliamsByUser(int id) {
		
		System.out.println("Dao Layer");
		String str="Select p.claimList from policy p where p.user.userId=:id";
		TypedQuery<Claims> tq=em.createQuery(str,Claims.class);
		tq.setParameter("id", id);
		List<Claims> cList=tq.getResultList();
		return cList;
	}

	@Override
	@Transactional
	public List<Vehicle> getVehiclesByUser(int id) {
		
		System.out.println("Dao Layer");
//		String str="Select v from Vehicle v where v.user.userId=:id";
//		Query q=em.createQuery(str);
//		q.setParameter("id",id);
//		List<Vehicle> vList=q.getResultList();
//		System.out.println(vList);
		String str="Select u.vehicleList from Users u where u.userId=:id";
		List<Vehicle> vList=em.createQuery(str).setParameter("id", id).getResultList();
		/*
		 * TypedQuery<Vehicle> tq=em.createQuery(str,Vehicle.class);
		 * tq.setParameter("id", id); System.out.println(tq.getResultList());
		 * List<Vehicle> vList=tq.getResultList();
		 */
		return vList;
	}

	@Override
	@Transactional
	public void removePolicy(Policy p) {
		
		System.out.println("Dao Layer");
		em.remove(p);
		
	}

	@Override
	@Transactional
	public void removeClaim(Claims c) {
		
		System.out.println("Dao Layer");
		em.remove(c);
	}

	@Override
	@Transactional
	public void removePolicyById(int id) {
		// TODO Auto-generated method stub
		System.out.println("Dao Layer");
		Policy p=em.find(Policy.class, id);
		em.remove(p);
	}

	@Override
	@Transactional
	public void removeClaimById(int id) {
		// TODO Auto-generated method stub
		System.out.println("Dao Layer");
		Claims c=em.find(Claims.class,id);
		em.remove(c);
		
	}

	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		String str="select u from Users u";
		TypedQuery<Users> tq=em.createQuery(str,Users.class);
		
		return tq.getResultList();
	}

}
