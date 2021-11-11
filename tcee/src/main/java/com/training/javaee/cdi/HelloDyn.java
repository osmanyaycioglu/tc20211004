package com.training.javaee.cdi;

import java.io.Serializable;

public class HelloDyn implements IHello, Serializable {

    private final String prefix;

    public HelloDyn(final String prefixParam) {
        super();
        this.prefix = prefixParam;
    }

    @Override
    public String hello(final String nameParam) {
        return this.prefix + " " + nameParam;
    }

}
