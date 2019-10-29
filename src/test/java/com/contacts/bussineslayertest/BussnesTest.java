package com.contacts.bussineslayertest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.contacts.contactsdto.ContactsDto;
import com.contacts.contactsrepository.ContactsRepository;
import com.contacts.models.Contacts;
import com.contacts.services.ContactsServices;


@RunWith(MockitoJUnitRunner.class)
class BussnesTest {
	@InjectMocks
	private ContactsServices business;

	@Mock
	private ContactsRepository  repos;
	
	@Test
	public void getallcontact() {
		
		when(repos.findAll()).thenReturn(Arrays.asList(new Contacts(2,"Item2","3434"),
				new Contacts(3,"Item3","34343")));
		List<ContactsDto> contactdto = business.getContacts();
		
		assertEquals("Item2", contactdto.get(0).getName());
		assertEquals("2322", contactdto.get(1).getPhone_number());
	}
}
