package com.company;

import java.util.*;
// Список контактов
public class Contacts {
    private Map<String, Contact> contactMap;
    // конструктор
    public Contacts() {
        this.contactMap = new HashMap<>();
    }
    // добавить контакт
    public void addContact(Contact contact) {
        if(!contactMap.containsKey(contact.getNumber())) {
            contactMap.put(contact.getNumber(), contact);
        }
    }
    // заменить контакт
    public void replaceContact(Contact contact) {
        if(contactMap.containsKey(contact.getNumber())) {
            contactMap.replace(contact.getNumber(), contact);
        }
    }
    // удалить контакт
    public boolean deleteContact(String number) {
        if(contactMap.containsKey(number)) {
            contactMap.remove(number);
            return true;
        }
        return false;
    }
    // получить контакт по номеру
    public Contact getContactByNumber(String number) {
        if(contactMap.containsKey(number)) {
            return contactMap.get(number);
        }
        return null;
    }
    // данные контакта по номеру
    public String infoContactByNumber(String number) {
        if(contactMap.containsKey(number)) {
            return contactMap.get(number).toString();
        }
        return "";
    }
    // проверка наличия контакта по номеру
    public boolean existInContacts(String number) {
        return contactMap.containsKey(number);
    }
}
