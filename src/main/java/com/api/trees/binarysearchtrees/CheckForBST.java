package com.api.trees.binarysearchtrees;
import com.api.trees.Node;

/**
 * A binary search tree (BST) is a node based binary tree data structure which has the following properties.
 • The left subtree of a node contains only nodes with keys less than the node’s key.
 • The right subtree of a node contains only nodes with keys greater than the node’s key.
 • Both the left and right subtrees must also be binary search trees.

 From the above properties it naturally follows that:
 • Each node (item in the tree) has a distinct key.
 */
public class CheckForBST {

    /**
     *
     * @param root Given the root node of a tree, it finds if the tree is a binary
     *             search tree
     * @return 0 if it is not a binary search tree, returns 1 if it is a valid
     *          binary tree
     */
    public int isBST(Node root){
        /**
         * Approach
         * Create a Node previous that will store the value of the node that
         * was last encountered during an inorder traversal
         * An inorder traversal of a Binary search tree returns an
         *  array of sorted integers - they are sorted increasingly
         *  Here, we need not store the entire results of inorder traversal in an array
         *  We just need to check if the previous element was less than the current
         *  element during traversal.
         */
        Node previous = new Node(Integer.MIN_VALUE);
        boolean answer = inOrderTraversal(root,previous);
        if(answer) return 1;
        else return 0;
    }

    public boolean inOrderTraversal(Node root,Node previous){
        boolean answer = true;
        if(root==null) return true;
        if(root.left!=null)
            answer = inOrderTraversal(root.left,previous);
        if(!answer) return answer;
        if(root.data<=previous.data) return false;
        else previous.data = root.data;
        if(root.right!=null)
            answer = inOrderTraversal(root.right,previous);
        if(!answer) return answer;
        return true;
    }

}
