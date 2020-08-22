package ru.gb2.lesson1;

public class Wall implements Obstacles {

    private double height;

    public Wall(double height) {
        this.height = height;
    }

    @Override
    public boolean let(Participants p) {
        if (p.getJumpLimit() >= height) {
            p.jump();
            System.out.printf("\n");
            return true;
        } else
            return false;
    }

    @Override
    public String getClassName() {
        String s = getClass().getSimpleName() + " ";
        return s;
    }
}
