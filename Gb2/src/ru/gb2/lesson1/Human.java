package ru.gb2.lesson1;

public class Human implements Participants{

    private String name;
    private int runLimit;
    private double jumpLimit;

    public Human(String name, int runLimit, double jumpLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getClassName() {
        String s = getClass().getSimpleName() + " " + getName();
        return s;
    }

    @Override
    public int getRunLimit() {
        return runLimit;
    }

    @Override
    public double getJumpLimit() {
        return jumpLimit;
    }

    @Override
    public void run() {
        System.out.println(getClassName() + " run");
    }

    @Override
    public void jump() {
        System.out.println(getClassName() + " jump");
    }
}
