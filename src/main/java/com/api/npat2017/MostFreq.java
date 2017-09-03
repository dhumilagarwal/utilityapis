package com.api.npat2017;
import java.util.Scanner;
import java.util.Arrays;
public class MostFreq {

    public static void mostFreq3(int a[], int n, int b[]) {

// Write your code here
// hint: sort a, find biggest 3 blocks
        Arrays.sort(a);
        int freq[] = new int[3];

        // Count distinct elements
        int distinct = 1;
        int last = n-1;
        for(int ab=0;ab<last;ab++)
        {
            if(a[ab]!=a[ab+1])
                distinct++;
        }
        distinct++;
        // Declare array of distinct elements
        int frequency[] = new int[distinct];
        int numbers[] = new int[distinct];
        int distinctCount = 0;
        // Count frequency of Each distinct element
        frequency[0] = 1;
        numbers[0] = a[0];
        for(int ab=1;ab<=last;ab++)
        {
            if(a[ab]!=a[ab-1]){
                distinctCount++;
                frequency[distinctCount]++;
                numbers[distinctCount] = a[ab];
            } else {
                frequency[distinctCount]++;
            }
        }

        // find the top 3 elements
        int f1=0,f2=0,f3=0;
        int b1=0,b2=0,b3=0;
        if(frequency[0]>=frequency[1]){
            if(frequency[0]>=frequency[2]){
                f1 = frequency[0];b1 = numbers[0];
                if(frequency[1]>=frequency[2]){
                    f2 = frequency[1];b2 = numbers[1];
                    f3 = frequency[2];b3 = numbers[2];
                } else {
                    f2 = frequency[2];b2 = numbers[2];
                    f3 = frequency[1];b3 = numbers[1];
                }
            } else{
                f1 = frequency[2]; b1 = numbers[2];
                f2 = frequency[0];b2 = numbers[0];
                f3 = frequency[1];b3 = numbers[1];

            }
        } else if(frequency[1]>=frequency[2]) {

            f1 = frequency[1];b1 = numbers[1];
            if(frequency[2]>=frequency[0]){
                f2 = frequency[2];b2 = numbers[2];
                f3 = frequency[0];b3 = numbers[0];
            } else {
                f2 = frequency[0];b2 = numbers[0];
                f3 = frequency[2];b3 = numbers[2];
            }
        } else {
            f1 = frequency[2]; b1 = numbers[2];
            if(frequency[1]>=frequency[0]){
                f2 = frequency[1];b2 = numbers[1];
                f3 = frequency[0];b3 = numbers[0];
            } else {
                f2 = frequency[0];b2 = numbers[0];
                f3 = frequency[1];b3 = numbers[1];
            }
        }

        for(int ab=3;ab<distinct;ab++){
            if(frequency[ab]>=f1) {
                f3 = f2; b3 = b2;
                f2 = f1; b2 = b1;
                f1 = frequency[ab]; b1 = numbers[ab];
            } else if(frequency[ab]>=f2){
                f3 = f2; b3 = b2;
                f2 = frequency[ab]; b2 = numbers[ab];
            } else if(frequency[ab]>=f3){
                f3 = frequency[ab];
                b3 = numbers[ab];
            }

        }

        // Set the values in array b
        b[0] = b1;
        b[1] = b2;
        b[2] = b3;
  /*

  */

    }

    public static void main(String[] args) {
        int n;
        int b[] = new int[3];
        int i=0;

        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        int a[] = new int[n];
        for(i=0;i<n;i++)
            a[i] = scan.nextInt();

        mostFreq3(a,n,b);

        for(i=0;i<3;i++)
            System.out.print(b[i] + " ");
    }
}
