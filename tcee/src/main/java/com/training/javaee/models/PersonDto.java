package com.training.javaee.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PersonDto {

    private String  username;
    @NotEmpty(message = "name boş olamaz")
    @Size(min = 2, max = 20, message = "name 2 ile 20 arasında olmalı")
    //@StartWith(value = "is:", message = "name 'is:' ile başlamalı")
    private String  name;
    @NotEmpty(message = "surname boş olamaz")
    @Size(min = 3, max = 30, message = "surname 3 ile 30 arasında olmalı")
    //@StartWith("so:")
    private String  surname;
    @NotNull
    @Min(10)
    @Max(300)
    private Integer weight;
    @NotNull
    @Min(100)
    @Max(250)
    private Integer height;

    public String getUsername() {
        return this.username;
    }

    public void setUsername(final String usernameParam) {
        this.username = usernameParam;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(final String surnameParam) {
        this.surname = surnameParam;
    }

    public Integer getWeight() {
        return this.weight;
    }

    public void setWeight(final Integer weightParam) {
        this.weight = weightParam;
    }

    public Integer getHeight() {
        return this.height;
    }

    public void setHeight(final Integer heightParam) {
        this.height = heightParam;
    }


}
