package com.api.basic;

import java.util.ArrayList;
import java.util.Scanner;

public class CommonElements3Arrays {

    public ArrayList<Integer> getCommonElements(int array1[],int array2[],int array3[]){
        ArrayList<Integer> commonElements = new ArrayList<Integer>();
        int len1,len2,len3;
        len1 = array1.length;
        len2 = array2.length;
        len3 = array3.length;
        int i=0,j=0,k=0;
        // Logical AND Operator is used because the maximum number of common elements will be the size
        // of the smallest array
        // As soon as one array exploration reaches its end, the elements present in other arrays will not
        // be counted as common elements. So stop the loop, when any array reaches its end.
        while(i<len1 && j<len2 && k<len3){
            if(array1[i]==array2[j] && array1[i]==array3[k]){
                commonElements.add(array1[i]);
                i++;
                j++;
                k++;
            } else if(array1[i]<array2[j]){
                i++;
            } else if(array2[j]<array3[k]){
                j++;
            } else k++;
        }
        return commonElements;
    }

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int len1,len2,len3,j,commonElementsCount;
        CommonElements3Arrays myElements = new CommonElements3Arrays();
        for(int i=0;i<testCases;i++){
            len1 = scanner.nextInt();
            len2 = scanner.nextInt();
            len3 = scanner.nextInt();
            int arr1[] = new int[len1];
            int arr2[] = new int[len2];
            int arr3[] = new int[len3];
            for(j=0;j<len1;j++)
                arr1[j] = scanner.nextInt();
            for(j=0;j<len2;j++)
                arr2[j] = scanner.nextInt();
            for(j=0;j<len3;j++)
                arr3[j] = scanner.nextInt();
            ArrayList commonElements = myElements.getCommonElements(arr1,arr2,arr3);
            commonElementsCount = commonElements.size();
            if(commonElementsCount==0) System.out.print("-1");
            for(j=0;j<commonElementsCount;j++){
                System.out.print(commonElements.get(j));
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
