package com.lti.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.insurance.beans.Admin;
import com.lti.insurance.beans.Policy;
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
	
	@GetMapping("/login")
	public String login() {
		String msg=service.login(201, "password12");
		return msg;
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
	
	@GetMapping("/vehicleByUser")
	public List<Vehicle> getVehiclesByUser() {
		return service.getVehiclesByUser(101);
	}
}
