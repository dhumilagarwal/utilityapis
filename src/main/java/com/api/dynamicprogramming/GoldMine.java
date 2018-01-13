package com.api.dynamicprogramming;
import java.util.Scanner;
/**
 * Given a gold mine (M) of n*m dimensions. Each field in this mine contains a
 * positive integer which is the amount of gold in tons. Initially the miner is
 * at first column but can be at any row. He can move only (right->,right up /,
 * right down\) that is from a given cell, the miner can move to the cell diagonally
 * up towards the right or right or diagonally down towards the right. Your task is
 * to find out maximum amount of gold which he can collect.
 *
 * Examples:

 Input : M[][] = {{1, 3, 3},
 {2, 1, 4},
 {0, 6, 4}};
 Output : 12
 {(1,0)->(2,1)->(2,2)}

 Input: M[][] = {{1, 3, 1, 5},
 {2, 2, 4, 1},
 {5, 0, 2, 3},
 {0, 6, 1, 2}};
 Output : 16
 (2,0) -> (1,1) -> (1,2) -> (0,3) OR
 (2,0) -> (3,1) -> (2,2) -> (2,3)

 Input:
 The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains an integer n and m denoting the size of the matrix. Then in the next line are n*m space separated values of the matrix.

 Output:
 For each test case in a new line print an integer denoting the max gold the miner could collect.

 Constraints:
 1<=T<=100
 1<=n,m<=20
 1<=M[][]<=100

 Example:
 Input:
 2
 3 3
 1 3 3 2 1 4 0 6 4
 2 2
 1 2 3 4
 Output:
 12
 7
 */
public class GoldMine {

    /**
     * Approach - Bottom up approach - Start from the rightmost column
     * For every row of a given column, find the maximum gold that can be collected
     * from this point if the miner reaches this point.
     * Keep moving towards the left
     * @param args
     */
    public static void main (String[] args)
    {
        //code
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        int value = 0,maxvalue=0;
        for(int i=0;i<cases;i++){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int data[][] = new int[n][m];
            int a=0,b=0;
            for(a=0;a<n;a++){
                for(b=0;b<m;b++){
                    data[a][b] = scanner.nextInt();
                }
            }
            for(a=m-2;a>=0;a--){
                for(b=0;b<n;b++){
                    maxvalue = data[b][a];
                    if(b>0){
                        value = data[b][a] + data[b-1][a+1];
                        if(value>maxvalue)
                            maxvalue = value;
                    }
                    value = data[b][a] + data[b][a+1];
                    if(value>maxvalue)
                        maxvalue = value;
                    if(b+1<n){
                        value = data[b][a] + data[b+1][a+1];
                        if(value>maxvalue)
                            maxvalue = value;
                    }
                    data[b][a] = maxvalue;
                }
            }
            maxvalue = data[0][0];
            for(a=1;a<n;a++){
                if(data[a][0]>maxvalue)
                    maxvalue = data[a][0];
            }
            System.out.println(maxvalue);

        }
    }
}
