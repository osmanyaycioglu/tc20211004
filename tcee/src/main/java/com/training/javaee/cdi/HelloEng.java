package com.training.javaee.cdi;

import javax.enterprise.inject.Alternative;
import javax.inject.Named;

@Named("hello-eng")
@Alternative
public class HelloEng implements IHello {

    @Override
    public String hello(final String nameParam) {
        return "Hello " + nameParam;
    }

}
