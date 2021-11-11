package com.training.javaee.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
@TableGenerator(name = "phone_gen_table",
                table = "id_gen",
                pkColumnName = "gen_type",
                valueColumnName = "gen_value",
                pkColumnValue = "phone_id",
                initialValue = 0,
                allocationSize = 1)
public class Phone {

    @Id
    @GeneratedValue(generator = "phone_gen_table", strategy = GenerationType.TABLE)
    private Long   personId;

    private String number;
    private String name;

    public String getNumber() {
        return this.number;
    }

    public void setNumber(final String numberParam) {
        this.number = numberParam;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public Long getPersonId() {
        return this.personId;
    }

    public void setPersonId(final Long personIdParam) {
        this.personId = personIdParam;
    }


}
