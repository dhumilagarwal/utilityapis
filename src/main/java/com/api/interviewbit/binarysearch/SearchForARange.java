package com.api.interviewbit.binarysearch;
import java.util.List;
import java.util.ArrayList;

/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.

 Your algorithm’s runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 Example:

 Given [5, 7, 7, 8, 8, 10]

 and target value 8,

 return [3, 4].
 */
public class SearchForARange {
    public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        int len = a.size();
        if(len==0){
            indexes.add(-1);
            indexes.add(-1);
            return indexes;
        }
        int start = -1,end=-1;
        start = binarySearch(a,b,true,len);
        indexes.add(start);
        if(start!=-1)
            end = binarySearch(a,b,false,len);
        indexes.add(end);
        return indexes;
    }

    public int binarySearch(final List<Integer> a, int b,boolean isFirst,int len){
        int start = 0;
        int end = len-1;
        int mid=0,result=-1,value=0;
        while(start<=end){
            mid = (start + end)/2;
            value = a.get(mid).intValue();
            if(value==b){
                result = mid;
                if(isFirst)
                    end = mid-1;
                else start = mid+1;
            } else if(value>b){
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return result;

    }
}
