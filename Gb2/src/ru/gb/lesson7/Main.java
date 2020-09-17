package ru.gb.lesson7;

public class Main {
    public static void main(String[] args) {
        Plate plate = new Plate(20);
        Cat[] cats = {
                new Cat("Barsik", 16),
                new Cat("Murzik", 21),
                new Cat("Vasya", 23),
                new Cat("Rijik", 12)
        };
        feedTheCats(cats, plate, 20);
    }

    static void feedTheCats(Cat[] cats, Plate plate, int addFood) {
        for (Cat cat : cats) {
            cat.eat(plate);
            while (!cat.isSatiety()) {
                plate.setFood(addFood);
                cat.eat(plate);
            }
            System.out.println();
        }
    }
}
