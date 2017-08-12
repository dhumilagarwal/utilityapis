package com.api;

/**
 * Created by agarwdhu on 7/30/2017.
 */
public class PassS {

    public static void main(String [] args)
    {
        PassS p = new PassS();
        p.start();
    }

    void start()
    {
        String s1 = "step";
        String s2 = fix(s1);
        System.out.println(s1 + " " + s2);
    }

    String fix(String s1)
    {
        s1 = s1 + "steem";
        System.out.print(s1 + " ");
        return "steem";
    }
}