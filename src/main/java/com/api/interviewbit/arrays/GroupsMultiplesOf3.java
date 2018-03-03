package com.api.interviewbit.arrays;
import java.util.Scanner;

/**
 * Given an unsorted integer (positive values only) array of size ‘n’, we can form a
 * group of two or three only, the group should be such that the sum of all elements
 * in that group is a multiple of 3. Count all possible number of groups that can be
 * generated in this way.

 Input: arr[] = {3, 6, 7, 2, 9}
 Output: 8
 Groups are {3,6}, {3,9}, {9,6},
 {7,2}, {3, 6,9},
 {3, 7, 2}, {7, 2, 6},
 {7, 2, 9}
 Input:

 The first line of input contains an integer T denoting the number of test cases.
 The first line of each test case is N, where N is the size of array.
 The second line of each test case contains N elements of input array.

 Output:

 Print number of all possible group.

 Constraints:

 1 ≤ T ≤ 50
 1 ≤ N ≤ 80
 1 ≤ arr[i] ≤ 100

 Example:

 Input
 2
 5
 3 6 7 2 9
 4
 2 1 3 4

 Output
 8
 4
 */
public class GroupsMultiplesOf3 {
    public static void main (String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();

        /**
         * Solution Formula
         * a = count of numbers where, number modulo 3 = 0
         * b = count of numbers where, number modulo 3 = 1
         * c = count of numbers where, number modulo 3 = 2
         * Add the following
         * (0,0,0) -> (aC3) = (a*(a-1)*(a-2))/6
         * (1,1,1) -> (bC3) = (b*(b-1)*(b-2))/6
         * (2,2,2) -> (cC3) = (c*(c-1)*(c-2))/6
         * (0,1,2) -> a*b*c
         *  (0,0) -> (aC2) = (a*(a-1))/2
         *  (1,2) -> b*c
         */

        int i=0,j=0,val=0,n=0,answer=0;
        int count[] = new int[3];
        for(i=0;i<cases;i++){
            n = scanner.nextInt();
            count[0] = 0;count[1]=0;count[2]=0;
            for(j=0;j<n;j++){
                val = scanner.nextInt();
                count[val%3]++;
            }
            answer = 0;

            answer = answer + (count[2] * (count[2]-1) * (count[2]-2) );
            answer = answer + (count[1] * (count[1]-1) * (count[1]-2) );
            answer = answer + (count[0] * (count[0]-1) * (count[0]-2) );
            answer = answer / 6;
            answer = answer + ((count[0]*(count[0]-1))/2);
            answer = answer + (count[2] * count[1] * (count[0]+1) );
            System.out.println(answer);
        }
    }
}
