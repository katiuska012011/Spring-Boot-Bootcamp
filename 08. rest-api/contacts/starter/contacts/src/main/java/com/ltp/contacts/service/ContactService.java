package com.ltp.contacts.service;

import java.util.List;

import com.ltp.contacts.pojo.Contact;

public interface ContactService {
    Contact getContactById(String id);

    void saveContact(Contact contac);

    void updateContact(String id, Contact contact);

    void deleteContact(String id);

    List<Contact> geContacts();
}
