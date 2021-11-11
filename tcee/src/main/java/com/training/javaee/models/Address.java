package com.training.javaee.models;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@TableGenerator(name = "adress_gen_table",
                table = "id_gen",
                pkColumnName = "gen_type",
                pkColumnValue = "address_id",
                valueColumnName = "gen_value",
                initialValue = 0,
                allocationSize = 10)
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "adress_gen_table")
    @JsonbTransient
    @XmlTransient
    private Long      addressId;
    private String    city;
    private String    street;

    @JsonbTransient
    @XmlTransient
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id", nullable = false)
    private PersonDto personDto;

    public String getCity() {
        return this.city;
    }

    public void setCity(final String cityParam) {
        this.city = cityParam;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(final String streetParam) {
        this.street = streetParam;
    }

    public Long getAddressId() {
        return this.addressId;
    }

    public void setAddressId(final Long addressIdParam) {
        this.addressId = addressIdParam;
    }

    public PersonDto getPersonDto() {
        return this.personDto;
    }

    public void setPersonDto(final PersonDto personDtoParam) {
        this.personDto = personDtoParam;
    }


}
