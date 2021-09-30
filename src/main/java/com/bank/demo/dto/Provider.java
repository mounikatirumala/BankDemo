package com.bank.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Provider {
	private String provider;
	@JsonProperty("isValid")
	private boolean valid;

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

}
