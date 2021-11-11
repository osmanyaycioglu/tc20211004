package com.training.javaee.person.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import com.training.javaee.models.PersonDto;
import com.training.javaee.person.data.PersonDao;

@Singleton
@LocalBean
public class PersonQueryService {

    @EJB
    private PersonDao personDataStorage;

    public PersonDto getOne(final String usernameParam) {
        return this.personDataStorage.getOne(usernameParam);
    }

    public List<PersonDto> getAll() {
        return this.personDataStorage.getAll();
    }

    public List<PersonDto> getBySurname(final String surnameParam) {
        return this.personDataStorage.getBySurname(surnameParam);
    }


}
