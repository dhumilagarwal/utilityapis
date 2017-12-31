package com.api.interviewbit.arrays;
import java.util.ArrayList;
/**
 * Given an m x n matrix of 0s and 1s, if an element is 0, set its entire row and column to 0.

 Do it in place.

 Example

 Given array A as

 1 0 1
 1 1 1
 1 1 1
 On returning, the array A should be :

 0 0 0
 1 0 1
 1 0 1
 Note that this will be evaluated on the extra memory used. Try to minimize the space and time complexity.
 */
public class SetMatrixZeros {
    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        int m = a.size();
        if(m<=0) return;
        int n = a.get(0).size();
        if(n<=0) return;
        int val=0;
        boolean rows[] = new boolean[m];
        boolean cols[] = new boolean[n];
        int i=0,j=0;
        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                val = a.get(i).get(j).intValue();
                if(val==0){
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }
        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                if(rows[i] || cols[j]){
                    a.get(i).set(j,0);
                } else {
                    a.get(i).set(j,1);
                }


            }
        }
    }
}
