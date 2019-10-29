package com.contacts.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contacts.contactsdto.ContactsDto;
import com.contacts.contactsrepository.ContactsRepository;
import com.contacts.models.Contacts;

@Service
public class ContactsServices implements ContactServicesInterface {
	

	@Autowired
	private ContactsRepository contactrepos;
	
    @Override
    public List<ContactsDto>getContacts() {
        List<ContactsDto> contactdtos;
			Iterable<Contacts> contacts = contactrepos.findAll();
			 contactdtos = new ArrayList<>();
			for(Contacts contact : contacts) {
			    ContactsDto contactdo = new ContactsDto();
			    contactdo.setId(contact.getId());
			    
			    contactdo.setName(contact.getName());
			    contactdo.setPhone_number(contact.getPhone_number());
			    contactdtos.add(contactdo);
			}
		 
		return contactdtos;
    

   }
}	
