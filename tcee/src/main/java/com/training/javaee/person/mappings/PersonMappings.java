package com.training.javaee.person.mappings;

import java.util.ArrayList;
import java.util.List;

import com.training.javaee.models.Person;
import com.training.javaee.models.PersonDto;

public class PersonMappings {

    public static PersonDto toPersonDto(final Person person) {
        PersonDto personDtoLoc = new PersonDto();
        personDtoLoc.setUsername(person.getUsername());
        personDtoLoc.setName(person.getName());
        personDtoLoc.setSurname(person.getSurname());
        personDtoLoc.setHeight(person.getHeight());
        personDtoLoc.setWeight(person.getWeight());
        return personDtoLoc;
    }

    public static Person toPerson(final PersonDto person) {
        Person personDtoLoc = new Person();
        personDtoLoc.setUsername(person.getUsername());
        personDtoLoc.setName(person.getName());
        personDtoLoc.setSurname(person.getSurname());
        personDtoLoc.setHeight(person.getHeight());
        personDtoLoc.setWeight(person.getWeight());
        return personDtoLoc;
    }

    public static List<Person> toPersons(final List<PersonDto> allParam) {
        List<Person> listLoc = new ArrayList<>();
        for (PersonDto personDtoLoc : allParam) {
            listLoc.add(toPerson(personDtoLoc));
        }
        return listLoc;
    }

}
