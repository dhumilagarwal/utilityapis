package com.api.interviewbit.binarysearch;
import java.util.ArrayList;
/**
 * Implement pow(x, n) % d.

 In other words, given x, n and d,

 find (x^n % d)

 Note that remainders on division cannot be negative.
 In other words, make sure the answer you return is non negative.

 Input : x = 2, n = 3, d = 3
 Output : 2

 2^3 % 3 = 8 % 3 = 2.
 */
public class ImplementPowerFunction {
    public int powRecursive(int x, int n, long d) {
        if(x==0) return 0;
        if(n==1) {
            if(x<0)
            {
                d = d + x;
                return ((int)d);
            }
            else return x;
        }
        if(n==0) return 1;
        int half = n/2;
        int left = n%2;
        long first = pow(x,half,d);
        long second = (first*first) % d;
        if(left==1) second = (second*x)%d;
        if(second<0) second+=d;
        return ((int)second);
    }

    /**
     * Defective method
     * @param x
     * @param n
     * @param d
     * @return
     */
    public int pow(int x,int n,long d){
        if(x==0) return 0;
        ArrayList<Integer> powerVals = new ArrayList<Integer>();
        ArrayList<Integer> powerKeys = new ArrayList<Integer>();
        powerVals.add(1);
        int m = n;
        long product = 1L;
        long remain = 0L;
        if(n==1) {
            if(x<0)
            {
                d = d + x;
                return ((int)d);
            }
            else return x;
        }
        if(n==0) return 1;
        long currentVal = x;
        product = currentVal;
        m--;
        while(m>0){
            remain = m%2;
            m = m/2;
            currentVal = (currentVal*currentVal)%d;
            if(remain==1){
                product = (product*currentVal)%d;
            }
        }
        if(product<0) product = product+d;
        return ((int)product);
    }

}
