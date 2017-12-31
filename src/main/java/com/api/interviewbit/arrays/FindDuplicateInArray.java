package com.api.interviewbit.arrays;
import java.util.List;
/**
 * Given a read only array of n + 1 integers between 1 and n, find one number that
 * repeats in linear time using less than O(n) space and traversing the stream
 * sequentially O(1) times.

 Sample Input:

 [3 4 1 4 1]
 Sample Output:

 1
 If there are multiple possible answers ( like in the sample case above ), output any one.

 If there is no duplicate, output -1
 */
public class FindDuplicateInArray {
    int repeatedNumber(final int []A, int n1) {

        int a=0;
        int i;
        int b=0;
        for(i=1;i<n1;i++)
            b=b^i;
        for(i=0;i<n1;i++)
            a=a^A[i];
        return (a^b);
    }

    public int repeatedNumber(final List<Integer> a) {
        int len = a.size();
        if(len<=1) return -1;
        int val=0;
        boolean exist[] = new boolean[len];
        for(int i=0;i<len;i++){
            val = a.get(i).intValue();
            if(exist[val])
                return val;
            else exist[val]=true;
        }
        return -1;

    }
}
