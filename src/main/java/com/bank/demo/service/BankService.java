package com.bank.demo.service;

import com.bank.demo.dto.Request;
import com.bank.demo.dto.Response;

public interface BankService {
	public Response validateAccountNumber(Request request);

}
