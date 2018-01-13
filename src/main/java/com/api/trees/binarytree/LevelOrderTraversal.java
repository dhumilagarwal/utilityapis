package com.api.trees.binarytree;
import com.api.trees.Node;

import java.util.*;

/**
 * https://www.geeksforgeeks.org/level-order-tree-traversal/
 */
public class LevelOrderTraversal {

    public void levelOrder(Node node){
        ArrayList<Node> results = getLevelOrderTraversal(node);
        int len = results.size();
        for(int i=0;i<len;i++)
            System.out.print(results.get(i).data + " ");
    }

    public ArrayList<Node> getLevelOrderTraversal(Node root){
        ArrayList<Node> traversal = new ArrayList<Node>();
        Queue<Node> levelOrderQueue = new LinkedList<Node>();
        levelOrderQueue.add(root);
        while (!levelOrderQueue.isEmpty()){
            Node temp = levelOrderQueue.remove();
            if(temp.left!=null) levelOrderQueue.add(temp.left);
            if(temp.right!=null) levelOrderQueue.add(temp.right);
            traversal.add(temp);
        }
        return traversal;
    }
}
