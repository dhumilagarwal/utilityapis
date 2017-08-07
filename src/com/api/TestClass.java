package com.api;

/**
 * Created by agarwdhu on 7/30/2017.
 */


/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility  classes
*/
import java.util.*;


public class TestClass {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
*/
        //Scanner
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int Q = s.nextInt();
        int priority[] = new int[Q];
        boolean status[] = new boolean[Q];
        for (int i = 0; i < Q; i++) {
            priority[i] = s.nextInt();
        }
        int tasknum[] = new int[N+1];
        int a=0,b=0;
        for(a=0;a<Q;a++){
            for(b=1;b<=N && b<=priority[a];b++){
                if(tasknum[b]==0 || tasknum[b]<priority[a]){
                    tasknum[b] = priority[a];
                    status[a] = true;
                    b = N+1;
                }
            }
        }

        /*
        System.out.println("YES");
        System.out.println("YES");
        System.out.println("YES");
        System.out.println("NO");
        System.out.println("YES");
        */
        for(a=0;a<Q;a++){
            if(status[a])
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}

