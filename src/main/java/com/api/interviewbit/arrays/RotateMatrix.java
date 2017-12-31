package com.api.interviewbit.arrays;
import java.util.ArrayList;
/**
 * You are given an n x n 2D matrix representing an image.

 Rotate the image by 90 degrees (clockwise).

 You need to do this in place.

 Note that if you end up using an additional array, you will only receive partial score.

 Example:

 If the array is

 [
 [1, 2],
 [3, 4]
 ]
 Then the rotated array becomes:

 [
 [3, 1],
 [4, 2]
 ]
 */
public class RotateMatrix {
    public void spiralRotate(ArrayList<ArrayList<Integer>> a) {
        int len = a.size();
        int temp = 0,left=0,top=0;
        int right=len-1;
        int bottom=len-1;
        int i=0,j=0,value1=0,value2=0,backup=0;
        while(len>1){
            backup = a.get(top).get(left);
            for(i=left;i<right;i++){
                value1 = a.get(top).get(i+1);
                a.get(top).set(i+1,backup);
                backup = value1;
            }
            for(i=top+1;i<=bottom;i++){
                value1 = a.get(i).get(right);
                a.get(i).set(right,backup);
                backup = value1;
            }
            for(i=right-1;i>=left;i--){
                value1 = a.get(bottom).get(i);
                a.get(bottom).set(i,backup);
                backup = value1;
            }
            for(i=bottom-1;i>=top;i--){
                value1 = a.get(i).get(left);
                a.get(i).set(left,backup);
                backup = value1;
            }
            bottom = bottom - 1;
            right = right - 1;
            top = top + 1;
            left = left + 1;
            len = len-2;
        }


    }

    public void rotate(ArrayList<ArrayList<Integer>> a) {
        // Step 1 - Swap elements A[i][j] to A[j][i]
        int len = a.size();
        int i=0,j=0,val1=0,val2=0;
        for(i=0;i<len;i++){
            for(j=i;j<len;j++){
                val1 = a.get(i).get(j);
                val2 = a.get(j).get(i);
                a.get(i).set(j,val2);
                a.get(j).set(i,val1);
            }
        }

        // Reverse each row in this updated matrix
        int mid = len/2;
        for(i=0;i<len;i++){
            for(j=0;j<mid;j++){
                val1 = a.get(i).get(j);
                val2 = a.get(i).get(len-j-1);
                a.get(i).set(j,val2);
                a.get(i).set(len-j-1,val1);
            }
        }
    }
}

