package com.training.javaee.cdi;

import javax.inject.Named;

@Named("hello-eng")
public class HelloEng implements IHello {

    @Override
    public String hello(final String nameParam) {
        return "Hello " + nameParam;
    }

}
