package com.contacts.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contacts.contactsdto.ContactsDto;
import com.contacts.services.ContactsServices;

@RestController
@RequestMapping("/api")
public class ContactsController {
	
	@Autowired
	private ContactsServices contactservices;
	
	@GetMapping("/contact")
    public ResponseEntity<List<ContactsDto>> getallcategory(){
        return ResponseEntity.ok(contactservices.getContacts());
    }

}
