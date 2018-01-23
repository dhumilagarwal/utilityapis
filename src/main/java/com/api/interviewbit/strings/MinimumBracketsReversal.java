package com.api.interviewbit.strings;
import java.util.Stack;
/**
 * https://www.geeksforgeeks.org/minimum-number-of-bracket-reversals-needed-to-make-an-expression-balanced/
 Given an expression with only ‘}’ and ‘{‘. The expression may not be balanced.
 Find minimum number of bracket reversals to make the expression balanced.
 Input:  exp = "}{"
 Output: 2
 We need to change '}' to '{' and '{' to
 '}' so that the expression becomes balanced,
 the balanced expression is '{}'

 Input:  exp = "{{{"
 Output: Can't be made balanced using reversals

 Input:  exp = "{{{{"
 Output: 2

 Input:  exp = "{{{{}}"
 Output: 1

 Input:  exp = "}{{}}{{{"
 Output: 3





 */
public class MinimumBracketsReversal {

public static int minimumReversals(String brackets){
    int len = brackets.length();
    if(len%2==1) return -1;
    char start = '{';
    char end = '}';
    Stack<Integer> bracketValue = new Stack<Integer>();
    for(int i=0;i<len;i++){
        char ch = brackets.charAt(i);
        if(ch==start)
            bracketValue.push(0);
        else {
            if(bracketValue.empty()){
                bracketValue.push(1);
            } else {
                int val = bracketValue.pop();
                if(val==1){
                    bracketValue.push(1);
                    bracketValue.push(1);
                }
            }
        }
    }
    int val=0;
    int startCount=0,endCount=0;
    while (!bracketValue.empty()){
        val = bracketValue.pop();
        if(val==0) startCount++;
        else endCount++;
    }
    return -1;

}

}
