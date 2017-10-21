package com.api;

public class EmptyTreeException extends Exception {

    @Override
    public void printStackTrace(){
        System.err.println("Exception : Empty tree encountered");
    }
}
