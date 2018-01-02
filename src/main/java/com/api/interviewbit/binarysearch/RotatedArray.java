package com.api.interviewbit.binarysearch;
import java.util.List;
/**
 * Suppose a sorted array A is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 The array will not contain duplicates.

 NOTE 1: Also think about the case when there are duplicates. Does your current
 solution work? How does the time complexity change?*
 PROBLEM APPROACH:

 Note: If you know the number of times the array is rotated, then this problem becomes
 trivial. If the number of rotation is x, then minimum element is A[x].
 Lets look at how we can calculate the number of times the array is rotated.
 */
public class RotatedArray {
    public int findMin(final List<Integer> a) {
        int len = a.size();
        int index = findRotations(a,len);
        if(index==-1) return index;
        else return(a.get(index).intValue());
    }

    public int findRotations(final List<Integer> a,int len){
        int start = 0;
        int end = len-1;
        int mid = 0,value1=0,value2=0,next=0,previous=0,midvalue;
        while(start<=end){
            value1 = a.get(start).intValue();
            value2 = a.get(end).intValue();
            if(value1<=value2) return start;
            mid = (start + end)/2;
            midvalue  = a.get(mid).intValue();
            next = a.get((mid+1)%len).intValue();
            previous = a.get((mid+len-1)%len).intValue();
            if(midvalue<next && midvalue<previous)
                return mid;
            if(midvalue>=value1){
                start = mid + 1;
            } else if(midvalue<=value2){
                end = mid-1;
            }
        }
        return -1;
    }
}
