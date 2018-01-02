package com.api.interviewbit.binarysearch;
import java.util.ArrayList;
/**
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.

 Here are few examples.

 [1,3,5,6], 5 → 2
 [1,3,5,6], 2 → 1
 [1,3,5,6], 7 → 4
 [1,3,5,6], 0 → 0
 */
public class SortedInsertPosition {
    public int searchInsert(ArrayList<Integer> a, int b) {
        int len = a.size();
        int mid = 0,val=0;
        if(len==0) return 0;
        int start = 0;
        int end = len-1;
        while(start<=end){
            mid = (start + end)/2;
            val = a.get(mid).intValue();
            if(val==b) return mid;
            else if(val>b){
                if(mid==0) return 0;
                val = a.get(mid-1).intValue();
                if(val<b) return mid;
                else end = mid-1;
            } else {
                if(len-1==mid) return len;
                val = a.get(mid+1).intValue();
                if(val>b) return mid+1;
                else start = mid+1;
            }
        }
        return start;
    }
}
