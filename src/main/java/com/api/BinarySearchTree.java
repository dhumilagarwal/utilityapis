package com.api;

public class BinarySearchTree {

    int data;
    BinarySearchTree leftNode;
    BinarySearchTree rightNode;

    public BinarySearchTree(int rootValue){
        data = rootValue;
        leftNode = null;
        rightNode = null;
    }

    public BinarySearchTree createTree(int data[]) throws EmptyTreeException{
        if(data.length==0) throw new EmptyTreeException();
        BinarySearchTree root = new BinarySearchTree(data[0]);
        return root;
    }

    public BinarySearchTree insertBulkDataInTree(int data[],BinarySearchTree root) throws EmptyTreeException{
        int dataLength = data.length;
        if(dataLength==0) throw new EmptyTreeException();
        BinarySearchTree rootNode = null;
        int startIndex = 0;
        if(root==null) {
            rootNode = new BinarySearchTree(data[0]);
            startIndex++;
        } else{
            rootNode = root;
        }
        for(int i=startIndex;i<dataLength;i++){
            rootNode = insertNode(data[i],rootNode);
        }
        return rootNode;
    }

    public BinarySearchTree insertNode(int data,BinarySearchTree root){
        if(root==null) return new BinarySearchTree(data);
        if(data<root.data) root.leftNode = insertNode(data,root.leftNode);
        else if(data>root.data) root.rightNode = insertNode(data,root.rightNode);
        return root;
    }

}
