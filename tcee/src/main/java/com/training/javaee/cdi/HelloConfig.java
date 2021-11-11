package com.training.javaee.cdi;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

public class HelloConfig {

    @Produces
    @Named("hello-esp")
    public IHello createHello() {
        return new HelloDyn("Ola");
    }

}
