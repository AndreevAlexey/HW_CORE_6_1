package com.company;

import java.util.Objects;

public class Contact {
    private String name;       // имя
    private String lastName;   // фамилия
    private String number;     // номер
    private Group group;       // группа
    // конструктор
    public Contact(String name, String lastName, String number, Group group) {
        this.name = name;
        this.lastName = lastName;
        this.number = number;
        this.group = group;
    }
    // геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
    // toString
    @Override
    public String toString() {
        return name + ' ' + lastName + ' ' + number + " группа: " + group;
    }
    // hashCode
    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
    // equals
    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Contact other = (Contact) obj;
        return this.number.equals(other.number);
    }
}
