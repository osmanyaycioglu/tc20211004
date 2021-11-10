package com.training.rest.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "person-client", url = "http://127.0.0.1:8080")
@RequestMapping("/tcee/api/v1/person/provision")
public interface IPersonclient {

    @PostMapping("/add")
    public String add(final Person person) throws RestClientExp;

    @GetMapping("/remove")
    public String remove(@RequestParam("name") final String name) throws RestClientExp;

}
