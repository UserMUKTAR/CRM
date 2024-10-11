package com.easybyts.CRM.service;

import com.easybyts.CRM.exception.ResourceNotFoundException;
import com.easybyts.CRM.model.Contact;

import com.easybyts.CRM.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    //create new contact
    public Contact createContact(Contact contact ){

        return contactRepository.save(contact);
    }

    public List<Contact> getAllContacts(){
        return contactRepository.findAll();
    }

    public Contact getContactById(Long id){
        return contactRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contact not found with id: " + id ));
    }

    public Contact updateContact(Long id, Contact contactDetails) {
        Contact contact = getContactById(id);
        contact.setFirstName(contactDetails.getFirstName());
        contact.setLastName(contactDetails.getLastName());
        contact.setEmail(contactDetails.getEmail());
        contact.setPhone(contactDetails.getPhone());
        contact.setCompany(contactDetails.getCompany());
        contact.setJobTitle(contactDetails.getJobTitle());
        contact.setAddress(contactDetails.getAddress());
        contact.setCity(contactDetails.getCity());
        contact.setState(contactDetails.getState());
        contact.setZipCode(contact.getZipCode());

        return contactRepository.save(contact);

    }


    public void deleteContact(Long id){
        Contact contact = getContactById(id);
        contactRepository.delete(contact);
    }



}
