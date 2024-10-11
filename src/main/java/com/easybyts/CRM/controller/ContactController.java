package com.easybyts.CRM.controller;

import com.easybyts.CRM.model.Contact;
import com.easybyts.CRM.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:63342")
@RequestMapping("/api/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;


    @PostMapping
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact){
        Contact newContact= contactService.createContact(contact);
        return ResponseEntity.ok(newContact);
    }

    @GetMapping
    public List<Contact> getContacts(){
        return  contactService.getAllContacts();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable Long id){
         Contact contact= contactService.getContactById(id);
         return ResponseEntity.ok(contact);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable Long id,@RequestBody Contact contactDetails){
        Contact updatedContact= contactService.updateContact(id, contactDetails);
        return ResponseEntity.ok(updatedContact);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Contact> deleteContact(@PathVariable Long id){
        contactService.deleteContact(id);
        return ResponseEntity.noContent().build();
    }

}
