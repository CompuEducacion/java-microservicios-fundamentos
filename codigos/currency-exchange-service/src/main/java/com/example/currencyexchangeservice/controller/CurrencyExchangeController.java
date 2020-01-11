package com.example.currencyexchangeservice.controller;

import com.example.currencyexchangeservice.bean.ExchangeValue;

import com.example.currencyexchangeservice.repository.ExchangeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @Autowired
    private ExchangeValueRepository repository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(
                @PathVariable String from,
                @PathVariable String to){


        int port = Integer.parseInt(environment.getProperty("local.server.port"));


        Optional<ExchangeValue> opValue =
                        repository.findExchangeValueByFromAndTo(from, to);

        if(opValue.isPresent()){
            ExchangeValue exValue = opValue.get();
            exValue.setPort(port);
            return exValue;
        }
        return null;
    }
}
