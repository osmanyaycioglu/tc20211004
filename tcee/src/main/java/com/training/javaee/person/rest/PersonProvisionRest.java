package com.training.javaee.person.rest;

import javax.ejb.EJB;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.training.javaee.models.Person;
import com.training.javaee.person.mappings.PersonMappings;
import com.training.javaee.person.services.PersonProvisionService;

@Path("/v1/person/provision")
public class PersonProvisionRest {

    @EJB
    private PersonProvisionService personProvisionService;

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String add(@Valid final Person person) {
        this.personProvisionService.add(PersonMappings.toPersonDto(person));
        return "SUCCESS";
    }

    @Path("/remove")
    @GET
    public String remove(@QueryParam("name") final String name) {
        this.personProvisionService.remove(name);
        return "SUCCESS";
    }

}
