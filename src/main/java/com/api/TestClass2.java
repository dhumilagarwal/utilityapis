package com.api;
/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility  classes
*/
import java.util.*;


class TestClass2 {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
*/

        Scanner s = new Scanner(System.in);
        int q = s.nextInt();
        int a=0,b=0,c=0;
        HashMap<Integer,Integer> priority = new HashMap<Integer,Integer>();
        int pmin = 200000;
        int pmax = 0;
        int tmax = 0;
        int pt = 0;
       // int priori = 0;
        for (int i = 0; i < q; i++) {
            a = s.nextInt();
            if(a==1) {
                b = s.nextInt();
                c = s.nextInt();
                priority.put(b,c);
                pmax = Collections.max(priority.values()).intValue();
                pmin = Collections.min(priority.values());
                tmax = Collections.max(priority.keySet()).intValue();
                pt = priority.get(tmax).intValue();
            } else if(a==2){
                b = s.nextInt();
               // priori = priority.get(b).intValue();
                priority.remove(b);
                pmax = Collections.max(priority.values()).intValue();
                pmin = Collections.min(priority.values());
                tmax = Collections.max(priority.keySet()).intValue();
                pt = priority.get(tmax).intValue();
            } else if(a==3){
                System.out.println(pmin + " " + pmax);
            }
            else if(a==4){
                System.out.println(pt);
            }
        }



    }
}

