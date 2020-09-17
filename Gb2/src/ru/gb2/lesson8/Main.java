package ru.gb2.lesson8;

public class Main {

    public static void main(String[] args) {

        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.add("Toyota");
        doublyLinkedList.add("Honda");
        doublyLinkedList.add("Subaru");
        doublyLinkedList.add("Mazda");
        doublyLinkedList.add("Nissan");

        System.out.println(doublyLinkedList);

        doublyLinkedList.remove("Subaru");
        System.out.println(doublyLinkedList);
    }
}
