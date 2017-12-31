package com.api.interviewbit.math;
/**
 * Given a column title as appears in an Excel sheet, return its corresponding column number.
 * Example
 * A -> 1

 B -> 2

 C -> 3

 ...

 Z -> 26

 AA -> 27

 AB -> 28
 */
public class ExcelColumnNumber {
    public int titleToNumber(String A) {
        char a = 'A';
        char b = (char)(a-1);
        int base = 26;
        int number = 0,value=0;
        int len = A.length();
        for(int i=0;i<len;i++){
            value = A.charAt(i)-b;
            number = (number*base) + value;
        }
        return number;
    }
}
