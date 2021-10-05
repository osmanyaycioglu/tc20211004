package com.training.javaee.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.training.javaee.models.Person;

@WebService(targetNamespace = "http://training.turkcell.com")
public class PersonProvisionWS {

    public String add(@WebParam(name = "person") final Person person) {
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
