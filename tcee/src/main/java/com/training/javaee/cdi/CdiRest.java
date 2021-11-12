package com.training.javaee.cdi;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/cdi")
@RequestScoped
public class CdiRest implements Serializable {

    @Inject
    private MyHelloObj helloObj;

    @Inject
    @Alternative
    private IHello     hello;


    @Path("/hello")
    @GET
    public String hello(@QueryParam("name") final String name) {
        return this.helloObj.sayHello(name);
    }

    @Path("/hello2")
    @GET
    public String hello2(@QueryParam("name") final String name) {
        return this.hello.hello(name);
    }

}
