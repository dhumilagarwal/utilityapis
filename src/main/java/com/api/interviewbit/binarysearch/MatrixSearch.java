package com.api.interviewbit.binarysearch;
import java.util.ArrayList;
/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.

 This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than or equal to the last integer of the previous row.
 Example:

 Consider the following matrix:

 [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 Given target = 3, return 1 ( 1 corresponds to true )

 Return 0 / 1 ( 0 if the element is not present, 1 if the element is present ) for this problem
 */
public class MatrixSearch {
    public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
        int value1=0,value2=0,start=0,mid=0,row=0,column=0;
        int m = a.size();
        if(m==0) return 0;
        int n = a.get(0).size();
        if(n==0) return 0;
        int end = (m*n)-1;
        while(start<=end){
            mid = (start + end)/2;
            row = mid/n;
            column = mid%n;
            value1 = a.get(row).get(column);
            if(value1==b) return 1;
            else if(value1>b) end = mid-1;
            else start = mid+1;
        }
        return 0;
    }
}
