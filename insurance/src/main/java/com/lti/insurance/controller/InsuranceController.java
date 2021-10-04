package com.lti.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.insurance.beans.Admin;
import com.lti.insurance.beans.ClaimStatus;
import com.lti.insurance.beans.Claims;
import com.lti.insurance.beans.LoginStatus;
import com.lti.insurance.beans.Policy;
import com.lti.insurance.beans.PolicyTickets;
import com.lti.insurance.beans.Transaction;
import com.lti.insurance.beans.Users;
import com.lti.insurance.beans.Vehicle;
import com.lti.insurance.services.InsuranceService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/app")
public class InsuranceController {

	@Autowired
	InsuranceService service;
	
	@PostMapping("/addUser")
	public Users addUser(@RequestBody Users u) {
		return service.addOrUpdateUser(u);
	}
	
	@GetMapping("/users")
	public List<Users> getUsers(){
		return service.getAllUsers();
	}
	
	@PostMapping("/addAdmin")
	public void addAdmin(@RequestBody Admin a) {
		service.addOrUpdateAdmin(a);
	}
	
	@GetMapping("/login/{id}/{pass}")
	public LoginStatus loginUser(@PathVariable("id") String userId,@PathVariable("pass") String pass) {
		return service.loginUser(userId, pass);
	}
	
	@PostMapping("/addVehicle/{userId}")
	public Vehicle addVehicle(@RequestBody Vehicle v,@PathVariable("userId") int id) {
		v.setUser(service.getUserById(id));
		System.out.println(v.getUser());
		return service.addOrUpdateVehicle(v);
	}
	
	@PostMapping("/addPolicy/{uId}/{vId}/{tId}")
	public Policy addPolicy(@RequestBody Policy p,@PathVariable("uId") int uId,@PathVariable("vId") int vId,@PathVariable("tId") int tId) {
		p.setUser(service.getUserById(uId));
		p.setVehicle(service.getVehicle(vId));
		p.setTransaction(service.getTransaction(tId));
		return service.addOrUpdatePolicy(p);
	}
	
	@GetMapping("/vehicleByUser/{id}")
	public List<Vehicle> getVehiclesByUser(@PathVariable("id") int userId) {
		return service.getVehiclesByUser(userId);
	}
	
	@PostMapping("/addTransaction")
	public Transaction addTransaction(@RequestBody Transaction t) {
		return service.addTransaction(t);
	}
	
	@PostMapping("/addPolicyTicket")
	public void addPolicyTicket(@RequestBody PolicyTickets pt) {
		service.addOrUpdatePolicyTickets(pt);
	}
	
	@GetMapping("/getVehicle/{id}")
	public Vehicle getVehicle(@PathVariable("id") int id) {
		return service.getVehicle(id);
	}
	
	@GetMapping("/getClaims")
	public List<Claims> getPendingClaims(){
		System.out.println(ClaimStatus.PENDING);
		return service.getPendingCliams();
	}
	
	@PostMapping("/addClaim/{id}")
	public Claims addCliam(@RequestBody Claims c,@PathVariable("id") int id) {
		c.setPolicy(service.getPolicy(id));
		return service.addOrUpdateCliam(c);
	}
	
	@GetMapping("/getPolicyById/{id}")
	public List<Policy> getPolicyById(@PathVariable("id") int id){
		return service.getPolicies(id);
	}
	
	@GetMapping("/getPolicyByClaim/{id}")
	public Policy getPolicyByClaim(@PathVariable("id") int id) {
		return service.getPolicyByClaim(id);
	}
	
	@GetMapping("/getPolicy/{id}")
	public Policy getPolicy(@PathVariable("id") int id) {
		return service.getPolicy(id);
	}
	
	@PostMapping("/renewPolicy")
	public Policy renewPolicy(@RequestBody Policy p) {
		return service.renewPolicy(p);
	}
	
	@GetMapping("/generateOtp/{mail}")
	public int generateOtp(@PathVariable("mail") String mail) {
		return service.Generateotp(mail);
	}
	
	@GetMapping("/setPass/{mail}/{pass}")
	public int setPass(@PathVariable("mail") String mail,@PathVariable("pass") String pass) {
		return service.setPass(mail,pass);
	}
}

//ResponseEntity<String>
