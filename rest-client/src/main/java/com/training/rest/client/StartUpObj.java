package com.training.rest.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StartUpObj implements CommandLineRunner {

    @Autowired
    private IPersonclient      pc;

    @Autowired
    private IPersonQueryClient pqc;

    @Override
    public void run(final String... argsParam) throws Exception {
        Person personLoc = new Person();
        personLoc.setUsername("osmany");
        personLoc.setName("osman");
        personLoc.setSurname("yaycioglu");
        personLoc.setHeight(500);
        personLoc.setWeight(500);
        try {
            String result = this.pc.add(personLoc);
        } catch (RestClientExp eLoc) {
            ErrorObj errorObjLoc = eLoc.getErrorObj();
            System.out.println("Error while calling rest : " + errorObjLoc);
        } catch (Exception eLoc) {
            eLoc.printStackTrace();
        }

        for (int iLoc = 100; iLoc < 120; iLoc++) {
            personLoc = new Person();
            personLoc.setUsername("osmany" + iLoc);
            personLoc.setName("osman" + iLoc);
            personLoc.setSurname("yaycioglu" + iLoc);
            personLoc.setHeight(50 + iLoc);
            personLoc.setWeight(50 + iLoc);
            String result = this.pc.add(personLoc);
            System.out.println("Result : " + result);
        }
        Person oneLoc = this.pqc.getOne("osmany100");
        System.out.println("One Result : " + oneLoc);

        List<Person> allLoc = this.pqc.getAll();
        for (Person personXLoc : allLoc) {
            System.out.println("Get ALL Result : " + personXLoc);
        }

    }

    public void run2(final String... argsParam) throws Exception {
        RestTemplate restTemplateLoc = new RestTemplate();
        for (int iLoc = 0; iLoc < 10; iLoc++) {
            Person personLoc = new Person();
            personLoc.setUsername("osmany" + iLoc);
            personLoc.setName("osman" + iLoc);
            personLoc.setSurname("yaycioglu" + iLoc);
            personLoc.setHeight(200 + iLoc);
            personLoc.setWeight(100 + iLoc);
            String result = restTemplateLoc.postForObject("http://127.0.0.1:8080/tcee/api/v1/person/provision/add",
                                                          personLoc,
                                                          String.class);
            System.out.println("Result : " + result);
        }
    }

}
