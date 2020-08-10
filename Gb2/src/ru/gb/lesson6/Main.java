package ru.gb.lesson6;

public class Main {
    public static void main(String[] args) {

        Cat vaska = new Cat("Vaska", 200, 2);
        vaska.grp(200, 1, 11);

        Dog sharik = new Dog("Sharik", 500, 0.5, 10);
        sharik.grp(510, 1.9, 15);

        Dog bobik = new Dog("Bobik", 600, 2, 15);
        bobik.grp(510, 2, 15);
    }
}
