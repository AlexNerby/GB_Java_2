package ru.gb2.lesson1;

public class Main {
    public static void main(String[] args) {

        Participants[] participants = {new Human("Mike", 1500, 1.5),
                new Cat("Barsik", 700, 1),
                new Robot("R2D2", 5000, 2)};

        Obstacles[] obstacles = {new Treadmill(1000), new Wall(1.9)};

        startGame(participants, obstacles);
    }

    static void startGame (Participants[] participants,Obstacles[] obstacles) {
        for (Participants p : participants) {
            System.out.printf("Starting participant: %s\n", p.getClassName());
            for (Obstacles o : obstacles) {
                if (o.let(p)) {
                } else {
                    System.out.printf("%s don't move %s\n\n", p.getClassName(), o.getClassName());
                    break;
                }
            }
        }
    }
}
