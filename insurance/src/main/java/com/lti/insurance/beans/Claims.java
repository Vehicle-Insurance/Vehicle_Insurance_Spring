package com.lti.insurance.beans;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CLAIMS")
public class Claims {

	@Id
	@Column(name="CLAIM_ID")
	@SequenceGenerator(name="c_seq", initialValue=1001, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="c_seq")
	private int claimId;
	
	@Column(name="CLAIM_DATE")
	private LocalDate claimDate;
	
	@Column(name="CLAIM_REASON")
	private String reasonOfClaim;
	
	@Column(name="CLAIM_AMOUNT")
	private double claimAmount;
	
	@Column(name="CLAIM_STATUS")
	private String claimStatus;
	
	@ManyToOne
	@JoinColumn(name="policyId")
	private Policy policy;
	
	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	public Claims(int claimId, LocalDate claimDate, String reasonOfClaim, double claimAmount,String claimStatus) {
		super();
		this.claimId = claimId;
		this.claimDate = claimDate;
		this.reasonOfClaim = reasonOfClaim;
		this.claimAmount = claimAmount;
		this.claimStatus = claimStatus;
	}

	
	 
	  
	  public int getClaimId() { return claimId; }
	 /* 
	 * public Policy getPolicy() { return policy; }
	 * 
	 */
	  public void setPolicy(Policy policy) { this.policy = policy; }
	

	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}

	public LocalDate getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(LocalDate claimDate) {
		this.claimDate = claimDate;
	}

	public String getReasonOfClaim() {
		return reasonOfClaim;
	}

	public void setReasonOfClaim(String reasonOfClaim) {
		this.reasonOfClaim = reasonOfClaim;
	}

	public double getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(double claimAmount) {
		this.claimAmount = claimAmount;
	}

	@Override
	public String toString() {
		return "Claims [claimId=" + claimId + ", claimDate=" + claimDate + ", reasonOfClaim=" + reasonOfClaim
				+ ", claimAmount=" + claimAmount + ", claimStatus=" + claimStatus + "]";
	}

	public Claims() {
		super();
	}
	
}