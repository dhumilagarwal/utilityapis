package com.api.interviewbit.binarysearch;

/**
 * Given a sorted array of integers, find the number of occurrences of a given target value.
 Your algorithm’s runtime complexity must be in the order of O(log n).
 If the target is not found in the array, return 0

 **Example : **
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return 2.
 */
public class CountElementOccurrence {
    public int findCount(final int[] A, int B) {
        int lowest = binarySearch(A,B,true);
        int highest = binarySearch(A,B,false);
        if(lowest<0 || highest<0)
            return 0;
        return ((highest-lowest)+1);
    }

    public int binarySearch(final int[]A,int B,boolean searchFirst){
        int len = A.length;
        int start = 0,result=-1;
        int end = len-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(A[mid]==B){
                result = mid;
                if(searchFirst)
                    end = mid-1;
                else
                    start = mid+1;
            } else if(A[mid]>B){
                end = mid-1;
            } else
                start = mid+1;
        }
        return result;
    }
}
