package com.training.javaee.ejb.rest;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import com.training.javaee.ejb.CalculatorSingleton;
import com.training.javaee.ejb.CalculatorStateful;
import com.training.javaee.ejb.CalculatorStateless;

@Path("/calculator")
//@ApplicationScoped
//@SessionScoped
@RequestScoped
public class CalculatorRest implements Serializable {

    private static final long   serialVersionUID = 7975453761318702693L;

    private int                 webTotal;

    @EJB
    private CalculatorSingleton calculatorSingleton;

    @EJB
    private CalculatorStateless calculatorStateless;

    @EJB
    private CalculatorStateful  calculatorStatefull;

    @Path("/add/singleton")
    @GET
    public String addSingleton(@QueryParam("val1") final Integer val1,
                               @QueryParam("val2") final Integer val2) {
        int addLoc = this.calculatorSingleton.add(val1,
                                                  val2);
        this.webTotal += addLoc;
        return "Result : "
               + addLoc
               + " total : "
               + this.calculatorSingleton.getTotal()
               + " web total : "
               + this.webTotal;
    }

    @Path("/add/stateless")
    @GET
    public String addStateless(@QueryParam("val1") final Integer val1,
                               @QueryParam("val2") final Integer val2) {
        int addLoc = this.calculatorStateless.add(val1,
                                                  val2);
        this.webTotal += addLoc;
        return "Result : "
               + addLoc
               + " total : "
               + this.calculatorStateless.getTotal()
               + " web total : "
               + this.webTotal;
    }

    @Path("/add/statefull")
    @GET
    public String addStatefull(@QueryParam("val1") final Integer val1,
                               @QueryParam("val2") final Integer val2) {
        int addLoc = this.calculatorStatefull.add(val1,
                                                  val2);
        this.webTotal += addLoc;
        return "Result : "
               + addLoc
               + " total : "
               + this.calculatorStatefull.getTotal()
               + " web total : "
               + this.webTotal;
    }

}
