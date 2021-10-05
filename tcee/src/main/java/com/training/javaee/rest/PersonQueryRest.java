package com.training.javaee.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import com.training.javaee.models.Person;

@Path("/v1/person/query")
public class PersonQueryRest {

    @Path("/get/one")
    @GET
    public Person getOne(@QueryParam("name") final String name) {
        return new Person();
    }

    @Path("/get/all")
    @GET
    public List<Person> getAll() {
        return new ArrayList<>();
    }

    @Path("/get/by/surname")
    @GET
    public List<Person> getBySurname(@QueryParam("surname") final String surname) {
        return new ArrayList<>();
    }

}
