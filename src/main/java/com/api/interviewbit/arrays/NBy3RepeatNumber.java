package com.api.interviewbit.arrays;
import java.util.List;
/**
 * You’re given a read only array of n integers. Find out if any integer occurs more
 * than n/3 times in the array in linear time and constant additional space.

 If so, return the integer. If not, return -1.

 If there are multiple solutions, return any one.

 Example :

 Input : [1 2 3 1 1]
 Output : 1
 1 occurs 3 times which is more than 5/3 times.
 */
public class NBy3RepeatNumber {
    public int repeatedNumber(final List<Integer> a) {
        int answer = -1;
        // Create candidates
        // 1st column stores the element, 2nd column stores the count
        int candidates[][] = new int[3][2];
        int len = a.size();
        int val = 0,val2=0,i=0,j=0,k=0,index=-1,emptyindex=-1;
        for(i=0;i<len;i++){
            val = a.get(i);
            index = -1;
            // Check the location where value is present
            if(candidates[0][0]==val) index = 0;
            else if (candidates[1][0]==val) index = 1;
            else if (candidates[2][0]==val) index = 2;
            if(index>=0) candidates[index][1]+=1;
            else {
                // This is executed if value is not present in candidates
                emptyindex=-1;
                if(candidates[0][1]==0) emptyindex = 0;
                else if (candidates[1][1]==0) emptyindex = 1;
                else if (candidates[2][1]==0) emptyindex = 2;
                // We have found which candidate location is empty
                if(emptyindex>=0) {
                    candidates[emptyindex][0] = val;
                    candidates[emptyindex][1] = 1;
                } else {
                    // This is executed when all candidate locations are occupied
                    candidates[0][1]--;
                    candidates[1][1]--;
                    candidates[2][1]--;
                }
            }
        }
        int threshold = len/3;
        for(j=0;j<3;j++){
            val = candidates[j][0];
            val2 = 0;
            for(k=0;k<len;k++){
                if(a.get(k).intValue()==val)
                    val2++;
            }
            if(val2>threshold){
                answer = val;
                return answer;
            }
        }
        return answer;
    }
}
