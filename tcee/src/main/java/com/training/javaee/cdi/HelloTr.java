package com.training.javaee.cdi;

import javax.inject.Named;

@Named("hello-tr")
public class HelloTr implements IHello {

    @Override
    public String hello(final String nameParam) {
        return "Merhaba " + nameParam;
    }

}
