package ru.ryabtsev;

import java.util.ArrayList;
import java.util.List;

/**
 * Converts list of objects to corresponding tree.
 */
public class ListToTreeApplication
{
    public static void main( String[] args )
    {
        List<Human> humans = new ArrayList<>();
        humans.add(new Human(1, 0));
        humans.add(new Human(2, 0));
        humans.add(new Human(3, 1));
        humans.add(new Human(4, 3));
        humans.add(new Human(5, 4));
        humans.add(new Human(6, 0));

        System.out.println("Initial list: ");
        for( Human human: humans) {
            System.out.println(human);
        }

        HumanTree tree = new HumanTree(humans);
        System.out.println("Tree has been created.");

        System.out.println("Checking...");
        for(int i = 0; i < 7; ++i) {
            if(!tree.findNodeById(i)) {
                System.out.println("Check failed at " + i + " value.");
                return;
            }
        }
        System.out.println("Check successful.");
    }
}
