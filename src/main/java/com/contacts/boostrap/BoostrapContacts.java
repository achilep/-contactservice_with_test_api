package com.contacts.boostrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.contacts.contactsrepository.ContactsRepository;
import com.contacts.models.Contacts;

@Component
public class BoostrapContacts implements ApplicationListener<ContextRefreshedEvent> {
	private ContactsRepository contactsrepos;
	@Autowired
	public BoostrapContacts(ContactsRepository contactsrepos) {
		super();
		this.contactsrepos = contactsrepos;
	}
	@Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData(10);
    }

    private void initData(int count) {
       for(int i = 0; i < count; i++){
    	   String name = "aladin" + i;
    	   String phone_number = "44" + i;
            Contacts contact = new Contacts();
            contact.setName(name);
            contact.setPhone_number(phone_number);
             contactsrepos.save(contact);
            
       }   
    }


}
