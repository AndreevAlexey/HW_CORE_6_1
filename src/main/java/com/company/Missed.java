package com.company;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
// Пропущенные вызовы
public class Missed {
    private TreeMap<LocalDateTime, String> treeMap;
    // конструктор
    public Missed() {
        this.treeMap = new TreeMap<>();
    }
    // добавить вызов
    public void addCall(String number) {
        treeMap.put(LocalDateTime.now(), number);
    }
    // очистить пропущенные вызовы
    public void clear() {
        treeMap.clear();
    }
    // получить список пропущенных вызовов
    public String getMissedCalls(Contacts contacts) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm:ss");
        StringBuilder sb = new StringBuilder();
        String number;
        LocalDateTime ldt;
        // цикл по элементам мапы
        for(Map.Entry<LocalDateTime, String> entry : treeMap.entrySet()){
            // номер телефона
            number = entry.getValue().toString();
            // дата в нужном формате
            ldt = (LocalDateTime) entry.getKey();
            // формирование строки
            sb.append(formatter.format(ldt) +" ");
            if(contacts.existInContacts(number)) sb.append(contacts.infoContactByNumber(number));
            else sb.append(entry.getValue());
            sb.append("\n");
        }
        if(sb.length() == 0) return "Нет пропущенных вызовов";
        return sb.toString();
    }

}
