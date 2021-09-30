package com.bank.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.demo.dto.Request;
import com.bank.demo.dto.Response;
import com.bank.demo.service.BankService;

@RestController
public class BankController {
	
	@Autowired
	BankService bankService;

	@PostMapping(value = "/validateAccoundNumber", 
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public Response validateAccountNumber(@Valid @RequestBody Request request) {
		return bankService.validateAccountNumber(request);
	}

}
