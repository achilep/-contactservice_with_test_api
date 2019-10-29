package com.contacts.contactsrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contacts.models.Contacts;

public interface ContactsRepository extends JpaRepository<Contacts,Integer>{

}
