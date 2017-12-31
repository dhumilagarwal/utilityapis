package com.api.interviewbit.arrays;
import java.util.ArrayList;
/**
 * Given numRows, generate the first numRows of Pascal’s triangle.

 Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

 Example:

 Given numRows = 5,

 Return

 [
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
 ]
 */
public class PascalTriangle {
    public ArrayList<ArrayList<Integer>> generate(int A) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if(A<1) return results;
        ArrayList<Integer> first = new ArrayList<Integer>();
        first.add(1);
        results.add(first);
        if(A==1) return results;
        for(int i=1;i<A;i++){
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(1);
            for(int j=1;j<i;j++){
                list.add((results.get(i-1).get(j).intValue()) +
                        (results.get(i-1).get(j-1).intValue()));
            }
            list.add(1);
            results.add(list);
        }
        return results;
    }
}
