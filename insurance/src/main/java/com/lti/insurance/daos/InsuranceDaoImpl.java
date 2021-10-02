package com.lti.insurance.daos;

import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;


import com.lti.insurance.beans.Admin;
import com.lti.insurance.beans.ClaimStatus;
import com.lti.insurance.beans.Claims;
import com.lti.insurance.beans.LoginStatus;
import com.lti.insurance.beans.Policy;
import com.lti.insurance.beans.PolicyTickets;
import com.lti.insurance.beans.Transaction;
import com.lti.insurance.beans.Users;
import com.lti.insurance.beans.Vehicle;
import com.lti.insurance.exception.InsuranceException;

@Repository
public class InsuranceDaoImpl implements InsuranceDao{

	@PersistenceContext
	EntityManager em;
	
	
	@Override
	@Transactional
	public Users addOrUpdateUser(Users u) {
		
		System.out.println("Dao Layer"+u);
			String str="Select u from Users u where u.userEmail=:e";
			TypedQuery tq=em.createQuery(str,Users.class);
			tq.setParameter("e", u.getUserEmail());
			if(tq.getResultList().size()==0) {
				em.persist(u);
				return u;
			}
			else {
				throw new InsuranceException("Email already exists");
				
			}
	}
	
	
	public Users getUserByEmail(String mail) {
		String str="Select u from Users u where u.userEmail=:e";
		TypedQuery tq=em.createQuery(str,Users.class);
		tq.setParameter("e", mail);
		return (Users) tq.getSingleResult();
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
	public Vehicle addOrUpdateVehicle(Vehicle v) {
		
		System.out.println("Dao Layer");
		em.persist(v);
		System.out.println(v.getVehicleId());
		return v;
	}

	@Override
	@Transactional
	public Policy addOrUpdatePolicy(Policy p) {
		
		System.out.println("Dao Layer");
		if(em.find(Policy.class, p.getPolicyId())==null) {
			em.persist(p);
		}
		else {
			em.merge(p);
		}
		return p;
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
	public Policy renewPolicy(Policy p) {
		
		System.out.println("Dao Layer");
		em.merge(p);
		return p;
	}

	@Override
	@Transactional
	public Transaction addTransaction(Transaction t) {
		
		System.out.println("Dao Layer");
		em.persist(t);
		return t;
	}

	@Override
	@Transactional
	public Claims addOrUpdateCliam(Claims c) {
		
		System.out.println("Dao Layer");
		if(em.find(Claims.class, c.getClaimId())==null) {
			em.persist(c);
		}
		else {
			em.merge(c);
		}
		return c;
	}

	@Override
	@Transactional
	public List<Policy> getPolicies(int userId) {
		
		System.out.println("Dao Layer");
		String str="Select u.policyList from Users u where u.userId=:id";
		//TypedQuery<Policy> tq=em.createQuery(str,Policy.class);
		//tq.setParameter("id",userId);
		//List<Policy> policyList=tq.getResultList();
		return em.createQuery(str).setParameter("id",userId).getResultList();
	}

	@Override
	@Transactional
	public List<Claims> getPendingCliams() {
		
		System.out.println("Dao Layer");
		String str="Select c from Claims c where c.claimStatus=:status";
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

	@Override
	public LoginStatus loginUser(String userId, String pass) {
		// TODO Auto-generated method stub
		LoginStatus ls=new LoginStatus();
		try {
		String str="select u from Users u where u.userEmail=:id";
		TypedQuery<Users> tq=em.createQuery(str,Users.class);
		tq.setParameter("id", userId);
		Users u=tq.getSingleResult();
		if(u!=null) {
			if(u.getUserPassword().equals(pass)) {
			ls.setUserId(u.getUserId());
			ls.setUserEmail(u.getUserEmail());
			ls.setUserName(u.getUserName());
			ls.setUserStatus("Sucess");
			}
			else {
				ls.setUserEmail(userId);
				ls.setUserStatus("Failed");
			}	
		}
		}
		catch(Exception e) {
			try {
			String str1="select a from Admin a where a.adminEmail=:id";
			TypedQuery<Admin> tq1=em.createQuery(str1,Admin.class);
			tq1.setParameter("id", userId);
			Admin a=tq1.getSingleResult();
			if(a!=null) {
				ls.setAdminId(a.getAdminId());
				ls.setAdminEmail(a.getAdminEmail());
				ls.setAdminStatus("Sucess");
			}
			else {
				ls.setAdminStatus("Failed");
				ls.setUserStatus("Failed");
			}
			}
			catch(Exception e1) {
				ls.setAdminStatus("Failed");
				ls.setUserStatus("Failed");
			}
		
		}
		return ls;
	}

	@Override
	public Users getUserById(int id) {
		// TODO Auto-generated method stub
		return em.find(Users.class, id);
	}

	@Override
	public Vehicle getVehicle(int id) {
		// TODO Auto-generated method stub
		Vehicle v=em.find(Vehicle.class, id);
		return v;
	}

	@Override
	public Transaction getTransaction(int tId) {
		// TODO Auto-generated method stub
		Transaction t=em.find(Transaction.class, tId);
		return t;
	}

	@Override
	public Policy getPolicyByClaim(int id) {
		// TODO Auto-generated method stub
		Claims c=em.find(Claims.class, id);
		String str="select p from Policy p join p.claimList as c where c.claimId=:id";
		Query q=em.createQuery(str);
		q.setParameter("id", id);
		return (Policy) q.getSingleResult();
	}

	@Override
	public Policy getPolicy(int id) {
		// TODO Auto-generated method stub
		return em.find(Policy.class, id);
	}
	
	@Override
    public int Generateotp() {
        Random rand = new Random(); // instance of random class
        int upperbound = 100000;
        // generate random values from 0-24
        int int_random = rand.nextInt(upperbound);
        return int_random;
    }


	
	@Override
	@Transactional
	public int setPass(Users u, String pass) {
		// TODO Auto-generated method stub
		u.setUserPassword(pass);
		if(em.merge(u) != null)
			return 1;
		return 0;
	}

}
