package com.lti.insurance.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="VEHICLE")
public class Vehicle {

	@Id
	@Column(name="VEHICLE_ID")
	private int vehicleId;
	
	@Column(name="VEHICLE_REGISTRATION_NUMBER")
	private String registrationNumber;
	
	@Column(name="VEHICLE_REGISTRATION_STATE")
	private String registrationState;
	
	@Column(name="VEHICLE_MANUFACTURER")
	private String manufacturer;
	
	@Column(name="VEHICLE_MODEL")
	private String model;
	
	@Column(name="VEHICLE_TYPE")
	private String vehicleType;
	
	@Column(name="VENGINE_NUMBER")
	private String engineNumber;
	
	@Column(name="CHASSIS_NUMBER")
	private String chassisNumber;
	
	@Column(name="VEHICLE_AGE")
	private int age;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private Users user;

	public Vehicle(int vehicleId, String registrationNumber, String registrationState, String manufacturer,
			String model, String vehicleType, String engineNumber, String chassisNumber, int age) {
		super();
		this.vehicleId = vehicleId;
		this.registrationNumber = registrationNumber;
		this.registrationState = registrationState;
		this.manufacturer = manufacturer;
		this.model = model;
		this.vehicleType = vehicleType;
		this.engineNumber = engineNumber;
		this.chassisNumber = chassisNumber;
		this.age = age;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getRegistrationState() {
		return registrationState;
	}

	public void setRegistrationState(String registrationState) {
		this.registrationState = registrationState;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getEngineNumber() {
		return engineNumber;
	}

	public void setEngineNumber(String engineNumber) {
		this.engineNumber = engineNumber;
	}

	public String getChassisNumber() {
		return chassisNumber;
	}

	public void setChassisNumber(String chassisNumber) {
		this.chassisNumber = chassisNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", registrationNumber=" + registrationNumber + ", registrationState="
				+ registrationState + ", manufacturer=" + manufacturer + ", model=" + model + ", vehicleType="
				+ vehicleType + ", engineNumber=" + engineNumber + ", chassisNumber=" + chassisNumber + ", age=" + age
				+ "]";
	}

	public Vehicle() {
		super();
	}
	
	
}
