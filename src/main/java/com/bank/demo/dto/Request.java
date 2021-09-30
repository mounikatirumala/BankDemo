package com.bank.demo.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Request {

	@NotEmpty(message = "Account number cannot be empty")
	private String accountNumber;
	private List<String> providers;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public List<String> getProviders() {
		return providers;
	}

	public void setProviders(List<String> providers) {
		this.providers = providers;
	}

	@Override
	public String toString() {
		return "BankDTO [accountNumber=" + accountNumber + ", providers=" + providers + "]";
	}

}
