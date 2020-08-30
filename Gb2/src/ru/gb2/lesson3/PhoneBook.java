package ru.gb2.lesson3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PhoneBook {

    private Map<String, HashSet<Long>> map = new HashMap<>();
    private HashSet<Long> numbers;

    public PhoneBook(String lastName, Long number) {
        add(lastName, number);
    }

    public HashSet<Long> get(String lastName) {
        System.out.println(lastName + ": " + map.get(lastName));
        return map.get(lastName);
    }

    public void add(String lastName, Long number) {
        numbers = map.getOrDefault(lastName, new HashSet<>());
        numbers.add(number);
        map.put(lastName, numbers);
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "map=" + map +
                '}';
    }
}
