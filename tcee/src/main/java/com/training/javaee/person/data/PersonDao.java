package com.training.javaee.person.data;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.training.javaee.models.PersonDto;

@Stateless
@LocalBean
//@TransactionManagement(TransactionManagementType.BEAN)
public class PersonDao {

    @PersistenceContext(unitName = "tcee")
    private EntityManager entityManager;

    //@Transactional
    public void add(final PersonDto dtoParam) {
        dtoParam.getAddress()
                .setPersonDto(dtoParam);
        this.entityManager.persist(dtoParam);
    }

    public void update(final PersonDto dtoParam) {
        PersonDto mergeLoc = this.entityManager.merge(dtoParam);
    }

    public void remove(final Long personId) {
        PersonDto findLoc = this.entityManager.find(PersonDto.class,
                                                    personId);
        if (findLoc != null) {
            this.entityManager.remove(findLoc);
        }
    }

    public PersonDto getOne(final Long personId) {
        return this.entityManager.find(PersonDto.class,
                                       personId);
    }

    public PersonDto getOne(final String username) {
        TypedQuery<PersonDto> createQueryLoc = this.entityManager.createQuery("select p from PersonDto p where p.username=:un",
                                                                              PersonDto.class);
        createQueryLoc.setParameter("un",
                                    username);
        return createQueryLoc.getSingleResult();
    }

    public List<PersonDto> getAll() {
        TypedQuery<PersonDto> createQueryLoc = this.entityManager.createQuery("select p from PersonDto p",
                                                                              PersonDto.class);
        return createQueryLoc.getResultList();
    }

    public List<PersonDto> getBySurname(final String surnameParam) {
        TypedQuery<PersonDto> createQueryLoc = this.entityManager.createQuery("select p from PersonDto p where p.surname=:soyisim",
                                                                              PersonDto.class);
        createQueryLoc.setParameter("soyisim",
                                    surnameParam);
        return createQueryLoc.getResultList();

    }

    public void remove(final String usernameParam) {
        PersonDto oneLoc = this.getOne(usernameParam);
        if (oneLoc != null) {
            this.entityManager.remove(oneLoc);
        }
    }

}
