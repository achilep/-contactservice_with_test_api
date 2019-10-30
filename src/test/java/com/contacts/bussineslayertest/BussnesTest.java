package com.contacts.bussineslayertest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.contacts.Controller.ContactsController;
import com.contacts.contactsdto.ContactsDto;
import com.contacts.contactsrepository.ContactsRepository;
import com.contacts.models.Contacts;
import com.contacts.services.ContactsServices;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class BussnesTest {
	
	@Mock
	private ContactsRepository  repos;
	
	@InjectMocks
	private ContactsServices business;

	@Test
	public void getcontact() {
		
		when(repos.findAll()).thenReturn(
				Arrays.asList(new Contacts(2,"Item2","3434"),
						new Contacts(3,"Item3","2322")));
				
		List<ContactsDto> contactdto = business.getContacts();
		
		assertEquals("Item2", contactdto.get(0).getName());
		assertEquals("2322", contactdto.get(1).getPhone_number());
	}
}
