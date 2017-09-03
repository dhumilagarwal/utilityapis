package com.api.basic;
import java.util.HashMap;
import java.util.Set;
public class SmallestNumberKTimes {

    public int getSmallestNumberOccuringKTimes(int numbers[],int k){
        if(numbers==null || numbers.length<1) return -1;
        int size = numbers.length;
        if(k>size) return -1;
        HashMap<Integer,Integer> frequency = new HashMap<Integer, Integer>();
        for(int i=0;i<size;i++){
            if(frequency.containsKey(numbers[i])){
                frequency.put(numbers[i],frequency.get(numbers[i])+1);
            } else {
                frequency.put(numbers[i],1);
            }
        }
        Set<Integer> distinctNumbers = frequency.keySet();
        int smallest = Integer.MAX_VALUE;
        int frequencyOfElement = 0;
        for(Integer num : distinctNumbers){
           frequencyOfElement = frequency.get(num);
           if(frequencyOfElement==k && num<smallest)
               smallest = num;
        }
        if(smallest==Integer.MAX_VALUE) return -1;
        else return smallest;
    }
}
