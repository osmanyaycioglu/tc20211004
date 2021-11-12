package com.training.javaee.cdi.interceptor;

import javax.inject.Inject;

public class MyCaller {

    @Inject
    private MyCallee myCallee;

    @CheckIntercept
    public String greetSomeone(final String name) {
        return this.myCallee.greet(name);
    }
}
