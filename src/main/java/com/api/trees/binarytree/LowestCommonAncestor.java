package com.api.trees.binarytree;
import java.util.ArrayList;
import com.api.trees.Node;

/**
 * https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
 */
public class LowestCommonAncestor {

    static Node lca(Node root,int v1,int v2)
    {
        Node answer = root;
        ArrayList<Node> pathToFirst = new ArrayList<Node>();
        getPathFromRootToNode(root,v1,pathToFirst);
        ArrayList<Node> pathToSecond = new ArrayList<Node>();
        getPathFromRootToNode(root,v2,pathToSecond);
        int lenFirst = pathToFirst.size();
        int lenSecond = pathToSecond.size();
        int i=0;
        while(i<lenFirst && i<lenSecond){
            if(pathToFirst.get(i).data!=pathToSecond.get(i).data){
                return (pathToFirst.get(i-1));
            }
            i++;
        }

        if(i==lenFirst) return (pathToFirst.get(i-1));
        else if(i==lenSecond) return (pathToSecond.get(i-1));

        return answer;

    }

    public static boolean getPathFromRootToNode(Node root,int v1,ArrayList<Node> path){
        if(root==null) return false;
        if(root.data==v1) {
            path.add(root);
            return true;
        }
        path.add(root);
        if(getPathFromRootToNode(root.left,v1,path)==true) return true;
        if(getPathFromRootToNode(root.right,v1,path)==true) return true;
        path.remove(path.size()-1);
        return false;
    }



}
