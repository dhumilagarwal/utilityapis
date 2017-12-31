package com.api.interviewbit.math;
import java.util.ArrayList;
/**
 * Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.

 Example:

 Input : [1, 0]
 Return : [0, 1]
 Lets say N = size of the array. Then, following holds true :
 All elements in the array are in the range [0, N-1]
 N * N does not overflow for a signed integer
 */
public class RearrangeArray {
    public void arrange1(ArrayList<Integer> a) {
        if(a==null) return;
        int len = a.size();
        if(len<=1) return;
        int vals[] = new int[len];
        int current = 0;
        for(int i=0;i<len;i++){
            vals[i] = a.get((a.get(i).intValue()));
        }
        for(int i=0;i<len;i++)
            a.set(i,vals[i]);
    }

    public void arrange(ArrayList<Integer> a){
        if(a==null) return;
        int len = a.size();
        if(len<=1) return;
        int val=0,val1=0,val2=0;
        for(int i=0;i<len;i++){
            val = a.get((a.get(i).intValue()));
            val1 = val % len;
            val2 = a.get(i).intValue();
            val2 = val2 + (val1*len);
            a.set(i,val2);
        }
        for(int i=0;i<len;i++){
            val = a.get(i).intValue();
            val1 = val/len;
            a.set(i,val1);
        }
    }
}
