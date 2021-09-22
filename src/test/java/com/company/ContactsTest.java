package com.company;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


class ContactsTest {
    Contact contact1;
    Contact contact2;
    Contact contact3;
    Contacts contacts;

    @BeforeEach
    public void init()  {
        contact1 = new Contact("A1","AA1","11111",Group.WORK);
        contact2 = new Contact("B2","BB2","22222",Group.WORK);
        contact3 = new Contact("C3","CC3","33333",Group.WORK);
        contacts = new Contacts();
    }

    @Test
    void replaceContact() {
        // given
        contacts.addContact(contact1);
        contacts.addContact(contact2);
        contacts.addContact(contact3);
        Contact actual = new Contact("D4","DD4","33333",Group.HOME);
        contacts.replaceContact(actual);
        // when
        Contact result = contacts.getContactByNumber("33333");
        // then
        assertThat(result, notNullValue());
        assertThat(result, hasProperty("lastName", equalTo("DD4")));
        assertThat(result, equalTo(actual));
    }

    @Test
    public void deleteContact() {
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
        // Hamcrest
        assertThat(actual, notNullValue());
        assertThat(result, nullValue());
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
        // Hamcrest
        assertThat(result, nullValue());
    }
    @Test
    void getContactByNumber_NULL_CONTACT() {
        // given
        // when
        Contact result = contacts.getContactByNumber(null);
        // then
        Assertions.assertNull(result);
        // Hamcrest
        assertThat(result, nullValue());
    }
    @Test
    void existInContacts() {
        // given
        contacts.addContact(contact1);
        contacts.addContact(contact2);
        contacts.addContact(contact3);
        // when
        boolean result = contacts.existInContacts("22222");
        // then
        assertThat(result, Matchers.equalTo(true));
        // when
        result = contacts.existInContacts("55555");
        // then
        assertThat(result, Matchers.equalTo(false));
    }
}