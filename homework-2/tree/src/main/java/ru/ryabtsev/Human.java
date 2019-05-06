package ru.ryabtsev;


public class Human {
    private int id;
    private int parentId;


    public Human(int id, int parentId) {
        this.id = id;
        this.parentId = parentId;
    }

    public int getParentId() {
        return parentId;
    }

    public int getId() {
        return id;
    }
}
