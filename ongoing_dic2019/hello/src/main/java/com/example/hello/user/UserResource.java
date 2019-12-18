package com.example.hello.user;

import com.example.hello.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserResource {
    @Autowired
    private UserDaoService service;

    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable(name="id") int userid){
        User user = service.findOne(userid);
        if(user == null){
            throw new UserNotFoundException("id - " + userid);
        }
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<Object> create(@RequestBody User user){
        User savedUser = service.save(user);

        URI location = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
