package com.api.interviewbit.math;

/**
 * Given an integer n, return the number of trailing zeroes in n!.

 Note: Your solution should be in logarithmic time complexity.

 Example :

 n = 5
 n! = 120
 Number of trailing zeros = 1
 So, return 1
 */
public class TrailingZerosInFactorial {
    public int trailingZeroes(int A) {
        long twos = 0L;
        long fives = 0L;
        long val1 = 2L,val2=5L;
        long limit = A;
        long value = val1;
        long div = 0L;
        /*
        while(value<=limit){
         div = limit/value;
         twos+=div;
         value*=val1;
        }
        */
        value = val2;
        while(value<=limit){
            div = limit/value;
            fives+=div;
            value*=val2;
        }

        int answer = 0;
        /*
        if(twos<=fives) answer = (int)twos;
        else answer = (int)fives;
        */
        answer = (int)fives;
        return answer;
    }
}
