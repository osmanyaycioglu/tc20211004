package com.training.rest.client;

public class Person {

    private String  username;
    private String  name;
    private String  surname;
    private Integer weight;
    private Integer height;

    public Person() {
    }


    public String getName() {
        return this.name;
    }

    public Person setName(final String nameParam) {
        this.name = nameParam;
        return this;
    }

    public String getSurname() {
        return this.surname;
    }

    public Person setSurname(final String surnameParam) {
        this.surname = surnameParam;
        return this;
    }

    public Integer getWeight() {
        return this.weight;
    }

    public Person setWeight(final Integer weightParam) {
        this.weight = weightParam;
        return this;
    }

    public Integer getHeight() {
        return this.height;
    }

    public Person setHeight(final Integer heightParam) {
        this.height = heightParam;
        return this;
    }


    public String getUsername() {
        return this.username;
    }


    public void setUsername(final String usernameParam) {
        this.username = usernameParam;
    }


    @Override
    public String toString() {
        return "Person [username="
               + this.username
               + ", name="
               + this.name
               + ", surname="
               + this.surname
               + ", weight="
               + this.weight
               + ", height="
               + this.height
               + "]";
    }


}
