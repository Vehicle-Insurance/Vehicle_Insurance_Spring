package com.lti.insurance.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TRANSACTION")
public class Transaction {

	@Id
	@Column(name="TRANSACTION_ID")
	private int transactionId;
	
	@Column(name="TRANSACTION_MODE")
	private String transactionMode;
	
	@Column(name="TRANSACTION_AMOUNT")
	private double transactionAmount;
	
	@Column(name="TRANSACTION_STATUS")
	private String transactionStatus;
	
	public Transaction(int transactionId, String transactionMode, double transactionAmount, String transactionStatus) {
		super();
		this.transactionId = transactionId;
		this.transactionMode = transactionMode;
		this.transactionAmount = transactionAmount;
		this.transactionStatus = transactionStatus;
	}
	
	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionMode() {
		return transactionMode;
	}

	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public Transaction() {
		super();
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionMode=" + transactionMode
				+ ", transactionAmount=" + transactionAmount + ", transactionStatus=" + transactionStatus + "]";
	}
	
}
