package com.ltp.contacts.exception;

public class ContactNoFoundException extends RuntimeException {
    
    public ContactNoFoundException(String id){
        super("The id: "+id+" does not exist in pur record");
    }
}
