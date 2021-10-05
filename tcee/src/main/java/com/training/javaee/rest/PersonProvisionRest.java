package com.training.javaee.rest;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.training.javaee.models.Person;

@Path("/v1/person/provision")
public class PersonProvisionRest {

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String add(@Valid final Person person) {
        //        if (person.getName() == null) {
        //            throw new IllegalArgumentException("name boş olamaz");
        //        }
        return "SUCCESS";
    }

    @Path("/remove")
    @GET
    public String remove(@QueryParam("name") final String name) {
        return "SUCCESS";
    }


}
