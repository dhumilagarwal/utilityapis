package com.api.interviewbit.arrays;
import java.util.ArrayList;
import java.util.List;
/**
 * You are given a read only array of n integers from 1 to n.

 Each integer appears exactly once except A which appears twice and B which is missing.

 Return A and B.

 Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

 Note that in your output A should precede B.

 Example:

 Input:[3 1 2 5 3]

 Output:[3, 4]

 A = 3, B = 4
 There are certain problems which are asked in the interview to also check how you take care of
 overflows in your problem. This is one of those problems.
 Please take extra care to make sure that you are type-casting your ints to long properly and
 at all places. Try to verify if your solution works if number of elements is as large as 10^5
 Even though it might not be required in this problem, in some cases, you might be required
 to order the operations cleverly so that the numbers do not overflow.
 For example, if you need to calculate n! / k! where n! is factorial(n), one approach is to
 calculate factorial(n), factorial(k) and then divide them.
 Another approach is to only multiple numbers from k + 1 ... n to calculate the result.
 Obviously approach 1 is more susceptible to overflows.
 */
public class RepeatAndMissingNumberArray {
    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        int len = A.size();
        ArrayList<Integer> answers = new ArrayList<Integer>();
        long n = (long)len;
        long sumact=0L,sumexp=0L,squareact=0L,squareexp=0L,val1=0L;
        int val = 0;
        sumexp = (n*(n+1))/2;
        squareexp = (((n * (n+1))/2) * ((n*2)+1))/3;
        for(int i=0;i<len;i++){
            val = A.get(i).intValue();
            val1 = val;
            sumact +=val1;
            squareact = squareact + (val1*val1);
        }
        long xminusy=sumexp - sumact;
        long xsqminusysq = squareexp - squareact;
        long xplusy = xsqminusysq / xminusy;
        long x = (xminusy + xplusy)/2;
        long y = (xplusy - xminusy)/2;
        int x1 = (int)x;
        int y1 = (int)y;
        answers.add(y1);
        answers.add(x1);
        return answers;
    }
}
