package com.api.interviewbit.math;
import java.util.ArrayList;
public class PrimeSum {

    public ArrayList<Integer> primesum(int A) {
        ArrayList<Integer> results = new ArrayList<Integer>();
        int m = (int)(Math.sqrt(A));
        if(m*m<A) m++;
        boolean isComposite[] = new boolean[A+1];
        for(int i=2;i<=m;i++){
            if(isComposite[i]) continue;
            for(int j=i*2;j<A;j=j+i)
                isComposite[j] = true;
        }
        int left=2;
        int right = A-2;
        while(left<=right){
            if(!isComposite[left] && !isComposite[right]){
                results.add(left);
                results.add(right);
                break;
            }
            left++;
            right--;
        }
        return results;
    }
}
