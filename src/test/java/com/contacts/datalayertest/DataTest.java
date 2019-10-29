package com.contacts.datalayertest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.contacts.contactsrepository.ContactsRepository;
import com.contacts.models.Contacts;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@DataJpaTest
class DataTest {

	@Autowired
	private ContactsRepository repository;
	
	@Test
	public void testFindAll() {
		List<Contacts> contact = repository.findAll();
		assertEquals(10,contact.size());
	}

	@Test
	public void testFindOne() {
		Contacts contact = repository.findById(1).get();
		
		assertEquals("440",contact.getPhone_number());
	}

}
