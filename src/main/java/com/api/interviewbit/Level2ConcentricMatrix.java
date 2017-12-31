package com.api.interviewbit;
import java.util.ArrayList;
/**
 * Print concentric rectangular pattern in a 2d matrix.
 Let us show you some examples to clarify what we mean.

 Example 1:

 Input: A = 4.
 Output:

 4 4 4 4 4 4 4
 4 3 3 3 3 3 4
 4 3 2 2 2 3 4
 4 3 2 1 2 3 4
 4 3 2 2 2 3 4
 4 3 3 3 3 3 4
 4 4 4 4 4 4 4
 Example 2:

 Input: A = 3.
 Output:

 3 3 3 3 3
 3 2 2 2 3
 3 2 1 2 3
 3 2 2 2 3
 3 3 3 3 3
 The outermost rectangle is formed by A, then the next outermost is formed by A-1 and so on.

 You will be given A as an argument to the function you need to implement, and you need to return a 2D array.
 */
public class Level2ConcentricMatrix {
    public ArrayList<ArrayList<Integer>> prettyPrint(int A) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        int len = (A*2)-1;
        int left=0,top=0,i=0,j=0,k=0;
        int right=len-1;
        int bottom=len-1;
        int value = A;
        for(i=0;i<len;i++){
            ArrayList<Integer> newList = new ArrayList<Integer>();
            for(j=0;j<len;j++)
                newList.add(0);
            results.add(newList);
        }
        while(value>0){
            for(i=left;i<=right;i++)
                results.get(top).set(i,value);
            for(i=top+1;i<=bottom;i++)
                results.get(i).set(right,value);
            for(i=right-1;i>=left;i--)
                results.get(bottom).set(i,value);
            for(i=bottom-1;i>top;i--)
                results.get(i).set(left,value);
            left++;
            right--;
            top++;
            bottom--;
            value--;
        }
        return results;
    }

    public static void main(String args[]){
        Level2ConcentricMatrix myMatrix = new Level2ConcentricMatrix();
        int testData[] = {1,2,3,4,5,6,7,8,9,10};
        int testsCount = testData.length;
        int len = 0,j=0,k=0;
        for(int i=0;i<testsCount;i++) {
            ArrayList<ArrayList<Integer>> concentricMatrix = myMatrix.prettyPrint(testData[i]);
            len = concentricMatrix.size();
            for(j=0;j<len;j++){
                for(k=0;k<len;k++)
                    System.out.print(concentricMatrix.get(i).get(j).intValue() + " ");
                System.out.println();
            }
            System.out.println();
        }
    }
}
