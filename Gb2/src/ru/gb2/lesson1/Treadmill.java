package ru.gb2.lesson1;

public class Treadmill implements Obstacles{

    private int trackLength;

    public Treadmill(int trackLength) {
        this.trackLength = trackLength;
    }

    @Override
    public String getClassName() {
        String s = getClass().getSimpleName() + " ";
        return s;
    }

    @Override
    public boolean let(Participants p) {
        if (p.getRunLimit() >= trackLength) {
            p.run();
            return true;
        } else
            return false;
    }
}
