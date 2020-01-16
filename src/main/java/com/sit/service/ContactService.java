package com.sit.service;

import java.util.List;

import com.sit.model.Contact;

/**
 * This interface is for declaring the methods that are to be
 * used by controller to process the requests
 * @author SATYASACHI
 *
 */
public interface ContactService {

	public boolean saveContact(Contact c);
	public List<Contact> getAllContacts();
	public Contact getContactById(Integer cid);
	public boolean updateContact(Contact c);
	public boolean deleteContactById(Integer cid);
	
}
