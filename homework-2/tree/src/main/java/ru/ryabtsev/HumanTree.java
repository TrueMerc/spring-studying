package ru.ryabtsev;

import java.util.Comparator;
import java.util.List;

public class HumanTree {

    private HumanTreeNode root;

    public HumanTree(List<Human> humanList) {
        root = null;
        humanList.sort(new Comparator<Human>() {
                           @Override
                           public int compare(Human h1, Human h2) {
                               return h1.getParentId() - h2.getParentId();
                           }
                       }
        );
    }
}
