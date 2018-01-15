package com.api.interviewbit.heapsandmaps;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.LinkedList;
public class LRUCache {
    HashMap<Integer,Node> cacheMap;
    Node start;
    Node end;
    Node startWaste;
    Node endWaste;
    int capacity;
    int size;
    public LRUCache(int capacity){
        cacheMap = new HashMap<Integer, Node>();
        start = new Node(-1);
        end = new Node(-1);
        start.next = end;
        end.previous = start;
        this.capacity = capacity;
        this.size = 0;
        startWaste = new Node(-1);
        endWaste = new Node(-1);
        start.previous = startWaste;
        end.next = endWaste;
    }
    public int get(int key) {
        Node answer = cacheMap.get(key);
        if(answer!=null){
            Node temp = answer;
            // Remove the element from this location
            answer.previous.next = answer.next;
            answer.next.previous = answer.previous;
            int val = temp.value;
            // Shift this element to the start of the List
            start.next.previous = temp;
            temp.next = start.next;
            start.next = temp;
            temp.previous = start;
            // Update the hashmap
            temp.value = val;
            cacheMap.put(key,temp);
            return val;
        }
        return -1;
    }

    public void set(int key, int value) {
        Node answer = cacheMap.get(key);
        if(answer!=null){
            Node temp = answer;
            // Remove the element from this location
            answer.previous.next = answer.next;
            answer.next.previous = answer.previous;
            temp.value = value;
            // Shift this element to the start of the List
            start.next.previous = temp;
            temp.next = start.next;
            start.next = temp;
            temp.previous = start;
            // Update the hashmap
            cacheMap.put(key,temp);
        } else {
            // Create a new Node
            Node newNode = new Node(value);
            // Insert new node at the start
            start.next.previous = newNode;
            newNode.next = start.next;
            start.next = newNode;
            newNode.previous = start;
            // Update the hashmap
            cacheMap.put(key,newNode);
            // Increment size
            size++;
            // Check for size
            if(size>=capacity){
                // Delete the last element
               // Node toBeDeleted = end.previous;
                cacheMap.remove(key);
                end.previous.previous.next = end;
                end.previous = end.previous.previous;
            }
        }
    }
}

class Node{
    int value;
    Node next;
    Node previous;
    public Node(int val){
        value = val;
        next = null;
        previous = null;
    }
}
