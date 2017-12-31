package com.api.interviewbit.math;
import java.util.List;

/**
 * Hamming distance between two non-negative integers is defined as the number of positions
 * at which the corresponding bits are different.

 For example,

 HammingDistance(2, 7) = 2, as only the first and the third bit differs in the binary
 representation of 2 (010) and 7 (111).

 Given an array of N non-negative integers, find the sum of hamming distances of all
 pairs of integers in the array.
 Return the answer modulo 1000000007.

 Example
 Let f(x, y) be the hamming distance defined above.

 A=[2, 4, 6]

 We return,
 f(2, 2) + f(2, 4) + f(2, 6) +
 f(4, 2) + f(4, 4) + f(4, 6) +
 f(6, 2) + f(6, 4) + f(6, 6) =

 0 + 2 + 1
 2 + 0 + 1
 1 + 1 + 0 = 8
 */
public class HammingDistance {

    // Slow method
    public int hammingDistance1(final List<Integer> A) {
        int distance = 0;
        int len = A.size();
        int modulo = 1000000007;
        int i=0,j=0,val=0,val1=0,val2=0,count=0;
        int max = len-1;
        for(i=0;i<max;i++){
            for(j=i+1;j<=max;j++){
                val = A.get(i).intValue();
                val1 = A.get(j).intValue();
                val2 = val^val1;
                count=0;
                while(val2>0){
                    val2 = val2 & (val2-1);
                    count++;
                }
                distance = (distance + count)%modulo;
            }
        }
        distance = (distance * 2)%modulo;
        return distance;
    }

    // Super fast method
    public int hammingDistance(final List<Integer> A) {
        long distance = 0L;
        int len = A.size();
        long modulo = 1000000007L;
        int i=0,j=0,val=0;
        long val1=0L,val2=0L;
        long count=0L;
        int max = len-1;
        for(i=0;i<32;i++){
            count = 0L;
            for(j=0;j<len;j++){
                if(((A.get(j).intValue()) & (1<<i))>0)
                    count++;
            }
            val1 = (((count * (len-count))%modulo)*2)%modulo;
            distance = (distance + val1 )%modulo;
        }
        int answer = (int)distance;
        return answer;
    }
}
