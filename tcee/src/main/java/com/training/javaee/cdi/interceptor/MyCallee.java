package com.training.javaee.cdi.interceptor;


public class MyCallee {

    @CheckIntercept
    public String greet(final String name) {
        return "Hello " + name;
    }

}
