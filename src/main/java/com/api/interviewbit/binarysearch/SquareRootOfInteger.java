package com.api.interviewbit.binarysearch;

/**
 * Implement int sqrt(int x).

 Compute and return the square root of x.

 If x is not a perfect square, return floor(sqrt(x))

 Example :

 Input : 11
 Output : 3
 */
public class SquareRootOfInteger {

    public int sqrt(int a) {
        if(a<0) return -1;
        if(a==0) return 0;
        if(a<4) return 1;
        int start = 1;
        int end = a;
        int mid = 0;
        int square=0,div=0,next=0;
        int root = start;
        while(start<=end){
            mid = (start + end)/2;
            div = a/mid;
            if(mid==div){
                return mid;
            } else if(mid>div){
                end = mid-1;
            } else {
                next = mid+1;
                div = a/next;
                if(div<next) return mid;
                else start = mid+1;
            }
        }
        return root;
    }
}
