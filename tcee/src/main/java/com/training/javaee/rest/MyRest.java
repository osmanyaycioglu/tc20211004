package com.training.javaee.rest;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


@RequestScoped
@Path("/first")
@Produces("text/plain")
public class MyRest {

    @Path("/hello")
    @GET
    public String hello() {
        return "Hello from rest";
    }

    @Path("/hello")
    @POST
    public String helloPost() {
        return "Hello POST from rest";
    }

    @Path("/hello")
    @PUT
    public String helloPut() {
        return "Hello PUT from rest";
    }

    @Path("/hello")
    @PATCH
    public String helloPatch() {
        return "Hello PATCH from rest";
    }

    @Path("/hello")
    @DELETE
    public String helloDelete() {
        return "Hello DELETE from rest";
    }

}
