package com.example.jpaexample;

import com.example.jpaexample.service.UserDaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserDAOServiceCommandLineRunner implements CommandLineRunner {

    private static final Logger log =
            LoggerFactory.getLogger(UserDAOServiceCommandLineRunner.class);

    /*
    @Autowired

    private UserDaoService userDaoService;
    */

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user =  new User("Jack", "Admin");
        User user2 =  new User("John", "Smith");
        //long id = userDaoService.insert(user);
        userRepository.save(user);
        log.info("@#@# New user created " + user);
        userRepository.save(user2);
        log.info("@#@# New user created " + user2);
        Optional<User> opUser1 = userRepository.findById(1L);
        log.info("@#@# User Found " + opUser1.get());
        Optional<User> opUser2 = userRepository.findById(2L);
        log.info("@#@# User Found " + opUser2.get());
        //Getting All Users...
        List<User> allUsers = userRepository.findAll();
        for(User u : allUsers){
            log.info("@#@# User currently in DB: " + u);
        }
        //delete user with id=2
        userRepository.deleteById(2L);
        //Getting All Users...
        allUsers = userRepository.findAll();
        for(User u : allUsers){
            log.info("@#@# User currently in DB: " + u);
        }
        opUser1 = userRepository.findById(1L);
        User user1 = opUser1.get();
        log.info("@#@# User Found " + user1);
        user1.setName("Juan");
        user1.setRole("Contractor");
        userRepository.save(user1);
        allUsers = userRepository.findAll();
        for(User u : allUsers){
            log.info("@#@# User currently in DB: " + u);
        }
    }

}
