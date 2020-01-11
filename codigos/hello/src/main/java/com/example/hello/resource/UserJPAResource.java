package com.example.hello.resource;

import com.example.hello.exceptions.UserNotFoundException;
import com.example.hello.repository.UserRepository;
import com.example.hello.user.User;
import com.example.hello.user.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserJPAResource {
    @Autowired
    private UserRepository service;

    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable(name="id") int userid){
        Optional<User> opUser = service.findById(userid);
        User user = null;
        if(opUser.isPresent()){
            user = opUser.get();
        }else{
            throw new UserNotFoundException("id - " + userid);
        }
        //HATEOAS
        EntityModel<User> emodel =  new EntityModel<>(user);
        ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(
                ControllerLinkBuilder.methodOn(this.getClass()).create(user) );
        emodel.add(linkTo.withRel("all-users"));
        return emodel;
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<Object> create(@Valid @RequestBody User user){
        User savedUser = service.save(user);

        URI location = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id){
        Optional<User> opUser = service.findById(id);
        User user = null;
        if(opUser.isPresent()){
            service.deleteById(id);
        }else{
            throw new UserNotFoundException("id - " + id);
        }
    }
}
