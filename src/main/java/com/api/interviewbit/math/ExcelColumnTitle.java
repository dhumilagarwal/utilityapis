package com.api.interviewbit.math;
import java.util.ArrayList;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * Example
 * 1 -> A
 2 -> B
 3 -> C
 ...
 26 -> Z
 27 -> AA
 28 -> AB
 */
public class ExcelColumnTitle {
    public String convertToTitle(int A) {
        int remain = 0,div=0,base=26;
        char a = 'A';
        char b = (char)(a-1);
        ArrayList<Character> chars = new ArrayList<Character>();
        StringBuilder answer = new StringBuilder("");
        while(A>0){
            remain = A%26;
            A = A/26;
            if(remain==0) {
                remain=26;
                A--;
            }
            chars.add((char)(b+remain));
        }
        int len = chars.size();
        for(int i=len-1;i>=0;i--)
            answer.append(chars.get(i));
        return (answer.toString());
    }
}
