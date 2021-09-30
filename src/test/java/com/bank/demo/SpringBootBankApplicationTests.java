package com.bank.demo;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
class SpringBootBankApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	public void validateAccoundNumberTest() throws Exception {
		String uri = "/validateAccoundNumber";
		String requesutJSON = "{\"accountNumber\":\"1234567\","
				+ "\"providers\":[\"provider1\",\"provider2\"]}";
				
		mvc.perform(
			MockMvcRequestBuilders.post(uri)
			.contentType(MediaType.APPLICATION_JSON_VALUE)
			.content(requesutJSON))
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("result")));	
	}

}
