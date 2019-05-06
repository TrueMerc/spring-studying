package ru.ryabtsev;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 *
 */
public class ListToTree
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

        Collections.sort(humans, (h1, h2)->{
            int result = h1.getParentId() - h2.getParentId();
            return (0 != result) ? result : h1.getId() - h2.getId();
        });

        System.out.println("List ordered by ids");
        for(Human human: humans) {
            System.out.println(human);
        }

        HumanTree tree = new HumanTree(humans);

        System.out.println("Tree has been created.");

    }
}
