package com.contacts.contactsdto;

import java.sql.Blob;

public class ContactsDto {
	int id;

	String name;
	String phone_number;
	
	public ContactsDto() {
		super();
	}
	
	public ContactsDto(int id, String name, String phone_number) {
		super();
		this.id = id;
		this.name = name;
		this.phone_number = phone_number;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	

}
