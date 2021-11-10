package com.training.javaee.ejb;

import java.io.Serializable;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class CalculatorStateless implements Serializable {

    private static final long serialVersionUID = 2391166006173787120L;

    private int               total;

    public CalculatorStateless() {
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

}
