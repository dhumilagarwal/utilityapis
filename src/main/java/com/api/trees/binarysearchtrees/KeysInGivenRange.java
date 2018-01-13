package com.api.trees.binarysearchtrees;
import com.api.trees.Node;

import java.util.ArrayList;

/**
 * https://practice.geeksforgeeks.org/problems/print-bst-elements-in-given-range/1
 * https://www.geeksforgeeks.org/print-bst-keys-in-the-given-range/
 * Given a Binary Search Tree (BST) and a range, print all the numbers in the BST
 * that lie in the given range. You are required to complete the function
 * printNearNodes. You should not read any input from stdin/console.
 * There are multiple test cases. For each test case, this method will
 * be called individually.
 *
 * The first line of the input contains an integer 'T' denoting the nummber of
 * test cases. Then 'T' test cases follow. Each test case consists of three lines.
 * Description of  test cases is as follows:
 The First line of each test case contains an integer 'N' which denotes the no of nodes in the BST.   .
 The Second line of each test case contains 'N' space separated values of the nodes in the BST.
 The Third line of each test case contains two space separated integers 'l' and 'h' denoting the
 range, where l < h .

 You are required to complete the function printNearNodes which takes three arguments.
 The first being the root of the tree, and then two integers l and h, denoting the range.
 The function shold print all the nodes which lie in the given range in the BST .
 Constraints:
 1 <= T <= 50
 1 <= N <= 50
 1 <= l < h < 1000
 */

public class KeysInGivenRange {

    void Print(Node node, int k1, int k2)
    {
        // Your code here
        getInOrderTraversal(node,k1,k2);
    }

    void getInOrderTraversal(Node node,int min,int max){
        ArrayList<Integer> inorder = new ArrayList<Integer>();
        // System.out.println("Start");
        doInorder(node,min,max,inorder);
        int len = inorder.size();
        //System.out.println(len);
        for(int i=0;i<len;i++){
            System.out.print(inorder.get(i).intValue() + " ");
        }
    }

    void doInorder(Node root,int min,int max,ArrayList<Integer> inorder){
        if(root==null) return;
        if(root.data>min)
            doInorder(root.left,min,max,inorder);
        if(root.data>=min && root.data<=max)
            inorder.add(root.data);
        if(root.data<max)
            doInorder(root.right,min,max,inorder);
        // System.out.println(inorder.size());
    }
}
