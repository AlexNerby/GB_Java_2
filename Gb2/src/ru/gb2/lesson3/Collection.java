package ru.gb2.lesson3;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Collection {
    public static void main(String[] args) {

        Words[] arr = {new Words("house"), new Words("name"), new Words("order"),
                new Words("book"), new Words("car"), new Words("name"),
                new Words("number"), new Words("order"), new Words("red"),
                new Words("name"), new Words("red")};

        Set<Words> uniqueWords = new HashSet<>(Arrays.asList(arr));

//        task1(arr, uniqueWords);
        task1_1(arr, uniqueWords);
        System.out.println();

        PhoneBook task2 = new PhoneBook("Ivanov", 555L);
        task2.add("Petrov", 79998885544L);
        task2.add("Ivanov", 74449546444L);
        task2.add("Smirnov", 73255558878L);
        task2.add("Ivanov", 9994525L);
        task2.add("Popov", 7777777L);
        task2.add("Smirnov", 5552505L);

        System.out.println(task2);

        task2.get("Ivanov");
        task2.get("Petrov");
        task2.get("Smirnov");
    }

    //Нашел короче)
    static void task1_1(Words[] arr, Set<Words> uniqueWords) {
        for (Words word : uniqueWords) {
            word.setCount(Collections.frequency(Arrays.asList(arr), word));
        }
        System.out.println(uniqueWords);
    }

//    static void task1(Words[] arr, Set<Words> uniqueWords) {
//        for (Words word : arr) {
//            int count = 0;
//            for (Words check : arr) {
//                if (word.getName().equals(check.getName())) {
//                    word.setCount(++count);
//                }
//            }
//            uniqueWords.add(word);
//        }
//        System.out.println(uniqueWords);
//    }
}
