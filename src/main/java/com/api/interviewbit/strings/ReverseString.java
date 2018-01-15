package com.api.interviewbit.strings;

/**
 * Given an input string, reverse the string word by word.

 Example:

 Given s = "the sky is blue",

 return "blue is sky the".

 A sequence of non-space characters constitutes a word.
 Your reversed string should not contain leading or trailing spaces, even if
 it is present in the input string.
 If there are multiple spaces between words, reduce them to a single space
 in the reversed string.
 */
public class ReverseString {
    public static String reverseWords(String a) {
        StringBuilder builder = new StringBuilder();

        /**
         * Algorithm main part
         * Regular Expression " +"
         *  - considers one or more spaces as one unit.
         *  - splits on the basis of this whole unit
         */
        String parts[] = a.split(" +");
        int len = parts.length;
        for(int i=len-1;i>=0;i--)
        {
            builder.append(parts[i]);
            builder.append(' ');
        }
        int actual = builder.length();
        if(actual>0)
        builder.deleteCharAt(actual-1);
        return builder.toString();
    }

    public static void main(String args[]){
        String s1 = "      ";
        String answer = reverseWords(s1);
        System.out.println(answer);
        System.out.println(answer.length());
    }
}
