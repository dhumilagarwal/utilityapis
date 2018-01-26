package com.api.dynamicprogramming;
import java.util.Scanner;
public class MaximumTipCalculator {

    public static void main (String[] args)
    {
        //code
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        for(int i=0;i<cases;i++){
            int n = scanner.nextInt();
            int X = scanner.nextInt();
            int Y = scanner.nextInt();
            int a[] = new int[n];
            int b[] = new int[n];
            for(int j=0;j<n;j++)
                a[j] = scanner.nextInt();
            for(int j=0;j<n;j++)
                b[j] = scanner.nextInt();
            int k=0,x=0,y=0,tips=0;
            while(k<n && x<X && y<Y){
                if(a[k]<b[k]){
                    tips = tips + b[k];
                    y++;
                } else {
                    tips = tips + a[k];
                    x++;
                }
                 k++;
            }
            while (k<n && x<X){
                tips = tips + a[k];
                x++;
                k++;
            }
            while (k<n && y<Y){
                tips = tips + b[k];
                y++;
                k++;
            }
            System.out.println(tips);
        }
    }
}
