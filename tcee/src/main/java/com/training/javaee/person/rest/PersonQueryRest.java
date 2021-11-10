package com.training.javaee.person.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.training.javaee.models.Person;
import com.training.javaee.person.mappings.PersonMappings;
import com.training.javaee.person.services.PersonQueryService;

@Path("/v1/person/query")
public class PersonQueryRest {

    @EJB
    private PersonQueryService personQueryService;

    @Path("/get/one")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Person getOne(@QueryParam("username") final String username) {
        return PersonMappings.toPerson(this.personQueryService.getOne(username));
    }

    @Path("/get/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAll() {
        return PersonMappings.toPersons(this.personQueryService.getAll());
    }

    @Path("/get/by/surname")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getBySurname(@QueryParam("surname") final String surname) {
        return PersonMappings.toPersons(this.personQueryService.getBySurname(surname));
    }

}
