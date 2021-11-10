package com.training.rest.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "person-query-client", url = "http://127.0.0.1:8080")
@RequestMapping("/tcee/api/v1/person/query")
public interface IPersonQueryClient {

    @GetMapping("/get/one")
    public Person getOne(@RequestParam("username") final String username);

    @GetMapping("/get/all")
    public List<Person> getAll();

    @GetMapping("/get/by/surname")
    public List<Person> getBySurname(@RequestParam("surname") final String surname);
}
