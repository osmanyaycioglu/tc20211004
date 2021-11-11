package com.training.javaee.cdi;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
public class MyHelloObj implements Serializable {

    private static final long serialVersionUID = 7568548889250807007L;

    @Inject
    @Named("hello-esp")
    private IHello            hello;

    private int               counter;

    public String sayHello(final String name) {
        this.counter++;
        String helloLoc = this.hello.hello(name);
        System.out.println(helloLoc);
        return helloLoc + " counter : " + this.counter;
    }

}
