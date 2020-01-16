package com.sit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sit.entity.ContactDetailsEntity;
import com.sit.model.Contact;
import com.sit.repo.ContactDetailsRepository;

/**
 * this class is used by controller , business methods are implementated here
 * 
 * @author SATYASACHI
 *
 */

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDetailsRepository contactDltsRepo;

	/**
	 * this method is used for inserting contact details in db using repository
	 * method
	 */
	@Override
	public boolean saveContact(Contact c) {
		ContactDetailsEntity entity = new ContactDetailsEntity();
		BeanUtils.copyProperties(c, entity);
		ContactDetailsEntity savedEntity = contactDltsRepo.save(entity);
		return savedEntity.getContactId() > 0;
	}

	/**
	 * this method is used for fetching all the contacts form the table
	 */
	@Override
	public List<Contact> getAllContacts() {
		List<ContactDetailsEntity> entList = contactDltsRepo.findAll();
		List<Contact> cntList = new ArrayList<>();
		
		entList.forEach(cnt -> {
			Contact c = new Contact();
			BeanUtils.copyProperties(cnt, c);
			cntList.add(c);
		});
		return cntList;
	}

	@Override
	public Contact getContactById(Integer cid) {
		Optional<ContactDetailsEntity> optional = contactDltsRepo.findById(cid);
		Contact contact = new Contact();
		if(optional.isPresent()) {
			ContactDetailsEntity contactEntity = optional.get();
		     BeanUtils.copyProperties(contactEntity, contact);	
		}
		return contact;
	}

	@Override
	public boolean updateContact(Contact c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteContactById(Integer cid) {
		// TODO Auto-generated method stub
		return false;
	}

}
