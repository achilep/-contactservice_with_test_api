package com.contacts.controllertest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.contacts.Controller.ContactsController;
import com.contacts.contactsdto.ContactsDto;
import com.contacts.services.ContactsServices;



@RunWith(SpringRunner.class)
@WebMvcTest(ContactsController.class)
class ContactsTestController {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ContactsServices contactservices;
	

	@Test
	public void getcontacts() throws Exception {
		when(contactservices.getContacts()).thenReturn(
				Arrays.asList(new ContactsDto(2,"Item2","3434"),
						new ContactsDto(3,"Item3","34343"))
				);
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/api/contact")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{\"id\":2,\"name\":\"Item2\",\"phone_number\":\"3434\"},{\"id\":3,\"name\":\"Item3\",\"phone_number\":\"34343\"}]"))
				.andReturn();
		//JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
		
	}

}
