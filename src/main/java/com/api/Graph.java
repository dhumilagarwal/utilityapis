package com.api;
import java.util.*;
public class Graph {

    private int vertices;
    private ArrayList<ArrayList<Integer>> adjacencyList;

    // Constructor to start a graph
    public Graph(int v){
        vertices = v;
        adjacencyList = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<vertices;i++)
            adjacencyList.add(new ArrayList<Integer>());
    }

    // Adds an edge between start node and destination node
    public boolean addEdge(int start,int destination){
        if(start<0 || destination<0 || start>=vertices || destination>=vertices)
            return false;
        adjacencyList.get(start).add(destination);
        return true;
    }

    public ArrayList<Integer> getDFSTraversalFromVertex(int start){
        ArrayList<Integer> dfsResults = new ArrayList<Integer>();
        if(start<0 || start>=vertices) return dfsResults;
        boolean visited[] = new boolean[vertices];
        Stack<Integer> tobeVisited = new Stack<Integer>();
        tobeVisited.push(start);
        visited[start] = true;
        int visitedNode = start;
        int neighborsCount = 0;
        int currentNode = 0;
        while (!tobeVisited.isEmpty()){
            visitedNode = tobeVisited.pop().intValue();
            dfsResults.add(visitedNode);
            ArrayList<Integer> neighbors = adjacencyList.get(visitedNode);
            neighborsCount = neighbors.size();
            for(int r=0;r<neighborsCount;r++){
                currentNode = neighbors.get(r).intValue();
                if(!visited[currentNode]){
                    tobeVisited.push(currentNode);
                    visited[currentNode] = true;
                }
            }
        }
        return dfsResults;
    }

    public ArrayList<ArrayList<Integer>> getAdjacencyList() {
        return adjacencyList;
    }

    public ArrayList<Integer> getBFSTraversalFromVertex(int start){
        ArrayList<Integer> bfsResults = new ArrayList<Integer>();
        if(start<0 || start>=vertices) return bfsResults;
        boolean visited[] = new boolean[vertices];
        Queue<Integer> tobeVisited = new LinkedList<Integer>();
        tobeVisited.add(start);
        visited[start] = true;
        int neighborCount = 0;
        int exploredNode = start;
        int neighborNode = 0;
        bfsResults.add(exploredNode);
        while(!tobeVisited.isEmpty()){
            exploredNode = tobeVisited.poll().intValue();
            ArrayList<Integer> neighbors = adjacencyList.get(exploredNode);
            neighborCount = neighbors.size();
            for(int k=0;k<neighborCount;k++){
               neighborNode = neighbors.get(k).intValue();
               if(!visited[neighborNode]){
                   visited[neighborNode] = true;
                   tobeVisited.add(neighborNode);
                   bfsResults.add(neighborNode);
               }
            }
        }
        return bfsResults;
    }

    public boolean addVertex(){
        adjacencyList.add(new ArrayList<Integer>());
        vertices++;
        return true;
    }
}
