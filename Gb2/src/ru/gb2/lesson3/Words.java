package ru.gb2.lesson3;

import java.util.Objects;

public class Words {

    private String name;
    private int count;

    public void setCount(int count) {
        this.count = count;
    }

    public Words(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "\nWords{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Words words = (Words) o;
        return Objects.equals(name, words.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
