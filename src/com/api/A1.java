package com.api;

/**
 * Created by agarwdhu on 7/30/2017.
 */

abstract class A1 {
    protected int i;
    abstract void display();
}
class B1 extends A1 {
    int j=30;
    void display() {
        int j=10;
        System.out.println(j);
    }
}
class Abstract_demo {
    public static void main(String args[])
    {
        B1 obj = new B1();
        obj.j=20;
        obj.display();
    }
}