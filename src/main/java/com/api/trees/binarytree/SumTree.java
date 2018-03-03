package com.api.trees.binarytree;
import com.api.trees.Node;
public class SumTree {

    boolean isSumTree(Node node)
    {
        // Your code here
        if(node==null) return true;
        if(node.left==null && node.right==null) return true;
        boolean left = isSumTree(node.left);
        boolean right = isSumTree(node.right);
        if(left && right){
            int val = node.data;
            if(node.left!=null) {
                val = val - node.left.data;
                if(node.left.left!=null || node.left.right!=null)
                    val  = val - node.left.data;
            }
            if(node.right!=null) {
                val = val - node.right.data;
                if(node.right.left!=null || node.right.right!=null)
                    val  = val - node.right.data;
            }
            if(val==0) return true;
            else return false;
        }
        else return false;
    }
}
