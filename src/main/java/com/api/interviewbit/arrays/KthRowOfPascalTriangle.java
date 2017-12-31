package com.api.interviewbit.arrays;
import java.util.ArrayList;
/**
 * Given an index k, return the kth row of the Pascal’s triangle.

 Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

 Example:

 Input : k = 3

 Return : [1,3,3,1]
 NOTE : k is 0 based. k = 0, corresponds to the row [1].
 Note:Could you optimize your algorithm to use only O(k) extra space?
 */
public class KthRowOfPascalTriangle {
    public ArrayList<Integer> getRow(int A) {
        ArrayList<Integer> results = new ArrayList<Integer>();
        results.add(1);
        if(A==0) return results;
        if(A==1) {
            results.add(1);
            return results;
        }
        results.add(2);
        results.add(1);
        int next = 1,i=0,j=0,value=0;
        for(i=3;i<=A;i++){
            value = 1;
            for(j=1;j<i;j++){
                results.set(j-1,value);
                value = (results.get(j).intValue()+next);
                next = results.get(j).intValue();
            }
            results.set(j-1,value);
            results.add(1);
        }

        return results;

    }
}
