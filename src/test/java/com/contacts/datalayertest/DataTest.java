package com.contacts.datalayertest;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;
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
     for (Contacts contacts : contact) {
    	 
    	 assertThat(contacts.getPhone_number()).hasSize(8)
                            
         ;
	
		} 
 for (Contacts contacts : contact) {
    	 
    	 assertThat(contacts.getName()).hasSize(8)
                            
         ;
	
		} 
 for (Contacts contacts : contact) {
	 
	 assertThat(contacts.getId())
                        
     ;

	} 
 
		assertEquals(3,contact.size());
	}

	@Test
	public void testFindOne() {
		Contacts contact = repository.findById(11).get();
		//assertEquals(3,contact.size());
		
		}
	 
	

}
