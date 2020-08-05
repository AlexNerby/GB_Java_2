package ru.gb.lesson7;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public void eat(Plate p) {
        if (p.getFood() >= appetite) {
            satiety = p.decreaseFood(appetite);
            System.out.printf("%s поел, в тарелке осталось %d еды.\n", name, p.getFood());
        } else
            System.out.printf("%s голодный, в тарелке осталось всего %d еды.\n", name, p.getFood());
    }
}
