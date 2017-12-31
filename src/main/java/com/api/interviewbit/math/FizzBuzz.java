package com.api.interviewbit.math;
import java.util.ArrayList;
/**
 * Given a positive integer N, print all the integers from 1 to N. But for multiples
 * of 3 print “Fizz” instead of the number and for the multiples of 5 print “Buzz”.
 * Also for number which are multiple of 3 and 5, prints “FizzBuzz”.
 * Example
 * N = 5
 * Return: [1 2 Fizz 4 Buzz]
 * Instead of printing the answer, you have to return it as list of strings.
 */
public class FizzBuzz {

    public ArrayList<String> fizzBuzz(int A) {
        ArrayList<String> words = new ArrayList<String>();
        for(int i=1;i<=A;i++){
            if(i%3==0){
                if(i%5==0)
                    words.add("FizzBuzz");
                else
                    words.add("Fizz");
            } else if(i%5==0){
                words.add("Buzz");
            } else
                words.add(String.valueOf(i));

        }
        return words;
    }
}
