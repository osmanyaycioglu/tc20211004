package com.training.javaee.ejb;

import java.io.Serializable;

import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;

@Stateful
@LocalBean
public class CalculatorStateful implements Serializable {

    private static final long serialVersionUID = 2391166006173787120L;

    private int               total;

    public CalculatorStateful() {
    }

    public int add(final int val1,
                   final int val2) {
        int result = val1 + val2;
        this.total += result;
        return result;
    }

    public int getTotal() {
        return this.total;
    }

    @Remove
    public void remove() {
        System.out.println("Removed");
    }

    @PrePassivate
    public void beforeSerialize() {
        System.out.println("Before Serialization");
    }

    @PostActivate
    public void afterDeserialize() {
        System.out.println("After Deserialization");
    }

}
