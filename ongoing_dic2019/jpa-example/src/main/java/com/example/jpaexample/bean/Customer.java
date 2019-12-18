package com.example.jpaexample.bean;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
    @Id
    @Column(name = "SSN")
    private String id;

    @Column(name="CUST_NAME")
    private String name;

    private String address;

    @ManyToMany
    @JoinTable(name="Customer_Stock",
            joinColumns = @JoinColumn(name="customerId"),
            inverseJoinColumns = @JoinColumn(name="stockId")
    )
    List<Stock> stocks = new ArrayList<>();

    public Customer() {
    }

    public Customer(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
