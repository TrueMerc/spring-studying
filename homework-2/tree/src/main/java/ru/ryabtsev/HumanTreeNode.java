package ru.ryabtsev;

import java.util.LinkedList;
import java.util.List;

public class HumanTreeNode {

    private List<HumanTreeNode>  children = new LinkedList<>();
    private int id;

    HumanTreeNode(int id) {
        this.id = id;
    }

    void addChild(int id) {
        children.add(new HumanTreeNode(id));
    }

    boolean addChild(Human human) {
        if(human.getParentId() == this.id) {
            children.add(new HumanTreeNode(human.getId()));
            return true;
        }
        return false;
    }

    List<HumanTreeNode> getChildren() {
        return children;
    }

    public int getId() {
        return id;
    }

}
