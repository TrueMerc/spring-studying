package ru.ryabtsev;

import java.util.Collections;

import java.util.List;

public class HumanTree {

    private HumanTreeNode root;

    public HumanTree(List<Human> humans) {
        root = null;
        Collections.sort(humans, (h1, h2)->{
            int result = h1.getParentId() - h2.getParentId();
            return (0 != result) ? result : h1.getId() - h2.getId();
        });

        int currentParentId = humans.get(0).getParentId();

        root = new HumanTreeNode(currentParentId);
        HumanTreeNode currentNode = root;

        while(!humans.isEmpty()) {
            Human human = humans.remove(0);
            currentNode = recursiveFind(currentNode, human.getParentId());
            if(null != currentNode && currentNode.addChild(human)) {
                currentNode = root;
                continue;
            }
            else {
                if(null == currentNode) {
                    break;
                }
//                List<HumanTreeNode> children = root.getChildren();
//
//                int j = 0;
//                for(; j < children.size(); ++j) {
//                    if(children.get(i).getId() == currentParentId) {
//                        root = children.get(i);
//                        break;
//                    }
//                }
//
//                if(j == children.size()) {
//                    root = root.getParent();
//                }
//
//                currentParentId = root.getId();
            }
        }
    }

    public HumanTreeNode findNodeById(int id) {
        return recursiveFind(root, id);
    }

    private HumanTreeNode recursiveFind(HumanTreeNode currentNode, int value) {
        if(currentNode == null) {
            return null;
        }

        if(currentNode.getId() == value) {
            return currentNode;
        }

//        return value < currentNode.value ?
//                recursiveFind(currentNode.leftChild, value) : recursiveFind(currentNode.rightChild, value);
        List<HumanTreeNode> children = currentNode.getChildren();
        if(currentNode.getChildren().isEmpty()) {
            return null;
        }

        for(int i = 0; i < children.size(); ++i) {
            HumanTreeNode result = recursiveFind(children.get(i), value);
            if(null != result) {
                return result;
            }
        }

        return null;
    }

}
