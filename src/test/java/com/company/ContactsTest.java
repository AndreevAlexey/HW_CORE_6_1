package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactsTest {
    private Contact contact1;
    private Contact contact2;
    private Contact contact3;
    private Contacts contacts;

    @BeforeAll
    public void setUp() throws Exception {
        contact1 = new Contact("A1","AA1","11111",Group.WORK);
        contact2 = new Contact("B2","BB2","22222",Group.WORK);
        contact3 = new Contact("C3","CC3","33333",Group.WORK);
        Contacts contacts = new Contacts();
    }

    @Test
    void addContact() {

    }

    @Test
    void replaceContact() {
    }

    @Test
    void deleteContact() {
        // given
        contacts.addContact(contact1);
        contacts.addContact(contact2);
        contacts.addContact(contact3);
        Contact actual = contacts.getContactByNumber("33333");
        // when
        contacts.deleteContact("33333");
        Contact result = contacts.getContactByNumber("33333");
        // then
        Assertions.assertNotNull(actual);
        Assertions.assertNull(result);
    }

    @Test
    void getContactByNumber() {
        // given
        contacts.addContact(contact1);
        contacts.addContact(contact2);
        contacts.addContact(contact3);
        // when
        Contact result = contacts.getContactByNumber("22222");
        // then
        Assertions.assertEquals(contact2, result);
    }
    @Test
    void getContactByNumber_NO_CONTACT() {
        // given
        // when
        Contact result = contacts.getContactByNumber("22222");
        // then
        Assertions.assertNull(result);
    }
    @Test
    void getContactByNumber_NULL_CONTACT() {
        // given
        // when
        Contact result = contacts.getContactByNumber(null);
        // then
        Assertions.assertNull(result);
    }
    @Test
    void existInContacts() {
    }
}