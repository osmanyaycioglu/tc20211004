package com.training.javaee.person.services;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.validation.Valid;

import com.training.javaee.models.PersonDto;
import com.training.javaee.person.data.PersonDao;

@Singleton
@LocalBean
public class PersonProvisionService {

    @EJB
    private PersonDao pds;

    public void add(@Valid final PersonDto personParam) {
        this.pds.add(personParam);
    }

    public void remove(final String usernameParam) {
        this.pds.remove(usernameParam);
    }


}
