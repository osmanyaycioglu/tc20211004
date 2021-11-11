package com.training.javaee.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "person")
@TableGenerator(name = "person_gen_table",
                table = "id_gen",
                pkColumnName = "gen_type",
                valueColumnName = "gen_value",
                pkColumnValue = "person_id",
                initialValue = 0,
                allocationSize = 1)
public class PersonDto {

    @Id
    @GeneratedValue(generator = "person_gen_table", strategy = GenerationType.TABLE)
    private Long       personId;

    @Column(nullable = false, unique = true)
    @Size(min = 5, max = 20, message = "username {min} ile {max} arasında olmalı")
    private String     username;
    @NotEmpty(message = "name boş olamaz")
    @Size(min = 2, max = 20, message = "name 2 ile 20 arasında olmalı")
    //@StartWith(value = "is:", message = "name 'is:' ile başlamalı")
    private String     name;
    @NotEmpty(message = "surname boş olamaz")
    @Size(min = 3, max = 30, message = "surname 3 ile 30 arasında olmalı")
    //@StartWith("so:")
    private String     surname;
    @NotNull
    @Min(10)
    @Max(300)
    private Integer    weight;
    @NotNull
    @Min(100)
    @Max(250)
    private Integer    height;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "personDto")
    @NotNull
    private Address    address;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Phone> phones;

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

    public Long getPersonId() {
        return this.personId;
    }

    public void setPersonId(final Long personIdParam) {
        this.personId = personIdParam;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(final Address addressParam) {
        this.address = addressParam;
    }

    public Set<Phone> getPhones() {
        return this.phones;
    }

    public void setPhones(final Set<Phone> phonesParam) {
        this.phones = phonesParam;
    }


}
