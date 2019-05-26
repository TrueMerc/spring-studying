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

    @Override
    public String toString() {
        return "Id = " + id + ", parentId = " + parentId;
    }
}
