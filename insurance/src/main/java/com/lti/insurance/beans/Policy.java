package com.lti.insurance.beans;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="POLICY")
public class Policy {

	@Id
	@Column(name="POLICY_ID")
	private int policyId;
	
	@Column(name="POLICY_PLAN")
	private String policyPlan;
	
	@Column(name="POLICY_START_DATE")
	private LocalDate policyStartDate;
	
	@Column(name="POLICY_DURATION")
	private double policyDuration;
	
	@Column(name="POLICY_FOR")
	private String policyFor;
	
	@Column(name="POLICY_PREMIUM_AMOUNT")
	private double policyPremiumAmount;
	
	@Column(name="POLICY_COVERAGE_AMOUNT")
	private double policyCoverageAmount;	
	
	@ManyToOne
	@JoinColumn(name="userId")
	private Users user;
	
	@OneToOne
	@JoinColumn(name="vehicleId")
	private Vehicle vehicle;
	
	@OneToOne(mappedBy="policy",cascade=CascadeType.ALL)
	private PolicyTickets policyTicket;
	
	@OneToMany(mappedBy="policy",cascade=CascadeType.ALL)
	private List<Claims> claimList;
	
	@OneToOne
	@JoinColumn(name="transactionId")
	private Transaction transaction;
	
	public Policy(int policyId, String policyPlan, LocalDate policyStartDate, double policyDuration, String policyFor,
			double policyPremiumAmount, double policyCoverageAmount) {
		super();
		this.policyId = policyId;
		this.policyPlan = policyPlan;
		this.policyStartDate = policyStartDate;
		this.policyDuration = policyDuration;
		this.policyFor = policyFor;
		this.policyPremiumAmount = policyPremiumAmount;
		this.policyCoverageAmount = policyCoverageAmount;
	}

	public int getPolicyId() {
		return policyId;
	}

	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public PolicyTickets getPolicyTicket() {
		return policyTicket;
	}

	public void setPolicyTicket(PolicyTickets policyTicket) {
		this.policyTicket = policyTicket;
	}

	public List<Claims> getClaim() {
		return claimList;
	}

	public void setClaim(List<Claims> claim) {
		this.claimList = claim;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public String getPolicyPlan() {
		return policyPlan;
	}

	public void setPolicyPlan(String policyPlan) {
		this.policyPlan = policyPlan;
	}

	public LocalDate getPolicyStartDate() {
		return policyStartDate;
	}

	public void setPolicyStartDate(LocalDate policyStartDate) {
		this.policyStartDate = policyStartDate;
	}

	public double getPolicyDuration() {
		return policyDuration;
	}

	public void setPolicyDuration(double policyDuration) {
		this.policyDuration = policyDuration;
	}

	public String getPolicyFor() {
		return policyFor;
	}

	public void setPolicyFor(String policyFor) {
		this.policyFor = policyFor;
	}

	public double getPolicyPremiumAmount() {
		return policyPremiumAmount;
	}

	public void setPolicyPremiumAmount(double policyPremiumAmount) {
		this.policyPremiumAmount = policyPremiumAmount;
	}

	public double getPolicyCoverageAmount() {
		return policyCoverageAmount;
	}

	public void setPolicyCoverageAmount(double policyCoverageAmount) {
		this.policyCoverageAmount = policyCoverageAmount;
	}

	@Override
	public String toString() {
		return "Policy [policyId=" + policyId + ", policyPlan=" + policyPlan + ", policyStartDate=" + policyStartDate
				+ ", policyDuration=" + policyDuration + ", policyFor=" + policyFor + ", policyPremiumAmount="
				+ policyPremiumAmount + ", policyCoverageAmount=" + policyCoverageAmount + "]";
	}

	public Policy(int policyId, String policyPlan, LocalDate policyStartDate, double policyDuration, String policyFor,
			double policyPremiumAmount, double policyCoverageAmount, Users user, Vehicle vehicle,
			PolicyTickets policyTicket, List<Claims> claim, Transaction transaction) {
		super();
		this.policyId = policyId;
		this.policyPlan = policyPlan;
		this.policyStartDate = policyStartDate;
		this.policyDuration = policyDuration;
		this.policyFor = policyFor;
		this.policyPremiumAmount = policyPremiumAmount;
		this.policyCoverageAmount = policyCoverageAmount;
		this.user = user;
		this.vehicle = vehicle;
		this.policyTicket = policyTicket;
		this.claimList = claim;
		this.transaction = transaction;
	}


	
}
