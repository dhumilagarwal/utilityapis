package com.api.interviewbit.arrays;
import java.util.ArrayList;
/**
 * Find out the maximum sub-array of non negative numbers from an array.
 The sub-array should be continuous. That is, a sub-array created by choosing the second and fourth
 element and skipping the third element is invalid.

 Maximum sub-array is defined in terms of the sum of the elements in the sub-array. Sub-array A is
 greater than sub-array B if sum(A) > sum(B).

 Example:

 A : [1, 2, 5, -7, 2, 3]
 The two sub-arrays are [1, 2, 5] [2, 3].
 The answer is [1, 2, 5] as its sum is larger than [2, 3]
 NOTE: If there is a tie, then compare with segment's length and return segment which has maximum length
 NOTE 2: If there is still a tie, then return the segment with minimum starting index
 */
public class MaxNonNegativeSubarray {
    public ArrayList<Integer> maxset(ArrayList<Integer> A) {
        ArrayList<Integer> sums = new ArrayList<Integer>();
        int size = A.size();
        int maxstart=0,maxlen=-1,val=0,start=0,len=-1,maxend=0;
        long maxsum=-1L,sum=0L;
        int j=0,k=0;
        boolean isValid=false;
        for(j=0;j<size;j++){
            val = A.get(j).intValue();
            if(val<0 && isValid){
                if((sum>maxsum) || (sum==maxsum && (maxlen < len)) ){
                    maxsum = sum;
                    maxstart = start;
                    maxlen = len;
                }
                isValid = false;
            } else if(val>=0){
                if(isValid)
                    sum = sum + ((long)val);
                else
                {sum = (long)val;start=j;isValid=true;}
                len = (j-start)+1;
            }
        }
        if((sum>maxsum) || (sum==maxsum && (maxlen < len)) ){
            maxsum = sum;
            maxstart = start;
            maxlen = len;
        }
        if(maxsum<0L || maxlen<=0) return sums;
        maxend = maxlen+maxstart;
        for(j=maxstart;j<maxend;j++){
            sums.add(A.get(j));
        }
        return sums;
    }
}
