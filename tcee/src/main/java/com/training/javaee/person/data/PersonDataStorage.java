package com.training.javaee.person.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import com.training.javaee.models.PersonDto;

@Singleton
@LocalBean
public class PersonDataStorage {

    private final Map<String, PersonDto> personMap = new ConcurrentHashMap<>();
    private final AtomicInteger          counter   = new AtomicInteger();
    private int                          cont;

    public synchronized void increaseCont() {
        this.cont++;
    }

    public void add(final PersonDto personParam) {
        this.counter.incrementAndGet();
        this.personMap.put(personParam.getUsername(),
                           personParam);
    }

    public void remove(final String usernameParam) {
        this.personMap.remove(usernameParam);
    }

    public PersonDto getOne(final String usernameParam) {
        return this.personMap.get(usernameParam);
    }

    public List<PersonDto> getAll() {
        return new ArrayList<>(this.personMap.values());
    }

    public List<PersonDto> getBySurname(final String surnameParam) {
        List<PersonDto> personDtosLoc = new ArrayList<PersonDto>();
        Collection<PersonDto> valuesLoc = this.personMap.values();
        for (PersonDto personDtoLoc : valuesLoc) {
            if (surnameParam.equals(personDtoLoc.getSurname())) {
                personDtosLoc.add(personDtoLoc);
            }
        }
        return personDtosLoc;
    }

}
