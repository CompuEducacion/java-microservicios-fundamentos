package com.example.currencyexchangeservice.repository;

import com.example.currencyexchangeservice.bean.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExchangeValueRepository
        extends JpaRepository <ExchangeValue, Long>{

    Optional<ExchangeValue> findExchangeValueByFromAndTo(String from, String to);
}
