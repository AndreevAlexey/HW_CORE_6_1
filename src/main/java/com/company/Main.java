package com.company;

import java.util.*;

public class Main {
    // Добавить контакт
    static void addContact(Contacts contacts, Scanner scanner) {
        String input;           // строка ввода данных
        String[] inputContact;  // данные контакта
        Contact contact;        // контакт
        // считываем данные контакта
        System.out.println("Введите имя фамилия номер группа контакта через пробел:");
        input = scanner.nextLine();
        // обработка
        try {
            // разбиваем строку в массив
            inputContact = input.split(" ");
            if (!contacts.existInContacts(inputContact[2])) {
                // создаем контакт
                contact = new Contact(inputContact[0], inputContact[1], inputContact[2], Group.valueOf(inputContact[3]));
                // добавляем
                contacts.addContact(contact);
            } else {
                System.out.println("Контакт с таким номером уже есть!");
            }
        } catch(RuntimeException exp) {
            System.out.println("Введены некорректные данные!");
        }
    }
    // Добавить пропущенный вызов
    static void addMissedCall(Missed missed, Scanner scanner) {
        String input;           // строка ввода данных
        // считываем данные контакта
        System.out.println("Введите номер пропущенного вызова:");
        input = scanner.nextLine();
        // добавляем
        missed.addCall(input);
    }
    // Редактировать контакт
    static void editContact(Contacts contacts, Scanner scanner) {
        String input;           // строка ввода данных
        String[] inputContact;  // данные контакта
        Contact contact;        // контакт
        // считываем данные контакта
        System.out.println("Введите номер контакта для редактирования:");
        input = scanner.nextLine();
        // есть такой контакт
        if(contacts.existInContacts(input)) {
            // получить контакт
            contact = contacts.getContactByNumber(input);
            // ввод новых данных
            System.out.println("Введите новые имя фамилия группа контакта:");
            input = scanner.nextLine();
            // обработка
            try {
                // разбиваем строку в массив
                inputContact = input.split(" ");
                // установка новых значений
                contact.setName(inputContact[0]);
                contact.setLastName(inputContact[1]);
                contact.setGroup(Group.valueOf(inputContact[2]));
                // заменяем на новый
                contacts.replaceContact(contact);
                System.out.println("Контакт изменен.");
            } catch(RuntimeException exp) {
                System.out.println("ведены некорректные данные!");
            }
        } else {
            System.out.println("Контакт с таким номер не найден!");
        }

    }
    // Удалить контакт
    static void deleteContact(Contacts contacts, Scanner scanner) {
        String input; // строка ввода данных
        // считываем данные контакта
        System.out.println("Введите номер контакта для удаления:");
        input = scanner.nextLine();
        // удаление
        if(contacts.deleteContact(input)) System.out.println("Контакт удален.");
        else System.out.println("Контакт с таким номер не найден!");
    }

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);// сканнер
	    Missed missed = new Missed();           // пропущенные вызовы
	    Contacts contacts = new Contacts();     // контакты
	    String input;                           // строка ввода
	    int choise;                             // выбор меню
        // основной цикл программы
	    while(true) {
            System.out.println("Выберите действие:"
                    + "\n1. Добавить контакт"
                    + "\n2. Добавить пропущенный вызов"
                    + "\n3. Вывести пропущенные вызовы"
                    + "\n4. Удалить пропущенные вызовы"
                    + "\n5. Редактировать контакт"
                    + "\n6. Удалить контакт"
                    + "\n0. Выход"
            );
            // считываем выбор операции
            input = scanner.nextLine();
            // преобразование в число
            try {
                choise = Integer.parseInt(input);
            } catch (NumberFormatException ex) {
                System.out.println("Введено некорректное значение!");
                continue;
            }
            // проверка на выход
            if (choise == 0) {
                break;
            }
            // обработка выбора операции
            switch(choise) {
                // Добавить контакт
                case 1:{
                    addContact(contacts, scanner);
                    break;
                }
                // Добавить пропущенный вызов
                case 2: {
                    addMissedCall(missed, scanner);
                    break;
                }
                // Вывести пропущенные вызовы
                case 3: {
                    System.out.println(missed.getMissedCalls(contacts));
                    break;
                }
                // Удалить пропущенные вызовы
                case 4: {
                    missed.clear();
                    System.out.println("Список пропущенных вызовов удален.");
                    break;
                }
                // Редактировать контакт
                case 5: {
                    editContact(contacts, scanner);
                    break;
                }
                // Удалить контакт
                case 6: {
                    deleteContact(contacts, scanner);
                    break;
                }
            }
        }
    }
}
