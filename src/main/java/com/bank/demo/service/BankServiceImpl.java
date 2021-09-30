package com.bank.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import com.bank.demo.dto.Provider;
import com.bank.demo.dto.Request;
import com.bank.demo.dto.Response;

@Service
public class BankServiceImpl implements BankService {
	
	/*
	@Value("#{'${app.providers}'.split(',')}")
	private List<String> providers;
	*/
	
	@Value("#{${app.providers}}")
	Map<String, String> providersMap;
	
	@Autowired
	RestTemplate restTemplate;
	
	public Response validateAccountNumber(Request request) {
		System.out.println(request);
		Response response = new Response();
		List<Provider> result = new ArrayList<>();
		
		if (CollectionUtils.isEmpty(request.getProviders())) {
			for (Map.Entry<String, String> map : providersMap.entrySet()) {
				Provider providerRef = validateProvider(map.getKey(), map.getValue()+"/"+request.getAccountNumber());
				result.add(providerRef);
			}
		} else {
			for (String provider : request.getProviders()) {
				String providerUrl = providersMap.get(provider);
				Provider providerRef = validateProvider(provider, providerUrl+"/"+request.getAccountNumber());
				result.add(providerRef);
			}
		}
		System.out.println(result);
		response.setResult(result);
		return response;
	}

	private Provider validateProvider(String provider, String url) {
		Provider providerRef = new Provider();
		providerRef.setProvider(provider);
		//boolean isAccountNumberValid = restTemplate.getForObject(url, Boolean.class);
		providerRef.setValid(false);
		return providerRef;
	}

}
