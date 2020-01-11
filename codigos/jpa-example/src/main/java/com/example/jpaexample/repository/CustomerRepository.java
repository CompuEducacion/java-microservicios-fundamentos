package com.example.jpaexample.repository;

import com.example.jpaexample.bean.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String>{
}
