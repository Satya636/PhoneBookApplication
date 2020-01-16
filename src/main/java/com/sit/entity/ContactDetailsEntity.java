package com.sit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Entity class binded with ContactDetailsRepository
 * 
 * @author SATYASACHI
 *
 */
@Data
@Entity
@Table(name = "CONTACT_DETAILS")
public class ContactDetailsEntity {

	@Id
	@GeneratedValue
	@Column(name = "CONTACT_ID", length = 5)
	private Integer contactId;

	@Column(name = "CONTACT_NAME", length = 25)
	private String contactName;

	@Column(name = "CONTACT_EMAIL", length = 25)
	private String contactEmail;

	@Column(name = "CONTACT_NUMBER", length = 10)
	private Long phno;
}
