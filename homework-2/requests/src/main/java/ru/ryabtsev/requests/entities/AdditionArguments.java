package ru.ryabtsev.requests.entities;

public class AdditionArguments {
    private int first;
    private int second;

    AdditionArguments() {
        this.first = 0;
        this.second = 0;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }
}
