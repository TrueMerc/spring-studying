package ru.ryabtsev.spring;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Implements object queue application.
 */
public class ObjectQueueApplication
{
    private static final int GENERATOR_SEED = 1000;
    private static final int QUEUE_LENGTH = 2000000;

    public static void main( String[] args )
    {
        Queue<Object> queue = new ArrayDeque<>();

        ObjectGenerator generator = new ObjectGenerator(GENERATOR_SEED);

        for(int i = 0; i < QUEUE_LENGTH; ++i) {
            queue.add(generator.generate());
        }

        Object firstElement = queue.poll();
        System.out.println("The first element is " + ((firstElement != null) ? firstElement : "null"));
        Marker<Object> markedFirstElement = new Marker<>(firstElement);
        int firstElementHashCode = markedFirstElement.hashCode();
        queue.add(markedFirstElement);

        Object nextElement;

        int counter = 0;

        do {
            nextElement = queue.poll();
            queue.add(new Marker<Object>(nextElement));
            ++counter;

        }
        while(nextElement.hashCode() != firstElementHashCode);

        System.out.println("Elements proceeded: " + counter);
        System.out.println("The first element is " + nextElement);
    }


}
