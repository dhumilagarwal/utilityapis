package com.api.trees.binarytree;
import com.api.trees.ExpressionNode;
/**
 * Given a simple expression tree, which is also a full binary tree consisting of
 * basic binary operators i.e., + , – ,* and / and some integers, Your task is
 * to evaluate the expression tree. You need to complete the function evalTree
 * which takes the root of the tree as its only argument and returns an integer
 * denoting the result obtained by simplifying the expression tree.
 */
public class ExpressionTree {
    public static final String into = "*";
    public static final String sum = "+";
    public static final String minus = "-";
    public static final String divide = "/";

    public int evalTree(ExpressionNode root)
    {
        //Your code here.
        if(root.data.equals(into)){
            return (evalTree(root.left) * evalTree(root.right));
        } else if (root.data.equals(sum)){
            return (evalTree(root.left) + evalTree(root.right));
        } else if (root.data.equals(minus)){
            return (evalTree(root.left) - evalTree(root.right));
        } else if (root.data.equals(divide)){
            return (evalTree(root.left) / evalTree(root.right));
        } else return (Integer.parseInt(root.data));
    }
}
