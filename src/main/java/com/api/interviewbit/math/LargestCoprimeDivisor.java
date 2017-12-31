package com.api.interviewbit.math;

/**
 * You are given two positive numbers A and B. You need to find the maximum valued integer X such that:

 X divides A i.e. A % X = 0
 X and B are co-prime i.e. gcd(X, B) = 1
 For example,

 A = 30
 B = 12
 We return
 X = 5
 */
public class LargestCoprimeDivisor {
    public int cpFact(int A, int B) {
        int maxdivisor = 1;
        int maxval = GreatestCommonDivisor.gcd(A,B);
        int val1 = 0,val2=0,gcd1=0,gcd2=0;
        if(maxval==1){
            if(A>maxdivisor)
                return A;
            else return maxdivisor;
        }
        int limit = (int)(Math.sqrt(A));
        for(int i=2;i<=limit;i++){
            if(A%i==0){
                val1 = A/i;
                val2 = i;
                gcd1 = GreatestCommonDivisor.gcd(val1,B);
                gcd2 = GreatestCommonDivisor.gcd(val2,B);
                if(gcd1==1 && val1>maxdivisor) maxdivisor = val1;
                if(gcd2==1 && val2>maxdivisor) maxdivisor = val2;
            }
        }
        return maxdivisor;
    }
}
