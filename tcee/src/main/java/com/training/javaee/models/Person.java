package com.training.javaee.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import com.training.javaee.custom.validation.StartWith;

@XmlRootElement
public class Person {

    @NotEmpty(message = "name boş olamaz")
    @Size(min = 2, max = 20, message = "name 2 ile 20 arasında olmalı")
    @StartWith(value = "is:", message = "name 'is:' ile başlamalı")
    private String  name;
    @NotEmpty(message = "surname boş olamaz")
    @Size(min = 3, max = 30, message = "surname 3 ile 30 arasında olmalı")
    @StartWith("so:")
    private String  surname;
    @NotNull
    @Min(10)
    @Max(300)
    private Integer weight;
    @NotNull
    @Min(100)
    @Max(250)
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

    @Override
    public String toString() {
        return "Person [name="
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
