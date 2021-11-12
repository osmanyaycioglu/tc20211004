package com.training.javaee.cdi;

import javax.enterprise.inject.Alternative;
import javax.inject.Named;

@Named("hello-tr")
@Alternative
public class HelloTr implements IHello {

    @Override
    public String hello(final String nameParam) {
        return "Merhaba " + nameParam;
    }

}
