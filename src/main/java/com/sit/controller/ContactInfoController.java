package com.sit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sit.entity.ContactDetailsEntity;
import com.sit.model.Contact;
import com.sit.service.ContactService;

/**
 * This Controller is for handling the requests coming from Contact.jsp
 * 
 * @author SATYASACHI
 *
 */
@Controller
public class ContactInfoController {

	@Autowired
	private ContactService contactService;

	/**
	 * for launching ContactInfo page
	 * 
	 * @param model
	 * @return String
	 */
	@RequestMapping("/")
	public String displayContactForm(Model model) {
		Contact c = new Contact();
		model.addAttribute("contact", c);
		return "contact_info";
	}

	/**
	 * for handling submmit button
	 * 
	 * @param c
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "submit", method = RequestMethod.POST)
	public String handleSubmitButton(@ModelAttribute("contact") Contact c, RedirectAttributes attributes) {
		boolean saveContact = contactService.saveContact(c);
		if (saveContact == true) {
			// model.addAttribute("succesMsg", "Contact Saved");
			attributes.addFlashAttribute("succesMsg", "Contact Saved");
		} else {
			// model.addAttribute("failedMsg", "Contact Not Saved");
			attributes.addFlashAttribute("failedMsg", "Contact Not Saved");
		}
		return "redirect:/contactDetailsSaveSucess";
	}

	/**
	 * This method is used for displaying sucess msg post insertion
	 * 
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "/contactDetailsSaveSucess", method = RequestMethod.GET)
	public String contactDetailsSaveSucess(Model model, Contact c) {
		model.addAttribute("contact", c);
		return "contact_info";

	}

	/**
	 * for handling ViewAllContacts hyperlink
	 * 
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "/viewContacts")
	public String viewContacts(Model model) {
		List<Contact> contactList = contactService.getAllContacts();
		model.addAttribute("listContacts", contactList);
		return "viewContacts";

	}

}
