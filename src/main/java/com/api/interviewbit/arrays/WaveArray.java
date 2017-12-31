package com.api.interviewbit.arrays;
import java.util.Collections;
import java.util.ArrayList;
/**
 * Given an array of integers, sort the array into a wave like array and return it,
 In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....

 Example

 Given [1, 2, 3, 4]

 One possible answer : [2, 1, 4, 3]
 Another possible answer : [4, 1, 3, 2]
 If there are multiple answers possible, return the one that is lexicographically smallest.
 So, in example case, you will return [2, 1, 4, 3]
 */
public class WaveArray {
    public ArrayList<Integer> wave(ArrayList<Integer> A) {
        Collections.sort(A);
        int len = A.size();
        int val = 0,val1=0;
        int i=0;
        while(i+1<len){
            val = A.get(i).intValue();
            val1 =  A.get(i+1).intValue();
            A.set(i,val1);
            A.set(i+1,val);
            i = i+2;
        }
        return A;
    }
}
