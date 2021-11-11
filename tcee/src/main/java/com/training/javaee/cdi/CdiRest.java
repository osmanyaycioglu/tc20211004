package com.training.javaee.cdi;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/cdi")
@SessionScoped
public class CdiRest implements Serializable {

    @Inject
    private MyHelloObj helloObj;


    @Path("/hello")
    @GET
    public String hello(@QueryParam("name") final String name) {
        return this.helloObj.sayHello(name);
    }


}
