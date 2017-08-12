package com.api.stringssubsequences;

/*
Given a string, count number of subsequences of the form aibjck, i.e., it consists of i ’a’ characters,
followed by j ’b’ characters, followed by k ’c’ characters where i >= 1, j >=1 and k >= 1.
Two subsequences are considered different if the set of array indexes picked for the 2 subsequences are
different.
Expected Time Complexity : O(n)
 */

/*
    Examples :
    Input  : abbc
Output : 3
Subsequences are abc, abc and abbc

Input  : abcabc
Output : 7
Subsequences are abc, abc, abbc, aabc
abcc, abc and abc
 */

/*
Approach:
http://www.geeksforgeeks.org/number-subsequences-form-ai-bj-ck/
 */
public class AiBjCkFormSubsequencesCount {

    public static void main(String args[]){
        testGetSubsequenceCount();
    }

    public static long getSubsequenceCount(String sequence){
        long aCount = 0;
        long bCount = 0;
        long cCount = 0;
        int len = sequence.length();
        char ch = 'a';
        for(int i=0;i<len;i++){
            ch = sequence.charAt(i);
            if(ch=='a') aCount = (aCount * 2) + 1;
            else if(ch=='b') bCount = (bCount * 2) + aCount;
            else if(ch=='c') cCount = (cCount * 2) + bCount;
        }
        return cCount;
    }

    public static void testGetSubsequenceCount(){
        String testSequences[] = new String[6];
        testSequences[0] = "abbc";
        testSequences[1] = "abcabc";
        testSequences[2] = "abbcaabbcc";
        testSequences[3] = "abbcaabbac";
        testSequences[4] = "aacbacbbc";
        testSequences[5] = "aacbacbbcabacabccbbccbcaaccabacbbcbcabccbcbabbccaaababaccaabbbbbbacacccaaaaabbbbbbcccc";
        for(int i=0;i<testSequences.length;i++){
            System.out.println("TEST CASE - " + i + " : " + testSequences[i] );
            System.out.println(getSubsequenceCount(testSequences[i]));
        }
    }
}

