package com.lti.insurance.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="POLICY_TICKETS")
public class PolicyTickets {

	@Id
	@Column(name="TICKET_ID")
	private int ticketId;
	
	@Column(name="POLICY_PLAN")
	private String policyPlan;
	
	@Column(name="REQUEST_TYPE")
	private String requestType;
	
	@Column(name="DURATION")
	private double duration;
	
	@OneToOne
	@JoinColumn(name="policyId")
	private Policy policy;

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public String getPolicyPlan() {
		return policyPlan;
	}

	public void setPolicyPlan(String policyPlan) {
		this.policyPlan = policyPlan;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public PolicyTickets(int ticketId, String policyPlan, String requestType, double duration) {
		super();
		this.ticketId = ticketId;
		this.policyPlan = policyPlan;
		this.requestType = requestType;
		this.duration = duration;
	}

	public PolicyTickets() {
		super();
	}

	@Override
	public String toString() {
		return "PolicyTickets [ticketId=" + ticketId + ", policyPlan=" + policyPlan + ", requestType=" + requestType
				+ ", duration=" + duration + "]";
	}
	
	
}