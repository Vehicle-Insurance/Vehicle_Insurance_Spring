package com.lti.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.insurance.beans.Admin;
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
	public void addUser(@RequestBody Users u) {
		service.addOrUpdateUser(u);
	}
	
	@GetMapping("/users")
	public List<Users> getUsers(){
		return service.getAllUsers();
	}
	
	@PostMapping("/addAdmin")
	public void addAdmin(@RequestBody Admin a) {
		service.addOrUpdateAdmin(a);
	}
	
	@GetMapping(value="/login/{id}/{pass}",produces="application/text")
	public ResponseEntity<String> login(@PathVariable("id") int userId,@PathVariable("pass") String pass) {
		String msg=service.login(userId, pass);
		//System.out.println("{'"+msg+"'}");
		//System.out.println(new String(msg));
		return ResponseEntity.ok(msg) ;
	}
	
	@GetMapping("/login/{id}/{pass}")
	public LoginStatus loginUser(@PathVariable("id") int userId,@PathVariable("pass") String pass) {
		return service.loginUser(userId, pass);
	}
	
	@PostMapping("/addVehicle")
	public void addVehicle(@RequestBody Vehicle v) {
		System.out.println(v.getUser());
		service.addOrUpdateVehicle(v);
	}
	
	@PostMapping("/addPolicy")
	public void addPolicy(@RequestBody Policy p) {
		service.addOrUpdatePolicy(p);
	}
	
	@GetMapping("/vehicleByUser/{id}")
	public List<Vehicle> getVehiclesByUser(@PathVariable("id") int userId) {
		return service.getVehiclesByUser(userId);
	}
	
	@PostMapping("/addTransaction")
	public void addTransaction(@RequestBody Transaction t) {
		service.addTransaction(t);
	}
	
	@PostMapping("/addPolicyTicket")
	public void addPolicyTicket(@RequestBody PolicyTickets pt) {
		service.addOrUpdatePolicyTickets(pt);
	}
}

//ResponseEntity<String>
