package com.api.accolite;

import java.util.ArrayList;
import java.util.Scanner;

public class MaximumJumpCostPrefixStringMatch {

    public static final int PRIME = 101;
    public static final int BASE = 26;
    public static final char START = 'a';
    public static final int MAX_PATTERN_SIZE = 100000;
    public static int[] powers;
    static {
        powers = new int[MAX_PATTERN_SIZE];
        powers[0] = 1;
        for(int y=1;y<MAX_PATTERN_SIZE;y++){
            powers[y] = (powers[y-1] * BASE) % PRIME;
        }
    }
    public ArrayList<Integer> getSubstringMatchIndexes(String text,String pattern){
        System.out.println(text);
        System.out.println(pattern);
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        // Prepare hash value of pattern
        int patternValue = 0;
        int patternLength = pattern.length();
        int textLength = text.length();
        int maxMatches = (textLength - patternLength) + 1;
        int offset = patternLength - 1;
        for(int i=0;i<patternLength;i++){
            patternValue = (patternValue * BASE) + (pattern.charAt(i)-START);
            patternValue = patternValue % PRIME;
        }
        int textValue = 0;
        int k=0;
        for(k=0;k<patternLength;k++){
            textValue = (textValue * BASE) + (text.charAt(k)-START);
            textValue = textValue % PRIME;
        }
        for(k=0;k<maxMatches;k++) {
            // textValue = textValue - ((text.charAt(k-1)-START) * powers[patternLength-1]);
            // textValue = (textValue * BASE) + (text.charAt(k+offset)-START);
            // textValue = textValue % PRIME;
            if (textValue == patternValue) {
                if (text.substring(k, k + patternLength).equals(pattern))
                    indexes.add(k);
            }
            if(k<maxMatches-1) {
                textValue = (BASE * (textValue - ((text.charAt(k) - START) * powers[patternLength - 1])) + text.charAt(k + patternLength)) % PRIME;
                if (textValue < 0) textValue = textValue + PRIME;
            }
        }
        return indexes;
    }

    public int getMaximumJumpCost(ArrayList<Integer> indexes,int []jumpCost,int patternLength){
        int maximumJumpCost = 0;
        int steps = jumpCost.length;
        int costs[] = new int[steps];
        int previousCost = 0;
        int indexesCount = indexes.size();
        int i=0,j=0,myIndex =0,newLoc=0,newCost=0;
        for(i=0;i<steps && j<=indexesCount;i++){
            if(myIndex<indexes.get(j)){
                if(previousCost>costs[i])
                costs[i] = previousCost;
                else previousCost = costs[i];
                myIndex++;
            } else{
                newLoc = myIndex + patternLength;
                if(previousCost>costs[i])
                    costs[i] = previousCost;
                else previousCost = costs[i];
                newCost = costs[i] + jumpCost[i];
                if(newCost>costs[newLoc]) costs[newLoc] = newCost;
                j++;

            }
        }
        maximumJumpCost = costs[i-1];
        for(i=j;i<steps;i++){

        }
        return maximumJumpCost;
    }

    public void getLPS(String pattern,int patternLength,int lps[]){
        int prefixLength = 0;
        int iter = 1;
        lps[0] = 0;
        while (iter < patternLength)
        {
            if (pattern.charAt(iter) == pattern.charAt(prefixLength))
            {
                prefixLength++;
                lps[iter] = prefixLength;
                iter++;
            }
            else
            {
                if(prefixLength != 0)
                    prefixLength = lps[prefixLength-1];
                else
                {
                    lps[iter] = prefixLength;
                    iter++;
                }
            }
        }
    }

    public boolean[] getKMPSearchIndexes(String text,String pattern){
        int patLen = pattern.length();
        int textLen = text.length();
        boolean indexes[] = new boolean[textLen];
        int lps[] = new int[patLen];
        int position = 0;
        getLPS(pattern,patLen,lps);
        int iter = 0;
        while (iter < textLen)
        {
            if (pattern.charAt(position) == text.charAt(iter))
            {
                position++;
                iter++;
            }
            if (position == patLen)
            {
                indexes[iter-position] = true;
                position = lps[position-1];
            }
            else if (iter < textLen && pattern.charAt(position) != text.charAt(iter))
            {
                if (position != 0)
                    position = lps[position-1];
                else
                    iter = iter+1;
            }
        }
        return indexes;
    }

    public int getMaxCost(boolean indexes[],int costs[],int jumpSize){
        int maximumCost = 0;
        int currentCost = 0;
        int costsCount = costs.length;
        int payments[] = new int[costsCount];
        int jumpCost=0,noJumpCost=0;
        for(int i=0;i<costsCount;i++){
            if(payments[i]<currentCost)
                payments[i] = currentCost;
            else currentCost = payments[i];
            if(indexes[i]){
                jumpCost = currentCost + costs[i];
                if((jumpSize + i)<costsCount){
                    payments[jumpSize+i] = Math.max(jumpCost,payments[jumpSize+i]);
                }
            }
        }
        maximumCost = payments[costsCount-1];
        return maximumCost;
    }

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int cases = Integer.parseInt(scanner.nextLine());
        MaximumJumpCostPrefixStringMatch matchCost = new MaximumJumpCostPrefixStringMatch();
        for(int i=0;i<cases;i++){
            String text = scanner.nextLine();
            String pattern = scanner.nextLine();
            int n = Integer.parseInt(scanner.nextLine());
            int jumpCost[] = new int[n];
            String costs = scanner.nextLine();
            String nums[] = costs.split(" ");
            for(int j=0;j<n;j++)
                jumpCost[j] = Integer.parseInt(nums[j]);
            ArrayList<Integer> myMatchIndexes = matchCost.getSubstringMatchIndexes(text,pattern);
            int maximumCost = matchCost.getMaximumJumpCost(myMatchIndexes,jumpCost,pattern.length());
            System.out.println(maximumCost);
        }
    }
}
