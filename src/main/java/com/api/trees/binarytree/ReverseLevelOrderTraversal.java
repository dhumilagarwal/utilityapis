package com.api.trees.binarytree;
import com.api.trees.Node;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class ReverseLevelOrderTraversal {

    public void levelOrder(Node node){
        ArrayList<Integer> results = getReverseLevelOrderTraversal(node);
        int len = results.size();
        for(int i=0;i<len;i++)
            System.out.print(results.get(i) + " ");
    }

    public ArrayList<Integer> getReverseLevelOrderTraversal(Node root){
        ArrayList<Integer> traversal = new ArrayList<Integer>();
        Queue<Node> levelOrderQueue = new LinkedList<Node>();
        ArrayList<Integer> levels = new ArrayList<Integer>();
        levelOrderQueue.add(root);

        while (!levelOrderQueue.isEmpty()){
            Node temp = levelOrderQueue.remove();
            if(temp.left!=null) levelOrderQueue.add(temp.left);
            if(temp.right!=null) levelOrderQueue.add(temp.right);
            traversal.add(temp.data);
        }
        return traversal;
    }
}
