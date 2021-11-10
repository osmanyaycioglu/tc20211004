package com.training.javaee.soap;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.training.javaee.models.Person;
import com.training.javaee.person.mappings.PersonMappings;
import com.training.javaee.person.services.PersonProvisionService;

@WebService(targetNamespace = "http://training.turkcell.com")
public class PersonProvisionWS {

    @EJB
    private PersonProvisionService pps;

    public String add(@WebParam(name = "person") final Person person) {
        this.pps.add(PersonMappings.toPersonDto(person));
        return "SUCCESS";
    }

    public String remove(@WebParam(name = "name") final String name) {
        return "SUCCESS";
    }

    @WebMethod(exclude = true)
    public String xyz(final String str) {
        return "SUCCESS";
    }

}
