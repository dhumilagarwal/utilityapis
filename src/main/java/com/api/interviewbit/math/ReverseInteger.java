package com.api.interviewbit.math;

/**
 * Reverse digits of an integer.

 Example1:

 x = 123,

 return 321
 Example2:

 x = -123,

 return -321

 Return 0 if the result overflows and does not fit in a 32 bit signed integer
 */
public class ReverseInteger {
    public int reverse(int A) {
        long maxval =  2147483647L;
        long minval = -2147483648L;
        if(A==0) return A;
        long Aval = A;
        int answer = 0;
        long num = 0L,div=0L,remain=0L;
        if(A<0){
            Aval = Aval * (-1L);
        }
        while(Aval>0L){
            remain = Aval%10;
            num = (num*10) + remain;
            Aval = Aval/10;
        }
        if(A<0) num = num * (-1L);
        if(num>maxval || num<minval){
            return 0;
        }
        answer = (int)num;
        return answer;
    }
}
