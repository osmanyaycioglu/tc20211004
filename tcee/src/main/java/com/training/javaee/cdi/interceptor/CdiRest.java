package com.training.javaee.cdi.interceptor;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/cdi")
public class CdiRest {

    @Inject
    private MyCaller caller;

    @Path("/greet")
    @GET
    @CheckIntercept
    public String greet(@QueryParam("name") final String name) {
        return this.caller.greetSomeone(name);
    }

}
