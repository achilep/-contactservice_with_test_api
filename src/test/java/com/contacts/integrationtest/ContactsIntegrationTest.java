package com.contacts.integrationtest;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
class ContactsIntegrationTest {

	@Autowired
	private TestRestTemplate restTemplate;
		
	@Test
	public void contextLoads() throws JSONException {	
		
		String response = this.restTemplate.getForObject("/api/contact", String.class);
		
		JSONAssert.assertEquals("[{id:1},{id:2},{id:3}]", 
				response, false);
	}


}
