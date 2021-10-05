package com.training.javaee.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/second/function")
@Produces("text/plain")
public class MySecondRest {

    @Path("/greet/name/{abc}/surname/{xyz}")
    @GET
    public String greet(@PathParam("abc") final String name,
                        @PathParam("xyz") final String surname) {
        return "Greetings " + name + " " + surname;
    }

    @Path("/greet2")
    @GET
    public String greet2(@QueryParam("abc") final String name,
                         @QueryParam("xyz") final String surname) {
        return "Greetings 2 " + name + " " + surname;
    }

}
