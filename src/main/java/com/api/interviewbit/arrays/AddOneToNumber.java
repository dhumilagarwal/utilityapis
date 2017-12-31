package com.api.interviewbit.arrays;
import java.util.ArrayList;
/**
 * Given a non-negative number represented as an array of digits,

 add 1 to the number ( increment the number represented by the digits ).

 The digits are stored such that the most significant digit is at the head of the list.

 Example:

 If the vector has [1, 2, 3]

 the returned vector should be [1, 2, 4]

 as 123 + 1 = 124.

 NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer.
 For example, for this problem, following are some good questions to ask :
 Q : Can the input have 0’s before the most significant digit. Or in other words, is 0 1 2 3 a valid input?
 A : For the purpose of this question, YES
 Q : Can the output have 0’s before the most significant digit? Or in other words, is 0 1 2 4 a valid output?
 A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.
 */
public class AddOneToNumber {
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        ArrayList<Integer> sum = new ArrayList<Integer>();
        int len = A.size();
        int carry=1,val=0,val1=0;
        // Create the reverse sum
        for(int i=len-1;i>=0;i--){
            val = A.get(i).intValue();
            val = val + carry;
            if(val>=10){
                val = val-10;
                carry = 1;
            } else carry=0;
            sum.add(val);

        }
        if(carry>0) sum.add(carry);
        // reverse the sum
        int sumlen = sum.size();
        val1=sumlen-1;
        // Delete useless elements (trailing zeros)
        while(val1>0){
            val1 = sum.size(); val1--;
            val = sum.get(val1).intValue();
            if(val==0) {
                sum.remove(val1);
                val1--;
            } else break;
        }
        sumlen = sum.size();
        int mid = sumlen/2;
        for(int j=0;j<mid;j++){
            val = sum.get(j).intValue();
            val1 = sum.get(sumlen-j-1).intValue();
            sum.set(j,val1);
            sum.set(sumlen-j-1,val);
        }

        return sum;
    }
}
