package com.api.interviewbit.arrays;
import java.util.Scanner;

/**
 * Write a program to print all the LEADERS in the array. An element is leader if it
 * is greater than all the elements to its right side. The rightmost element is
 * always a leader.

 Input:
 The first line of input contains an integer T denoting the number of test cases.
 The description of T test cases follows.
 The first line of each test case contains a single integer N denoting the size of array.
 The second line contains N space-separated integers A1, A2, ..., AN denoting the
 elements of the array.

 Output:
 Print all the leaders.

 Constraints:
 1 <= T <= 100
 1 <= N <= 100
 0 <= A[i]<=100

 Example:
 Input:
 2
 6
 16 17 4 3 5 2
 5
 1 2 3 4 0
 Output:
 17 5 2
 4 0
 */

public class LeadersInArray {
    public static void main (String[] args)
    {
        //code
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        for(int m=0;m<cases;m++){
            int num = scanner.nextInt();
            int n = 0;
            int data[] = new int[num];
            for(n=0;n<num;n++)
                data[n] = scanner.nextInt();
            int results[] = getLeaders(data);
            int len = results.length;
            for(n=0;n<len;n++)
                System.out.print(results[n] + " ");
            System.out.println();
        }

    }

    public static int[] getLeaders(int data[]){
        int len = data.length;
        if(len==1) {
            int leaders[] = new int[1];
            leaders[0] = data[0];
            return leaders;
        }
        int index = len-2;
        int count = 1;
        int max = data[len-1];
        for(;index>=0;index--){
            if(data[index]>max){
                max = data[index];
                count++;
                data[len-count] = data[index];
            }
        }
        int leaders[] = new int[count];
        int i=count;
        int j=0;
        for(;i>0;i--,j++){
            leaders[j] = data[len-i];
        }
        return leaders;
    }
}
