package com.api.interviewbit.math;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.

 A palindrome integer is an integer x for which reverse(x) = x where reverse(x) is x with its digit reversed.
 Negative numbers are not palindromic.
 Example :
 Input : 12121
 Output : True

 Input : 123
 Output : False
 */
public class PalindromeInteger {
    public int isPalindrome(int A) {
        if(A<0) return 0;
        if(A==0) return 1;
        long straight = A;
        long value = straight;
        long remain = 0L,reverse=0L;
        while(value>0){
            remain = value%10;
            reverse = (reverse * 10) + remain;
            value = value/10;
        }
        if(reverse==straight)
            return 1;
        else
            return 0;

    }
}
