package com.ltp.contacts.web;

import java.security.Provider.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ltp.contacts.pojo.Contact;
import com.ltp.contacts.service.ContactService;

@RestController
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/contact/{id}")
    public ResponseEntity<Contact> getContact(@PathVariable String id) {
        Contact contac = contactService.getContactById(id);
        return new ResponseEntity<>(contac, HttpStatus.OK);
    }

    @PostMapping("/contact")
    public ResponseEntity<HttpStatus> createContact(@RequestBody Contact contact){
        contactService.saveContact(contact);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/contact/{id}")
    public ResponseEntity<Contact> updateContact(@Pa thVariable String id, @RequestBody Contact contact){
        contactService.updateContact(id, contact);
        return new ResponseEntity<Contact>(contactService.getContactById(id), HttpStatus.OK);
    }

    @DeleteMapping("/contact/{id}")
    public ResponseEntity<HttpStatus> deleteContact(@PathVariable String id){
        contactService.deleteContact(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/contact/all")
    public ResponseEntity<List<Contact>> getAllContacts(){
        List<Contact> all = contactService.geContacts();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }
}
