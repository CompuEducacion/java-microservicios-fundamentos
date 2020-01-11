package com.example.hello.service;

import com.example.hello.user.User;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public User retrieveUser(){
        return new User(null, "Jaime", new Date());
    }

    @GetMapping("/filtering-list")
    public List<User> retrieveSomsUsers(){
        List<User> users = Arrays.asList(
                new User(null, "Juanita", new Date()),
                new User(null, "Andrea", new Date()),
                new User(null, "Angelica", new Date())
        );
        return users;
    }

    @GetMapping("/filtering-2")
    public MappingJacksonValue retrieveUserFiltered(){
        User user = new User(null, "Jaime", new Date());
        SimpleBeanPropertyFilter filter =
                SimpleBeanPropertyFilter.filterOutAllExcept("id", "name");
        FilterProvider filters = new SimpleFilterProvider().addFilter("FirstDynamicFilter", filter);
        MappingJacksonValue mapping = new MappingJacksonValue(user);
        mapping.setFilters(filters);
        return mapping;
    }
}
