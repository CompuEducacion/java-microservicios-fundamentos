package com.example.jpaexample;

import com.example.jpaexample.bean.Customer;
import com.example.jpaexample.bean.Stock;
import com.example.jpaexample.repository.CustomerRepository;
import com.example.jpaexample.repository.StockRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Optional;

@Component
public class BrokerToolCommandLineRunner implements CommandLineRunner {

    private static final Logger log =
            LoggerFactory.getLogger(BrokerToolCommandLineRunner.class);

    /*
    @Autowired

    private UserDaoService userDaoService;
    */

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private StockRepository stockRepository;

    @Override
    public void run(String... args) throws Exception {


        Stock stock =  new Stock("ORCL", "Oracle Stock");
        Customer customer = new Customer("1", "John", "Address");

        customerRepository.save(customer);
        stockRepository.save(stock);

        customer.addStock(stock);
        stock.addCustomer(customer);

        customerRepository.save(customer);
        stockRepository.save(stock);

        //long id = userDaoService.insert(user);
        /*
        stockRepository.save(stock);
        log.info("@#@# New user created " + stock);
        customerRepository.save(customer);
        log.info("@#@# New user created " + customer);
        /*
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
        */

    }

}
