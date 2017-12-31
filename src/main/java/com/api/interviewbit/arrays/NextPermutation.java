package com.api.interviewbit.arrays;
import java.util.ArrayList;
/**
 * Implement the next permutation, which rearranges numbers into the numerically
 * next greater permutation of numbers.

 If such arrangement is not possible, it must be rearranged as the lowest
 possible order ie, sorted in an ascending order.

 The replacement must be in-place, do not allocate extra memory.

 Examples:

 1,2,3 → 1,3,2

 3,2,1 → 1,2,3

 1,1,5 → 1,5,1

 20, 50, 113 → 20, 113, 50
 Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 */
public class NextPermutation {
    public void nextPermutation(ArrayList<Integer> a) {
        int len = a.size();
        int last = a.get(len-1);
        int previous = last;
        int i = len-2;
        int val = 0;
        while(i>=0){
            val = a.get(i);
            if(val<previous){
                break;
            } else {
                previous = val;
                i--;
            }
        }
        int j=len-1;
        int base = 0;
        if(i>=0){
            base = a.get(i);
            while(j>=0){
                val = a.get(j);
                if(val>base){
                    break;
                } else
                    j--;
            }
            // Swap a(i) and a(j)
            val = a.get(j);
            a.set(i,val);
            a.set(j,base);
        }
        int start = 0;
        int end = len-1;
        if(i>=0){
            start = i+1;
        }
        // Reverse the list starting from start index
        int mid = (start + end)/2;
        // int newlen = (end - start)+1;
        int k=0,t=0;
        for(k=start,t=0;k<=mid;k++,t++){
            val = a.get(k);
            a.set(k,a.get(len-t-1));
            a.set(len-t-1,val);
        }
    }
}
