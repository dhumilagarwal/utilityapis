package com.api.stringssubsequences;

public class DivisibleByNSubsequencesCount {

    public static void main(String args[]){
        testGetDivisibleByNSubsequencesCount();
    }

    public static int getDivisibleByNSubsequencesCount(String input,int divisor){
        int subsequenceCount = 0;
        int inputLen = input.length();
        int counts[][] = new int[inputLen][divisor];
        return subsequenceCount;
    }

    public static void testGetDivisibleByNSubsequencesCount(){
        String testSequences[] = new String[6];
        int divisors[] = new int[6];
        testSequences[0] = "1234";
        divisors[0] = 4;
        testSequences[1] = "330";
        divisors[0] = 6;
        testSequences[2] = "676";
        divisors[0] = 6;
        testSequences[3] = "463174137586459645";
        divisors[0] = 9;
        testSequences[4] = "456456700894";
        divisors[0] = 12;
        testSequences[5] = "4757245942569426592400348340434050034349734";
        divisors[0] = 14;
        for(int i=0;i<testSequences.length;i++){
            System.out.println("TEST CASE - " + i + " : " + testSequences[i] + " : " + divisors[i] );
            System.out.println(getDivisibleByNSubsequencesCount(testSequences[i],divisors[i]));
        }
    }
}


