package com.api.interviewbit.strings;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word in the string.

 If the last word does not exist, return 0.

 Note: A word is defined as a character sequence consists of non-space characters only.

 Example:

 Given s = "Hello World",

 return 5 as length("World") = 5.

 Please make sure you try to solve this problem without using library functions.
 Make sure you only traverse the string once.
 */
public class LengthOfLastWord {
    public static int lengthOfLastWord(final String A) {
        int len = A.length();
        int start = 0;
        int end = len-1;
        for(int i=len-1;i>=0;i--){
            if(A.charAt(i)==' '){
                end--;
            } else break;
        }
        for(int i=end;i>=0;i--){
            if(A.charAt(i)==' '){
                start = i+1;
                break;
            }
        }
        return (end-start+1);
    }

    public static void main(String args[]){
        final String[] testData = {"fgrf furfu "," "," dff","uufhru","a   ","","  "," aaa kt   tkthi"};
        int expectedResults[] = {5,0,3,6,1,0,0,5};
        int len = expectedResults.length;
        int actualResults[] = new int[len];
        int answer = 0;
        for(int i=0;i<len;i++){
            actualResults[i] = lengthOfLastWord(testData[i]);
            if(actualResults[i]!=expectedResults[i]){
                System.out.println(testData[i] + " " + actualResults[i] + " " + expectedResults[i]);
            }
        }
    }
}
