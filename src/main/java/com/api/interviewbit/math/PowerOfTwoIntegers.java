package com.api.interviewbit.math;

/**
 * Given a positive integer which fits in a 32 bit signed integer, find if it can be
 * expressed as A^P where P > 1 and A > 0. A and P both should be integers.
 * Example
 * Input : 4
 * Output : True
 * as 2^2 = 4.
 */
public class PowerOfTwoIntegers {

    public int isPower(int A) {
        int limit = (int)(Math.sqrt(A));
        if(A==1) return 1;
        int count=0;
        int b = A;
        for(int i=2;i<=limit;i++){
            count = 0;
            b = A;
            while(b>0){
                if(b%i==0){
                    count++;
                    b = b/i;
                } else break;
            }
            if(b==1 && count>=2)
                return 1;
        }
        return 0;
    }
}
