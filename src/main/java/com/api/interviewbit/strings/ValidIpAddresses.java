package com.api.interviewbit.strings;
import java.util.Collections;
import java.util.ArrayList;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.

 A valid IP address must be in the form of A.B.C.D, where A,B,C and D are numbers from 0-255. The numbers
 cannot be 0 prefixed unless they are 0.

 Example:

 Given “25525511135”,

 return [“255.255.11.135”, “255.255.111.35”]. (Make sure the returned strings are sorted in order)
 */
public class ValidIpAddresses {

    public ArrayList<String> restoreIpAddresses(String A) {
        ArrayList<String> ipAddresses = new ArrayList<String>();
        String dot = new String(".");
        int len = A.length();
        if(len<4) return ipAddresses;
        int first=0;
        int a=0,b=0,c=0,d=0;
        while(a<3){
            String s1 = isValidPart(A,0,a);
            if(s1.length()==0) {
                a++;
                continue;
            }
            b = a+1;
            while(b<a+4 && b<len-2){
                String s2 = isValidPart(A,a+1,b);
                if(s2.length()==0) {
                    b++;
                    continue;

                }
                c = b+1;
                while(c<b+4 && c<len-1){
                    String s3 = isValidPart(A,b+1,c);
                    String s4 = isValidPart(A,c+1,len-1);
                    if(s3.length()==0 || s4.length()==0) {
                        c++;
                        continue;

                    }
                    String answer = s1 + dot + s2 + dot + s3 + dot + s4;
                    ipAddresses.add(answer);
                    c++;
                }
                b++;
            }

            a++;
        }
        Collections.sort(ipAddresses);
        return ipAddresses;
    }

    public String isValidPart(String A,int start,int end){
        String x = A.substring(start,end+1);
        int len = x.length();
        if(len==0 || len>3) return "";
        int val = Integer.parseInt(x);
        if((len>1 && val<10) || (len>2 && val<100)) return "";
        if(val>=0 && val<=255){
            return x;
        }
        return "";
    }

}
