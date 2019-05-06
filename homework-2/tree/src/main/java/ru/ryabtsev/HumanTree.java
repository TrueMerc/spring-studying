package ru.ryabtsev;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HumanTree {

    private HumanTreeNode root;

    public HumanTree(List<Human> humanList) {
        root = null;
        Collections.sort(humanList, Comparator.comparingInt(Human::getParentId));

        int currentParentId = humanList.get(0).getParentId();
    }
}
