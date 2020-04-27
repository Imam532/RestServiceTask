package ru.shara.restexample.model;

public class Letters {
    private Character letter;
    private int count;

    public Letters(Character letter, int count) {
        this.letter = letter;
        this.count = count;
    }

    public Character getLetter() {
        return letter;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "" + count;
    }
}
