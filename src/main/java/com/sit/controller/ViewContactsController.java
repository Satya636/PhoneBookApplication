package com.sit.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sit.model.Contact;
import com.sit.service.ContactService;

/**
 * This controller is responsible for handling all request coming from
 * viewContacts.jsp
 * 
 * @author SATYASACHI
 *
 */
@Controller
public class ViewContactsController {

	@Autowired
	private ContactService cntService;

	/**
	 * used for edit contact hyperlink
	 * 
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "editContact")
	public String editContact(HttpServletRequest req, Model model) {
		Integer cntId = Integer.parseInt(req.getParameter("contId"));
		// call service method
		Contact contact = cntService.getContactById(cntId);
		model.addAttribute("contact", contact);
		return "contact_info";

	}

	// for delete contact hyperlink
	public String deleteContact(HttpServletRequest req) {
		return null;

	}

}
