package com.example.jpaexample.repository;

import com.example.jpaexample.bean.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, String> {

}
