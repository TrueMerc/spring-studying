package ru.ryabtsev.spring;

/**
 * Implements marker for visited objects in Queue.
 */
public class Marker<T> {
    private T object;

    public Marker(T object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return this.object != null ? this.object.toString() : "null";
    }
}
