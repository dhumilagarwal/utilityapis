package com.api.interviewbit.arrays;
import java.util.ArrayList;
/**
 * Give a N*N square matrix, return an array of its anti-diagonals. Look at the example for more details.

 Example:


 Input:

 1 2 3
 4 5 6
 7 8 9

 Return the following :

 [
 [1],
 [2, 4],
 [3, 5, 7],
 [6, 8],
 [9]
 ]


 Input :
 1 2
 3 4

 Return the following  :

 [
 [1],
 [2, 3],
 [4]
 ]

 */
public class AntiDiagonals {
    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        int len = A.size();
        if(A==null || len==0) return results;
        int i=0,j=0,k=0;
        for(i=0;i<len;i++){
            ArrayList<Integer> tempResult = new ArrayList<Integer>();
            for(j=0,k=i;j<=i;j++,k--){
                tempResult.add(A.get(j).get(k));
            }
            results.add(tempResult);
        }
        for(i=1;i<len;i++){
            ArrayList<Integer> tempResult = new ArrayList<Integer>();
            for(j=i,k=len-1;j<len;j++,k--){
                tempResult.add(A.get(j).get(k));
            }
            results.add(tempResult);
        }
        return results;
    }
}
