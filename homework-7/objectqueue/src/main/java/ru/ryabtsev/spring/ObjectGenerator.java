package ru.ryabtsev.spring;

import java.util.Random;

/**
 * Implements random object generation.
 */
public class ObjectGenerator {

    private Random random;



    public ObjectGenerator(int seed) {
        this.random = new Random(seed);
    }

    public Object generate() {
        int number = random.nextInt() % 4;

        switch(number) {
            case 0:
                return random.nextDouble();
            case 1:
                return random.nextInt();
            case 2:
                return random.nextBoolean();
            case 3:
                return random.nextFloat();
        }

        return null;
    }
}
