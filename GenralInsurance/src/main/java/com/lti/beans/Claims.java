package com.lti.beans;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CLAIMS")
public class Claims {

	@Id
	@Column(name="CLAIM_ID")
	private int claimId;
	
	@Column(name="CLAIM_DATE")
	private LocalDate claimDate;
	
	@Column(name="CLAIM_REASON")
	private String reasonOfClaim;
	
	@Column(name="CLAIM_AMOUNT")
	private double claimAmount;
	
	@Column(name="CLAIM_STATUS")
	private ClaimStatus claimStatus;
	
	@ManyToOne
	@JoinColumn(name="policyId")
	private List<Policy> policyList;
	
	public ClaimStatus getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(ClaimStatus claimStatus) {
		this.claimStatus = claimStatus;
	}

	public Claims(int claimId, LocalDate claimDate, String reasonOfClaim, double claimAmount, ClaimStatus claimStatus) {
		super();
		this.claimId = claimId;
		this.claimDate = claimDate;
		this.reasonOfClaim = reasonOfClaim;
		this.claimAmount = claimAmount;
		this.claimStatus = claimStatus;
	}

	public int getClaimId() {
		return claimId;
	}

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
