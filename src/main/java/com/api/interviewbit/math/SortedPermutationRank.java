package com.api.interviewbit.math;

/**
 * Given a string, find the rank of the string amongst its permutations sorted lexicographically.
 Assume that no characters are repeated.
 Example
 Input : 'acb'
 Output : 2

 The order permutations with letters 'a', 'c', and 'b' :
 abc
 acb
 bac
 bca
 cab
 cba
 The answer might not fit in an integer, so return your answer % 1000003
 */
public class SortedPermutationRank {
    public int findRank(String A) {
        int modulo = 1000003;
        int len = A.length();
        char letters[] = new char[len];
        int fact[] = new int[len+1];
        fact[0] = 1;
        for(int i=0;i<len;i++){
            letters[i] = A.charAt(i);
            fact[i+1] = (fact[i] * (i+1))%modulo;
        }
        int count = 0,rank=0;
        int i=0,j=0,k=0;
        for(i=0;i<len;i++){
            count = 0;
            for(j=i+1;j<len;j++){
                if(letters[j]<letters[i])
                    count++;
            }
            count = count%modulo;
            rank = (((count * fact[len-i-1])%modulo) + rank)%modulo;

        }
        rank++;
        return rank;
    }
}
